import java.util.*;

public class MyLinkedListIterator implements Iterator<Integer> {
    public MyLinkedList list;
    public int element;
    public LNode node;
    
    public MyLinkedListIterator(MyLinkedList l, int i){
	list = s;
	element = i;
	node = l.getNthNode(element);
    }

    public boolean hasNext(){
	return element < MyLinkedList.size();
    }

    public String next(){
	if(hasNext()){
	    element++;
	    return node.getNext();
	}
	else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}
