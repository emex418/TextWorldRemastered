public class Chicken extends Creature {
    public Chicken(Level.Room startRoom) {
        this.currentRoom = startRoom;
        name = "chicken";
    }

    @Override
    public void move(Level.Room playerRoom) {
        moveToRandomRoom();
    }

    @Override
    public void interact() {
        System.out.println("BOCK!! BOCKBOCK!!");
    }

}
