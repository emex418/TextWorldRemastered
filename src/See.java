public class See implements Command {

    @Override
    public void excecute(Level level, Player player, String response) {
        player.displayInventory();
    }
}
