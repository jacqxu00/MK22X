import java.util.*;

public class QueueFrontier implements Frontier {
    List<Location> locations;

    public QueueFrontier() {
	locations = new LinkedList<Location>();
    }
    
    public void add(Location a) {
	locations.add(a);
    }

    public Location next() {
        return locations.get(0);
    }
    

}
