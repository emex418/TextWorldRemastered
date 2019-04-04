import java.util.ArrayList;

public class Level {
    ArrayList<Room> rooms;
    public Level() {
    }

    public void addRoom(String name) {
        rooms.add(new Room(name));
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
        for (Room temp: rooms) {
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        System.out.println("Created new node " + name);
        return new Room(name);
    }


    public static class Room {
        String name;
        ArrayList<Room> neighbors;

        private Room(String name) {
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Room n) {
            neighbors.add(n);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNeighborNames() {
            String output = "";
            for (Room temp : neighbors) {
                output += temp.getName();
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

        //Beware if you have multiple bedrooms, use unique naming
        public void removeNeighbor(String name) {
            for (Room temp : neighbors) {
                if (temp.getName().equals(name)) {
                    neighbors.remove(temp);
                }
            }
        }
    }
}
