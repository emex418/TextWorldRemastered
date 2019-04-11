import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private HashMap<String, Room> rooms;
    public Level() {
        rooms = new HashMap<>();
    }

    public void addRoom(String name) {
        rooms.put(name, new Room(name, new ArrayList<>(), new ArrayList<>()));
    }

    public void addRoom(Room newRoom) {
        rooms.put(newRoom.getName(), newRoom);
    }

    public void addDirectedEdge(String name1, String name2) {
        Room room1 = rooms.get(name1);
        Room room2 = rooms.get(name2);
        room1.addNeighbor(room2);
        room2.addNeighbor(room1);
    }

    public Room getRoom(String name) {
        return rooms.get(name);
    }


    public void addUndirectedEdge(String name1, String name2) {
        Room room1 = rooms.get(name1);
        Room room2 = rooms.get(name2);
        room1.addNeighbor(room2);
    }


    public static class Room {
        private String name;
        private HashMap<String, Room> neighbors = new HashMap<>();
        private ArrayList<Item> items = new ArrayList<>();
        private ArrayList<Creature> creatures = new ArrayList<>();

        public Room(String name, ArrayList<Item> items, ArrayList<Creature> creatures) {
            this.items.addAll(items);
            this.creatures.addAll(creatures);
            for (Creature c: creatures) {
                c.setCurrentRoom(this);
            }
            this.name = name;
        }


        public String getName() {
            return name;
        }

        //NEIGHBORS//

        public void addNeighbor(Room n) {
            neighbors.put(n.getName(), n);
        }

        public void setName(String name) {
            this.name = name;
        }

        public Room getNeighbor(String name) {
            return neighbors.get(name);
        }

        public void removeNeighbor(String name) {
            neighbors.remove(name);
        }

        public Room getRandomNeighbor() {
            ArrayList<Room> list = (ArrayList<Room>) neighbors.values();
            int rand = (int) Math.random() * list.size();
            return list.get(rand);
        }

        public HashMap<String, Level.Room> getNeighbors() {
            return neighbors;
        }

        public void displayNeighbors() {
            System.out.print("Neighbors: \t");
            for (Room temp : neighbors.values()) {
                System.out.print(temp.getName() + ", ");
            }
            System.out.println();
        }

        //ITEMS//

        public ArrayList<Item> getItems() {
            return items;
        }

        public Item getItem(String itemName) {
            for (Item i : items) {
                if (i.getName().equals(itemName)) {
                    return i;
                }
            }
            System.out.println(itemName + " does not exist");
            return null;
        }

        public void displayItems() {
            System.out.println("\n Items in " + name + ": ");
            for (Item temp : items) {
                System.out.println(temp.getName() + "\t" + temp.getDescription());
            }
        }

        public String getItemNames() {
            String output = "";
            for (Item temp : items) {
                output += temp.getName() + ", ";
            }
            return output;
        }

        public void addItem(Item newItem) {
            items.add(newItem);
        }

        public void addItem(String name, String description) {
            Item newItem = new Item(name, description);
            System.out.println(newItem);
            items.add(newItem);
        }

        public Item removeItem(String itemName) {
            Item out = getItem(itemName);
            if (items.remove(out) == true) {
                return out;
            }
            return null;
        }

        public boolean destroyItem() {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(name)) {
                    items.remove(i);
                    return true;
                }
            }
            return false;
        }

        //CREATURES//

        public void addCreature(Creature c) {
            creatures.add(c);
        }

        public Creature removeCreature(String name) {
            for (Creature c : creatures) {
                if (c.getName().equals(name)) {
                    creatures.remove(c);
                    return c;
                }
            }
            System.out.println("There is no " + name + "creature in " + this.name);
            return null;
        }

        public ArrayList<Creature> getCreatures() {
            return creatures;
        }

        public void displayCreatures() {
            if (creatures.size() == 0) {
                System.out.println("There are no creatures in this room");
                return;
            }
            for (Creature c :
                    creatures) {
                System.out.print(c.getName() + ", ");
            }
        }
    }
}
