public class MyHeap {
    private int constant;
    private ArrayList<String> arr;

    public MyHeap() {
	arr = new ArrayList<String>;
	constant = 1;
    }

    public MyHeap(boolean a) {
	MyHeap();
	if (!a) {
	    constant = -1;
	}
    }

    public String peek() {
	return arr.get(1);
    }
    
    public void add(String s) {
	if (arr.size() == 0) {
	    arr.add(null);
	    arr.add(s);
	}
	else {
	    arr.add(s);
	    //pushup
	}
    }

    public String remove() {
	String ans = arr.remove(1);
	//pushdown
	return ans;
    }

    private void pushUp() {
    }

    private void pushDown() {
    }

}
