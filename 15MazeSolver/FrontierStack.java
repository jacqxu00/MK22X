import java.util.*;

public class FrontierStack implements Frontier {
    private Stack<Location> locations;

    public FrontierStack() {
	locations = new Stack<Location>();
    }
    
    public void add(Location a) {
	locations.push(a);
    }

    public Location next() {
        return locations.pop();
    }
    
}
