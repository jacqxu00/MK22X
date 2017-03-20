import java.lang.Math;

public class Quick {
    
    public static int part(int[] data, int start, int end){
	int range = (end - start) + 1;
	int rand = (int)(Math.random() * range) + start;
	int num = data[rand];
	data[rand] = data[start];
	data[start] = num;
	rand = start;
	//System.out.println("\n"+num);
	int s = start+1;
	int e = end;
	int i = start+1;
	//System.out.println("s = "+start);
	//System.out.println("e = "+end);
	for (int n = start+1; n <= end; n++) {
	    //System.out.println("\ns = "+s);
	    //System.out.println("e = "+e);
	    //System.out.println("i = "+i);
	    //System.out.println("rand = "+rand);
	    //System.out.println("n = "+n);
	    //System.out.println(toString(data));
	    //System.out.println(data[i]);
	    int rec = data[i];
	    if (data[i] <= num ) {
		//System.out.println("smaller");
		data[i] = data[s];
		data[s] = rec;
		s++;
		i++;
	    }
	    else {
		//System.out.println("bigger");
		data[i] = data[e];
		data[e] = rec;
		e--;
	    }
	}
	int temp = data[s-1];
	data[s-1] = num;
	data[rand] = temp;
	//System.out.println("final\n"+toString(data));
	return s-1;
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
    
    private static void quicksort(int[] A, int s, int e) {
	if (s < e) {
	    int pivot = part(A, s, e);
	    quicksort(A, s, pivot-1);
	    quicksort(A, pivot+1, e);
	}
    }

    public static void selectionSort(int[] data){
	if (data.length > 1) {
	    for (int i = 0; i < data.length - 1; i++) {
		int smallest = data[i];
		int smallind = i;
		for (int j = i+1; j < data.length; j++) {
		    if (data[j] < smallest) {
			smallest = data[j];
			smallind = j;
		    }
		}
	   
		if (smallest != data[i]) {
		    data[smallind] = data[i];
		    data[i] = smallest;
		}
	    }
	}
    }

    public static void main(String[] args) {
	for (int st = 0; st < 9; st++) {
	    for (int en = st; en < 9; en++) {
		int[] n = new int[10];
		for (int i = 0; i < n.length; i++) {
		    n[i] = (int)(Math.random() * 100);
		}
		quicksort(n);
		System.out.println("");
		System.out.println(toString(n));
		System.out.println(part(n,st,en));
	    }
	}
	/*int[]ary = { 2, 10, 15, 23, 0,  5};
	  System.out.println(quickselect( ary , 0 )); //would return 0
	System.out.println(quickselect( ary , 1 ));  //would return 2
	System.out.println(quickselect( ary , 2 ));  //would return 5
	System.out.println(quickselect( ary , 3 ));  //would return 10
	System.out.println(quickselect( ary , 4 ));  //would return 15
	System.out.println(quickselect( ary , 5 ));  //would return 23*/
    }
    
}
