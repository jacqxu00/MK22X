public class RunningMedian {
    MyHeap max;
    MyHeap min;

    public RunningMedian() {
	max = new MyHeap(false);
	min = new MyHeap(true);
    }

    public void add(int a) {
	if (max.getSize()==0 && min.getSize()==0) {
	    max.add(a);
	}
	else {
	    if (a > getMedian()) {
		min.add(a);
		while (min.getSize()-max.getSize()>1) {
		    max.add(min.remove());
		}
	    }
	    else {
		max.add(a);
		while (max.getSize()-min.getSize()>1) {
		    min.add(max.remove());
		}
	    }
	}
    }

    public double getMedian() {
	if (max.getSize()+min.getSize()==0) {
	    throw new NullPointerException("There are currently no values");
	}
	else if ((max.getSize()+min.getSize())%2==1) {
	    if (max.getSize()>min.getSize()) {
		return max.peek();
	    }
	    else {
		return min.peek();
	    }
	}
	else {
	    return (max.peek()+min.peek())*1.0/2;
	}
    }

   public String toString() {
	String ans = "max: ";
        ans += max;
	ans += "\nmin: ";
	ans += min;
	return ans;
   }
	
    public static void main(String[] args) {
	RunningMedian a = new RunningMedian();
	a.add(30);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(20);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(50);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(40);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(70);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(80);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(10);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(0);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(90);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(100);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
        a.add(60);
	System.out.println("Median: " + a.getMedian());
	System.out.println(a + "\n");
    }
    
}
