import java.lang.Math;

public class Quick {
    
    public static int part(int[] data, int start, int end){
	int range = (end - start) + 1;
	int rand = (int)(Math.random() * range) + start;
	int num = data[rand];
	System.out.println("\n"+num);
	int s = start;
	int e = end;
	int i = start+1;
	swap(data,rand,start);
	System.out.println("s = "+start);
	System.out.println("e = "+end);
	while (i<=e) {
	    //System.out.println("\ns = "+s);
	    //System.out.println("e = "+e);
	    //System.out.println("i = "+i);
	    //System.out.println("rand = "+rand);
	    //System.out.println("n = "+n);
	    //System.out.println(toString(data));
	    //System.out.println(data[i]);
	    if (data[i] == num ) {
		i++;
	    }
	    else if (data[i] < num) {
	        swap(data,s,i);
		s++;
		i++;
	    }
	    else {
		swap(data,i,e);
		e--;
	    }
		
	}
	//System.out.println("final\n"+toString(data));
	return e;
    }

    public static int quickselect(int[] data, int k){
	return quickselect(data,k,0,data.length-1);
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
    }

    public static int quickselect(int[] data, int k, int lo, int hi) {
	int i = part(data,lo,hi);
	if (k < i) {
	    return quickselect(data,k,lo,i-1);
	}
	else if (k > i) {
	    return quickselect(data,k,i+1,hi);
	}
	return data[k];
    }

    public static String toString(int[] s) {
	String ans = "";
	for (int r = 0; r < s.length; r++) {
	    ans += s[r];
	    ans += ", ";
	}
	return ans;
    }

    public static void quicksort(int[] A) {
	quicksort(A, 0, A.length-1);
    }
    
    private static void quicksort(int[] data, int start, int end) {
	if (start < end) {
	    int range = (end - start) + 1;
	    int rand = (int)(Math.random() * range) + start;
	    int num = data[rand];
	    int s = start;
	    int e = end;
	    int i = start+1;
	    swap(data,rand,start);
	    //System.out.println("num = "+num);
	    //System.out.println("s = "+start);
	    //System.out.println("e = "+end);
	    while (i<=e) {
		//System.out.println("\ns = "+s);
		//System.out.println("e = "+e);
		//System.out.println("i = "+i);
		//System.out.println(toString(data));
		//System.out.println(data[i]);
		if (data[i] == num ) {
		    if (i == s+1) {
			s++;
		    }
		    i++;
		}
		else if (data[i] < num) {
		    swap(data,s,i);
		    s++;
		    i++;
		}
		else {
		    swap(data,i,e);
		    e--;
		}
		
	    }
	    quicksort(data, start, s-1);
	    quicksort(data, e+1, end);
	}
    }

    private static void swap (int[] arr, int a, int b) {
	int temp = arr[b];
	arr[b] = arr[a];
	arr[a] = temp;
    }

    public static void main(String[] args) {
	for (int st = 0; st < 10; st++) {
	    for (int en = st; en < 9; en++) {
		int[] n = new int[100];
		for (int i = 0; i < n.length; i++) {
		    n[i] = (int)(Math.random() * 10);
		}
		quicksort(n);
		System.out.println("");
		System.out.println(toString(n));
	    }
	}
	    /*int[] n = new int[100];
	for (int i = 0; i < n.length; i++) {
	    n[i] = (int)(Math.random() * 5);
	}
	System.out.println(toString(n));
	quicksort(n);
	System.out.println(toString(n));
	*/
	/*int[]ary = { 2, 10, 15, 23, 0,  5};
	  System.out.println(quickselect( ary , 0 )); //would return 0
	  System.out.println(quickselect( ary , 1 ));  //would return 2
	  System.out.println(quickselect( ary , 2 ));  //would return 5
	  System.out.println(quickselect( ary , 3 ));  //would return 10
	  System.out.println(quickselect( ary , 4 ));  //would return 15
	  System.out.println(quickselect( ary , 5 ));  //would return 23*/
    }
    
}
