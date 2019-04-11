import java.util.Scanner;

public class PopStar extends Creature {
    public PopStar(){
        name = "Pop Star";
    }

    @Override
    public void move(Level.Room playerRoom) {
        if (currentRoom.equals(playerRoom)) return;
        Level.Room sharedNeighbor = getSharedNeighbor(playerRoom);
        if (sharedNeighbor != null) currentRoom = sharedNeighbor;

    }

    @Override
    public void interact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello <3, my adoring fan! Would you like an autograph? Or a photo perhaps? (respond yes or no)");
        String response = scanner.nextLine();
        if(response.equals("no")){
            System.out.println("NooOoOOooo!");
            die();
        }
    }

    private void die() {
        System.out.println("*" + name +  " dies*");
        currentRoom.removeCreature(name);
    }
}
