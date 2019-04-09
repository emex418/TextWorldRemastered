import java.util.HashMap;

public abstract class Creature {
    protected String name;
    protected Level.Room currentRoom;

    public abstract void move(Level.Room playerRoom);
    public abstract void interact();

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void moveToRandomRoom(){
        Level.Room destination = currentRoom.getRandomNeighbor();
        currentRoom.removeCreature(name);
        currentRoom = destination;
    }

    public Level.Room getSharedNeighbor(Level.Room playerRoom){
        HashMap<String, Level.Room> pNeighbors = playerRoom.getNeighbors();
        for(Level.Room p : pNeighbors.values()){
            if(currentRoom.getNeighbors().containsValue(p)){
                return p;
            }
        }
        return null;
    }

}