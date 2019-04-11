public class PickUp implements Command {
    @Override
    public void excecute(Level level, Player player, String response) {
        String[] words = response.split(" ");
        player.addItem(player.getCurrentRoom().removeItem(words[2]));
        player.displayInventory();
    }
}
