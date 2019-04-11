import java.util.Scanner;

public class Interact implements Command {

    @Override
    public void excecute(Level level, Player player, String response) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which creature?");
        player.getCurrentRoom().displayCreatures();
        response = s.nextLine();
        //TODO: get response and run the interact method of the creature named that in current room
    }
}
