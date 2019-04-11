public class View implements Command {

    @Override
    public void excecute(Level level, Player player, String response) {
        player.getCurrentRoom().displayItems();
    }
}
