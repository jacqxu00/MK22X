import java.util.*;

public class FrontierPQ implements Frontier {
    private MyPQ locations;
    
    public class MyPQ {
	private ArrayList<Location> arr;

	public MyPQ() {
	    arr = new ArrayList<Location>();
	    arr.add(null);
	}

	public Location peek() {
	    return arr.get(1);
	}
    
	public void add(Location s) {
	    if (arr.size() == 1) {
		arr.add(s);
	    }
	    else {
		arr.add(s);
		pushUp();
	    }
	}

	public Location remove() {
	    if (arr.size() == 1) {
		throw new NullPointerException("Heap is currently empty");
	    }
	    Location ans = arr.get(1);
	    if (arr.size() == 2) {
		arr.remove(1);
	    }
	    else if (arr.size() > 2) {
		swap(arr.size()-1,1);
		arr.remove(arr.size()-1);
		pushDown();
	    }
	    return ans;
	}

	private void pushUp() {
	    int index = arr.size()-1;
	    while (index/2 > 0 && arr.get(index).compareTo(arr.get(index/2)) < 0) {
		swap(index,index/2);
		index = index/2;
	    }
	}

	private void pushDown() {
	    int index = 1;
	    while (arr.size()-1 >= 2*index) {
		if (arr.size()-1 < 2*index+1) {
		    if (arr.get(index).compareTo(arr.get(index*2)) > 0) {
			swap(index, index*2);
		    }
		    index = index*2;
		}
		else {
		    if (arr.get(index*2).compareTo(arr.get(index*2+1)) < 0) {
			swap(index, index*2);
			index = index*2;
		    }
		    else {
			swap(index, index*2+1);
			index = index*2+1;
		    
		    }
		}
		//System.out.println(index);
		//System.out.println(toString());
	    }
	}

	private void swap(int a, int b) {
	    Location temp = arr.get(a);
	    arr.set(a,arr.get(b));
	    arr.set(b,temp);
	}

	public int getSize() {
	    return arr.size() - 1;
	}

	public String toString() {
	    //System.out.println("\nsize "+size);
	    //System.out.println("start "+start);
	    //System.out.println("end "+end);
	    String ans = "";
	    for (int i = 0; i < arr.size(); i++) {
		ans += arr.get(i)+", ";
	    }
	    return ans;
	}

    }

    public FrontierPQ() {
	locations = new MyPQ();
    }
    
    public void add(Location a) {
	locations.add(a);
    }

    public Location next() {
        return locations.remove();
    }
    
}
