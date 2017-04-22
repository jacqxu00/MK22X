import java.util.*;
public class MyDeque {
    String[] array;
    int size; int start; int end;

    public MyDeque(){
	array = new String[5];
	size = 0;
    }

    //The add methods:
    //These will add the element to the specified side. The deque will double capacity if there is no space left.
    //Throws: NullPointerException - if the specified element is null and this deque does not permit null elements
    public void addFirst(String s) {
	if (s == null) {
	    throw new NullPointerException("string is null");
	}
	else {
	    extendArray();
	    if (size==0) {
		array[0] = s;
		start = 0;
		end = 0;
	    }
	    else {
		if (start == 0) {
		    System.out.println("here");
		    array[array.length-1] = s;
		    start = array.length - 1;
		}
		else {
		    array[start-1] = s;
		    start--;
		}
	    }
	    size++;
	}
    }
    
    public void addLast(String s) {
	if (s == null) {
	    throw new NullPointerException("string is null");
	}
	else {
	    extendArray();
	    if (size==0) {
		array[0] = s;
		start = 0;
		end = 0;
	    }
	    else {
		if (end + 1 == array.length) {
		    array[0] = s;
		    end = 0;
		}
		else {
		    array[end+1] = s;
		    end++;
		}
	    }
	    size++;
	}
    }

    private void extendArray() {
	if (size == array.length) {
	    String[] temp = new String[size*2];
	    if (start <= end) {
		for (int i = 0; i < array.length; i++) {
		    temp[i] = array[i];
		}
		array = temp;
	    }
	    else {
		int backlength = array.length - start;
		for (int s = start; s < array.length; s++) {
		    int startlength = array.length - s;
		    temp[temp.length-startlength] = array[s];
		}
		start = temp.length - backlength;
		for (int e = 0; e <= end; e++) {
		    temp[e] = array[e];
		}
		array = temp;
	    }
	}
    }
    

    //The remove methods:
    //These will retrieve and remove the element from the specified side.
    //Throws: NoSuchElementException - if this deque is empty
    public String removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException("deque is empty already");
	}
	String ans = array[start];
	array[start] = null;
	if (start == array.length-1) {
	    start = 0;
	}
	else {
	    start++;
	}
	size--;
	return ans;
    }
    
    public String removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException("deque is empty already");
	}
	String ans = array[end];
	array[end] = null;
	if (end == 0) {
	    end = array.length - 1;
	}
	else {
	    end--;
	}
	size--;
	return ans;
    }
    

    //The get methods:
    //These will retrieve but not remove the element from the specified side.
    //Throws: NoSuchElementException - if this deque is empty
    public String getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException("deque is empty");
	}
	else {
	    return array[start];
	}
    }
    
    public String getLast() {
	if (size == 0) {
	    throw new NoSuchElementException("deque is empty");
	}
	else {
	    return array[end];
	}
    }

    public String toString() {
	//System.out.println("\nsize "+size);
	//System.out.println("start "+start);
	//System.out.println("end "+end);
	String ans = "";
	for (int i = 0; i < array.length; i++) {
	    ans += array[i]+", ";
	}
	return ans;
    }

    public static void main(String[] args) {
	MyDeque a = new MyDeque();
	a.addLast("hello");
	System.out.println(a.toString());
	a.addFirst("jackie");
	System.out.println(a.toString());
	a.addLast("my");
	System.out.println(a.toString());
	a.addLast("name");
	System.out.println(a.toString());
	a.addFirst("is");
	System.out.println(a.toString());
	a.removeLast();
	System.out.println(a.toString());
	a.removeLast();
	System.out.println(a.toString());
	a.removeLast();
	System.out.println(a.toString());
	a.removeFirst();
	System.out.println(a.toString());
	a.addLast("me");
	System.out.println(a.toString());
    }
    
    
}
