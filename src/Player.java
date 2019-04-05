import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    String name, description;
    Level.Room currentRoom;
    ArrayList<Item> inventory;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public Item removeItem(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name)) {
                return inventory.remove(i);
            }
        }
        System.out.println("There is no " + name + " in inventory");
        return null;
    }

    public boolean destroyItem(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name)) {
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void displayInventory() {
        System.out.println("Inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Item temp = inventory.get(i);
            System.out.println(temp.getName() + "\t" + temp.getDescription());
        }
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room newRoom) {
        this.currentRoom = newRoom;
    }

    public boolean moveToRoom(String name) {
        String[] neighborNames = currentRoom.getNeighborNames().split(",");
        for (String temp :
                neighborNames) {
            if (temp.equals(name)) {
                currentRoom = currentRoom.getNeighbor(temp);
                return true;
            }
        }
        return false;
    }

}
