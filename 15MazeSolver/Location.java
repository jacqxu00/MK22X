public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private int distToGoal;
    private int distToStart;
    private int totalDist;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location prev, int distStart, int distGoal, boolean a) {
	row = r;
	col = c;
	previous = prev;
	distToGoal = distGoal;
	distToStart = distStart;
	aStar = a;
    }
    
    public int getDistStart() {
	return distToStart;
    }

    public int getDistGoal() {
	return distToGoal;
    }

    public int row() {
	return row;
    }

    public int col() {
	return col;
    }

    public Location getPrev() {
	return previous;
    }

    public String toString() {
	return "("+row+","+col+")";
    }
    
    public int compareTo(Location other) {
	if (aStar) {
	    return distToStart+distToGoal-other.getDistStart()-other.getDistGoal();
	}
	else {
	    return distToGoal-other.getDistGoal();
	}
    }
}
