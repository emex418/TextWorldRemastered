import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play(createLevel1());
    }

    private static void play(Level level) {
        //TODO: possibly change it to an array or arrayList of command objects
        //TODO: make all humanPlayer variables getters and setters not public variables

        String response = ";";
        Scanner s = new Scanner(System.in);

        System.out.println("What is the name of your character? ");
        response = s.nextLine();
        Player humanPlayer = new Player(response, "");
        humanPlayer.setCurrentRoom(level.getRoom("root"));

        System.out.println("\nWelcome to Level 1! " + humanPlayer.name);

        do {

            System.out.println("\nYou are in the " + humanPlayer.currentRoom.getName());
            System.out.println("what do you want to do?");
            System.out.println("go to <room name>, look at neighbors, view room's items, pick up <item name>, see inventory, interact with creatures");
            response = s.nextLine();

            String[] words = response.split(" ");
            String firstWord = words[0];

            if (firstWord.equals("go")) {
                humanPlayer.moveToRoom(words[2]);
            } else if (firstWord.equals("look")) {
                System.out.println(humanPlayer.currentRoom.getNeighborNames());
            } else if (firstWord.equals("view")) {
                humanPlayer.currentRoom.displayItems();
            } else if (firstWord.equals("pick")) {
                humanPlayer.addItem(humanPlayer.currentRoom.removeItem(words[2]));
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

        root.addCreature(new Chicken(root));

        return level1;
    }
}
