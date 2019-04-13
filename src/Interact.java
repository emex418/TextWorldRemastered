import java.util.ArrayList;
import java.util.Scanner;

public class Interact implements Command {

    @Override
    public void excecute(Level level, Player player, String response) {
        Scanner s = new Scanner(System.in);
        System.out.println("Which creature?");
        player.getCurrentRoom().displayCreatures();
        response = s.nextLine();
        ArrayList<Creature> creatures = player.getCurrentRoom().getCreatures();
        for (Creature c : creatures) {
            if(c.getName().equals(response)){
                c.interact();
            }
        }
    }
}
