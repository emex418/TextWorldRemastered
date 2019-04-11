public class Go implements Command {
    @Override
    public void excecute(Level level, Player player, String response) {
        String[] words = response.split(" ");
        if (player.moveToRoom(words[2])) System.out.println("To the " + player.getCurrentRoom().getName() + "...");
    }
}
