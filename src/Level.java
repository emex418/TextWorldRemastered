import java.util.ArrayList;

public class Level {
    ArrayList<Room> rooms;

    public Level() {
        rooms = new ArrayList<>();
    }

    public void addRoom(String name) {
        rooms.add(new Room(name));
    }

    public void addRoom(Room newRoom) {
        rooms.add(newRoom);
    }

    public void addDirectedEdge(String name1, String name2) {
        Room room1 = getRoom(name1);
        Room room2 = getRoom(name2);
        room1.addNeighbor(room2);
        room2.addNeighbor(room1);

    }

    public void addUndirectedEdge(String name1, String name2) {
        Room room1 = getRoom(name1);
        Room room2 = getRoom(name2);
        room1.addNeighbor(room2);
    }

    public Room getRoom(String name) {
        for (Room temp : rooms) {
            if (temp.getName().equals(name)) {
                return temp;
            }
        }
        System.out.println("Created new node " + name);
        return new Room(name);
    }


    public static class Room {
        private String name;
        private ArrayList<Room> neighbors = new ArrayList<>();
        private ArrayList<Item> items = new ArrayList<>();
        private ArrayList<Creature> creatures = new ArrayList<>();

        public Room(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        //NEIGHBORS//

        public void addNeighbor(Room n) {
            neighbors.add(n);
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNeighborNames() {
            String output = "";
            for (Room temp : neighbors) {
                output += temp.getName() + ", ";
            }
            return output;
        }

        public Room getNeighbor(String name) {
            for (Room temp : neighbors) {
                if (temp.getName().equals(name)) {
                    return temp;
                }
            }
            return null;
        }

        public void removeNeighbor(String name) {
            for (Room temp : neighbors) {
                if (temp.getName().equals(name)) {
                    neighbors.remove(temp);
                }
            }
        }

        public Room getRandomNeighbor() {
            int rand = (int) Math.random() * neighbors.size();
            return neighbors.get(rand);
        }

        //ITEMS//

        public ArrayList<Item> getItems() {
            return items;
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

        public Item removeItem(String name) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(name)) {
                    return items.remove(i);
                }
            }
            System.out.println("There is no " + name + " in " + this.name);
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

        //Creatures//

        public Creature removeCreature(String name) {
            for (Creature c :
                    creatures) {
                if(c.getName().equals(name)){
                    creatures.remove(c);
                    return c;
                }
            }
            System.out.println("There is no " + name + "creature in " + this.name);
            return null;
        }
    }
}
