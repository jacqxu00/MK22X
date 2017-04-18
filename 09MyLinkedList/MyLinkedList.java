import java.util.*;
public class MyLinkedList implements Iterable<Integer> {

    private class LNode{
	LNode next,prev;
	int value;

	public LNode(int value){
	    this.value=value;
	}

	public String toString(){
	    String ans = "";
	    if (prev == null) {
		ans += "(null)";
	    }
	    else {
		ans += "("+prev.value+")";
	    }
	    ans += value;
	    if (next == null) {
		ans += "(null)";
	    }
	    else {
		ans += "("+next.value+")";
	    }
	    return ans;
	}
    }

    public class MyLinkedListIterator implements Iterator<Integer> {
	public MyLinkedList list;
	public LNode node;
    
	public MyLinkedListIterator(MyLinkedList l, int i){
	    list = l;
	    node = l.getNthNode(i);
	}

	public boolean hasNext(){
	    return node != null;
	}

	public Integer next(){
	    if(hasNext()){
		Integer ans = node.value;
		node = node.next;
		return ans;
	    }
	    else{
		throw new NoSuchElementException();
	    }
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    LNode head,tail;
    int size;

    public MyLinkedList(){
	size = 0;
    }

    public int size(){
	return size;
    }

    private boolean inList(LNode a) {
	boolean ans = false;
	LNode node = head;
	for (int i = 0; i < size; i++) {
	    node = node.next;
	    ans = ans || (node==a);
	}
	return ans;
    }
	
    private LNode getNthNode(int n){
	//System.out.println("Size "+size);
	//System.out.println("n "+n);
        if (n < 0 || n >= size) {
	    throw new IndexOutOfBoundsException("Index out of Bounds");
	}
	LNode ans;
	//if (size/n == 2) {
	ans = head;
	for (int i = 0; i < n; i++) {
	    ans = ans.next;
	}
	/*}
	  else {
	  ans = tail;
	  for (int i = size-1; i > size - n; i++) {
	  ans = ans.prev;
	  }
	  }*/
	return ans;	    
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if (location == null || toBeAdded == null) {
	    throw new NullPointerException("Null LNode");
	}
	if (!inList(toBeAdded)) {
	    if (location == tail) {
		location.next = toBeAdded;
		toBeAdded.prev = location;
	        tail = toBeAdded;
		size++;
	    }
	    else {
		toBeAdded.next = location.next;
		location.next.prev = toBeAdded;
		location.next = toBeAdded;
		toBeAdded.prev = location;
		size++;
	    } 
	}
    }

    private void remove(LNode target){
	if (tail == target) {
	    //System.out.println("tail");
	    target.prev.next = null;
	    tail = target.prev;
	}
	else if (head == target) {
	    //System.out.println("head");
	    target.next.prev = null;
	    head = target.next;
	}
	else {
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
	size--;
    }

    public String toString() {
	String ans = "[";
	for (int i = 0; i < size; i++) {
	    ans += " ";
	    ans += getNthNode(i).toString();
	    if (i < size-1) {
		ans += ",";
	    }
	}
	return ans+"]";
    }

    public boolean add(int value){
	//System.out.println("value "+value);
	//System.out.println("size "+size);
	add(size, value);
	return true;
    }

    public int get(int index){
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException("Index out of Bounds");
	}
	else {
	    return getNthNode(index).value;
	}
    }

    public int set(int index, int val){
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException("Index out of Bounds");
	}
	else {
	    getNthNode(index).value = val;
	    return val;
	}
    }

    public int indexOf(int value){
	int ans = 0;
	LNode node = head;
	try {
	    while (node.value != value){
		node = node.next;
		ans++;
	    }
	    return ans;
	}
	catch (NullPointerException e){
	    return -1;
	}
    }

    public int remove(int index){
	LNode cur = getNthNode(index);
	//System.out.println("removing: "+cur.toString());
	remove(cur);
	return cur.value;
    }

    public void add(int index,int value){
	//System.out.println("index "+index);
	//System.out.println("value "+value);
	//System.out.println("size "+size);
	if (index > size || index < 0) {
	    throw new IndexOutOfBoundsException("Index out of Bounds");
	}
	else {
	    LNode cur = new LNode(value);
	    if (index == 0) {
		if (size == 0) {
		    head = cur;
		    tail = cur;
		    size++;
		}
		else {
		    cur.next = head;
		    head.prev = cur;
		    head = cur;
		    size++;
		}
	    }
	    else if (index == size) {
		addAfter(tail,cur);
	    }
	    else {
		addAfter(getNthNode(index-1),cur);
	    }
	}
    }

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this, 0);
    }

    public static void main(String[] args) {
	MyLinkedList a = new MyLinkedList();
	System.out.println(a.toString());
	a.add(0);
	System.out.println(a.toString());
	a.add(2);
	System.out.println(a.toString());
	a.add(1,1);
	System.out.println(a.toString());
	a.add(3,3);
	System.out.println(a.toString());
	a.add(4);
	System.out.println(a.toString());
	a.remove(0);
	System.out.println(a.toString());
	a.remove(3);
	System.out.println(a.toString());
	a.remove(1);
	System.out.println(a.toString());
	a.add(1,7);
	System.out.println(a.get(1));
	a.set(1,2);
	System.out.println(a.get(1));
	System.out.println(a.indexOf(1));
	System.out.println(a.toString());
        Iterator<Integer> test = a.iterator();
        while(test.hasNext()){
            System.out.println(test.next());
        }
    }

}
