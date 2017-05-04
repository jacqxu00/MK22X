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
	    pushUp();
	}
    }

    public String remove() {
	if (arr.size() > 1) {
	    String ans = arr.remove(1);
	    swap(arr.size()-1,1);
	    pushDown;
	    return ans;
	}
    }

    private void pushUp() {
	int index = arr.size()-1;
	while (index/2 >= 1) {
	    while (arr.get(index).compareTo(arr.get(index/2))*constant < 0) {
		swap(index,index/2);
		index = index/2;
	    }
	}
    }

    private void pushDown() {
	int index = 1;
	while (arr.size() >= 2*index) {
	    if (arr.size() < 2*index+1) {
		if (arr.get(index).compareTo(arr.get(index*2)*constant > 0)) {
		    swap(index, index*2);
		    index = index*2;
		}
	    }
	    else {
		while (arr.get(index).compareTo(arr.get(index*2)*constant > 0) || arr.get(index).compareTo(arr.get(index*2+1)*constant > 0)) {
		    if (arr.get(index*2).compareTo(arr.get(index*2+1)) > 0) {
			swap(index, index*2);
			index = index*2;
		    }
		    else {
			swap(index, index*2+1);
			index = index*2+1;
		    }
		}
	    }
	}
    }

    private void swap(int a, int b) {
	String temp = arr.get(a);
	arr.add(a,arr.get(b));
	arr.add(b,temp);
    }

    public void main(String[] args) {
	
    }

}
