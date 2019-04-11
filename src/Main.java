import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play(createLevel1());
    }

    private static void play(Level level) {
        //TODO: command HashMap and finish Main
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
                if (humanPlayer.moveToRoom(words[2])) System.out.println("To the " + humanPlayer.getCurrentRoom().getName() + "...");
            } else if (firstWord.equals("look")) {
                humanPlayer.getCurrentRoom().displayNeighbors();
            } else if (firstWord.equals("view")) {
                humanPlayer.getCurrentRoom().displayItems();
            } else if (firstWord.equals("pick")) {
                humanPlayer.addItem(humanPlayer.getCurrentRoom().removeItem(words[2]));
                humanPlayer.displayInventory();
            } else if (firstWord.equals("see")) {
                humanPlayer.displayInventory();
            } else if (firstWord.equals("interact")) {
                System.out.println("Which creature?");
                humanPlayer.getCurrentRoom().displayCreatures();
                response = s.nextLine();
                //TODO: get response and run the interact method of the creature named that in current room
            } else {
                System.out.println("You can; go to <room name>, look at neighbors, view room's items, pick up <item name>, see inventory, and interact with creatures");
            }

        } while (!response.equals("quit"));
    }

    private static Level createLevel1() {
        Level level1 = new Level();
        Level.Room root = new Level.Room("root", rootItemsList(), emptyCreaturesList());
        Level.Room garden = new Level.Room("garden", emptyItemsList(), gardenCreaturesList());
        Level.Room hall = new Level.Room("hall", emptyItemsList(), emptyCreaturesList());
        Level.Room diningRoom = new Level.Room("diningRoom", emptyItemsList(), emptyCreaturesList());
        Level.Room sittingRoom = new Level.Room("sittingRoom", emptyItemsList(), emptyCreaturesList());
        Level.Room kitchen = new Level.Room("kitchen", emptyItemsList(), emptyCreaturesList());
        Level.Room bedroom = new Level.Room("bedroom", emptyItemsList(), emptyCreaturesList());
        Level.Room bathroom = new Level.Room("bathroom", emptyItemsList(), emptyCreaturesList());

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

    private static ArrayList<Item> emptyItemsList() {
        return new ArrayList<>();
    }

    private static ArrayList<Item> rootItemsList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Painting", "portrait of an old woman"));
        items.add(new Item("Fountain", "3-tier fountain; pumps water"));
        items.add(new Item("Hand rail", "when you're going up the stairs, use this to support you"));
        return items;
    }

    private static ArrayList<Creature> emptyCreaturesList() {
        return new ArrayList<>();
    }

    private static ArrayList<Creature> gardenCreaturesList() {
        ArrayList<Creature> creatures = new ArrayList<>();
        creatures.add(new Chicken());
        creatures.add(new Wumpus());
        creatures.add(new PopStar());
        return creatures;
    }
}
