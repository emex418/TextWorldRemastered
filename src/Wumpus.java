import java.util.Scanner;

public class Wumpus extends Creature {

    public Wumpus(Level.Room startRoom) {
        this.currentRoom = startRoom;
        name = "wumpus";
    }

    @Override
    public void move(Level.Room playerRoom) {
        Level.Room randomNeighbor = playerRoom.getRandomNeighbor();
        if (!randomNeighbor.equals(playerRoom)) {
            currentRoom.removeCreature(name);
            currentRoom = randomNeighbor;
        }
    }

    public void hunt() {
        int prob = (int) Math.random() * 10;
        if (prob < 7) {
            currentRoom.removeCreature(name);
            System.out.println("You have slayed " + name);
        } else {
            move(currentRoom);
            System.out.println(name + " escaped!!");
        }
    }

    @Override
    public void interact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello I am " + name);
        System.out.println("How would you like to interact with " + name + "? \n hunt, rename <new name>");
        String response = scanner.nextLine();
        if (response.equals("hunt")) {
            hunt();
        } else if(response.substring(0, 7).equals("rename")){
            name = response.substring(response.indexOf(" "));
        }else {
            System.out.println("You cannot " + response + " with the wumpus");
        }
    }
}
