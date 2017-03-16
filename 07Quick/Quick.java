import java.lang.Math;

public class Quick {
    
    public static int part(int[] data, int start, int end){
	int range = (end - start) + 1;
	int rand = 0; //(int)(Math.random() * range) + start;
	int num = data[rand];
	System.out.println(num);
	int s = start;
	int e = end;
	int i = start;
	System.out.println("\ns = "+start);
	System.out.println("e = "+end);
	for (int n = start; n <= end; n++) {
	    //System.out.println("\ns = "+s);
	    //System.out.println("e = "+e);
	    //System.out.println("i = "+i);
	    //System.out.println("rand = "+rand);
	    //System.out.println("n = "+n);
	    //System.out.println(toString(data));
	    if (i != rand) {
		//System.out.println(data[i]);
		int rec = data[i];
		if (data[i] <= num ) {
		    //System.out.println("smaller");
		    data[i] = data[s];
		    data[s] = rec;
		    if (s == rand) {
			rand = i;
			n--;
		    }
		    if (s != i) {
			i--;
		    }
		    s++;
		}
		else {
		    //System.out.println("bigger");
		    data[i] = data[e];
		    data[e] = rec;
		    if (e == rand) {
			rand = i;
		    }
		    i--;
		    e--;
		}
	    }
	    i++;
	}
	System.out.println("final\n"+toString(data));
	data[s] = num;
	return s;
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
		selectionSort(n);
		System.out.println(toString(n));
		System.out.println(part(n,st,en));
	    }
	}
	//int[]ary = { 2, 10, 15, 23, 0,  5};
	/*System.out.println(quickselect( ary , 0 )); //would return 0
	System.out.println(quickselect( ary , 1 ));  //would return 2
	System.out.println(quickselect( ary , 2 ));  //would return 5
	System.out.println(quickselect( ary , 3 ));  //would return 10
	System.out.println(quickselect( ary , 4 ));  //would return 15
	System.out.println(quickselect( ary , 5 ));  //would return 23*/
    }
    
}
