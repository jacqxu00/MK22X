import java.util.*;

public class FrontierQueue implements Frontier {
    private List<Location> locations;
    private int index;

    public FrontierQueue() {
	locations = new LinkedList<Location>();
	index = 0;
    }
    
    public void add(Location a) {
	locations.add(a);
    }

    public Location next() {
	Location ans = locations.get(index);
	index++;
        return ans;
    }
    

}
