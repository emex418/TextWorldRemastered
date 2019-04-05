import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Chicken extends Creature {


    public Chicken(Level.Room startRoom) {
        this.currentRoom = startRoom;
        name = "chicken";
    }

    @Override
    public void move(Level.Room playerRoom) {
        Level.Room destination = playerRoom.getRandomNeighbor();
        currentRoom.removeCreature(name);
        currentRoom = destination;
    }

    @Override
    public void interact() {
    }

}
