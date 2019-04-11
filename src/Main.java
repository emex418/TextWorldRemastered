import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play(createLevel1());
    }

    private static void play(Level level) {
        //TODO: command HashMap and finish Main
        //TODO: check to see that all HashMap things function correctly
        //Popstars move towards the player if they're within two steps of player
        //User can pick up and drop items
        //Game has a way to display what items and creatures are in a room

        String response = ";";
        Scanner s = new Scanner(System.in);

        System.out.println("What is the name of your character? ");
        response = s.nextLine();
        Player humanPlayer = new Player(response, "");
        humanPlayer.setCurrentRoom(level.getRoom("root"));

        System.out.println("\nWelcome to Level 1! " + humanPlayer.getName());

        do {

            System.out.println("\nYou are in the " + humanPlayer.getCurrentRoom().getName());
            System.out.println("what do you want to do?");
            System.out.println("go to <room name>, look at neighbors, view room's items, pick up <item name>, see inventory, interact with creatures");
            response = s.nextLine();

            String[] words = response.split(" ");
            String firstWord = words[0];

            if (firstWord.equals("go")) {
                humanPlayer.moveToRoom(words[2]);
            } else if (firstWord.equals("look")) {
                humanPlayer.getCurrentRoom().displayNeighbors();
            } else if (firstWord.equals("view")) {
                humanPlayer.getCurrentRoom().displayItems();
            } else if (firstWord.equals("pick")) {
                humanPlayer.addItem(humanPlayer.getCurrentRoom().removeItem(words[2]));
                humanPlayer.displayInventory();
            } else if (firstWord.equals("see")) {
                humanPlayer.displayInventory();
            } else if (firstWord.equals("interact")){
                System.out.println("Which creature?");
                humanPlayer.getCurrentRoom().displayCreatures();
                //TODO: interact with chickens
            } else {
                System.out.println("You can; go to <room name>, look at neighbors, view room's items, pick up <item name>, see inventory, and interact with creatures");
            }

        } while (!response.equals("quit"));
    }

    private static Level createLevel1() {
        Level level1 = new Level();
        Level.Room root = new Level.Room("root");
        Level.Room garden = new Level.Room("garden");
        Level.Room hall = new Level.Room("hall");
        Level.Room diningRoom = new Level.Room("diningRoom");
        Level.Room sittingRoom = new Level.Room("sittingRoom");
        Level.Room kitchen = new Level.Room("kitchen");
        Level.Room bedroom = new Level.Room("bedroom");
        Level.Room bathroom = new Level.Room("bathroom");

        level1.addRoom(root);
        level1.addRoom(garden);
        level1.addRoom(hall);
        level1.addRoom(diningRoom);
        level1.addRoom(sittingRoom);
        level1.addRoom(kitchen);
        level1.addRoom(bedroom);
        level1.addRoom(bathroom);

        level1.addUndirectedEdge("root", "garden");
        level1.addUndirectedEdge("root", "hall");
        level1.addUndirectedEdge("hall", "diningRoom");
        level1.addUndirectedEdge("hall", "sittingRoom");
        level1.addUndirectedEdge("hall", "bedroom");
        level1.addUndirectedEdge("diningRoom", "kitchen");
        level1.addUndirectedEdge("bedroom", "bathroom");
        level1.addUndirectedEdge("bathroom", "garden");

        root.addItem("lamp", "provides light");

        return level1;
    }
}
