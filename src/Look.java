public class Look implements Command {

    @Override
    public void excecute(Level level, Player player, String response) {
        player.getCurrentRoom().displayNeighbors();
    }
}
