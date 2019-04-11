public class Chicken extends Creature {
    public Chicken() {
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
