import java.util.*;

public class StackFrontier implements Frontier {
    Stack<Location> locations;

    public StackFrontier() {
	locations = new Stack<Location>();
    }
    
    public void add(Location a) {
	locations.push(a);
    }

    public Location next() {
        return locations.pop();
    }
    
}
