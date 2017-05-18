import java.util.*;

public class MyHeap {
    private int constant;
    private ArrayList<Integer> arr;

    public MyHeap() {
	arr = new ArrayList<Integer>();
	arr.add(null);
	constant = 1;
    }

    public MyHeap(boolean a) {
	this();
	if (!a) {
	    constant = -1;
	}
    }

    public int peek() {
	return arr.get(1);
    }
    
    public void add(int s) {
	if (arr.size() == 1) {
	    arr.add(s);
	}
	else {
	    arr.add(s);
	    pushUp();
	}
    }

    public int remove() {
	if (arr.size() == 1) {
	    throw new NullPointerException("Heap is currently empty");
	}
	int ans = arr.get(1);
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
	while (index/2 > 0 && (arr.get(index)-arr.get(index/2))*constant < 0) {
	    swap(index,index/2);
	    index = index/2;
	}
    }

    private void pushDown() {
	int index = 1;
	while (arr.size()-1 >= 2*index) {
	    if (arr.size()-1 < 2*index+1) {
		if ((arr.get(index)-arr.get(index*2))*constant > 0) {
		    swap(index, index*2);
		}
		index = index*2;
	    }
	    else {
		if ((arr.get(index*2)-arr.get(index*2+1))*constant < 0) {
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
	int temp = arr.get(a);
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
    
    public static void main(String[] args) {
	MyHeap heap = new MyHeap(true);
	//heap.remove();
	heap.add(5);
	System.out.println(heap + "\n");
	heap.remove();
	System.out.println(heap + "\n");
	heap.add(5);
	System.out.println(heap + "\n");
	heap.add(2);
	System.out.println(heap + "\n");
	heap.add(4);
	System.out.println(heap + "\n");
	heap.add(8);
	System.out.println(heap + "\n");
	heap.add(7);
	System.out.println(heap + "\n");
	heap.add(6);
	System.out.println(heap + "\n");
	heap.add(1);
	System.out.println(heap + "\n");
	heap.add(3);
	System.out.println(heap + "\n");
	heap.add(9);
	System.out.println(heap + "\n");
	heap.remove();
	System.out.println(heap + "\n");
	heap.remove();
	System.out.println(heap + "\n");
	System.out.println("size: " + heap.getSize());
    }

}
