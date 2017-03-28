public class Merge {

    public static void merge(int[] a, int[] b, int[] destination) {
	int ai = 0;
	int bi = 0;
	int di = 0;
	while (ai < a.length && bi < b.length) {
	    if (a[ai]>b[bi]) {
		destination[di] = b[bi];
		bi++;
	    }
	    else {
		destination[di] = a[ai];
		ai++;
	    }
	    di++;
	}
	while (ai < a.length) {
	    destination[di] = a[ai];
	    di++;
	    ai++;
	}
	while (bi < b.length) {
	    destination[di] = b[bi];
	    di++;
	    bi++;
	}
    }

    public static int[] mergesort(int[] data) {
	if (data.length == 1) {
	    return data;
	}
	else {
	    int[] left = new int[data.length/2];
	    int[] right = new int[data.length - left.length];
	    int n = 0;
	    for (int i = 0; i < data.length; i++) {
		if (i < left.length) {
		    left[i] = data[i];
		}
		else {
		    right[n] = data[i];
		    n++;
		}
	    }
	    int[] a = new int[data.length/2];
	    a = mergesort(left);
	    int[] b = new int[data.length - a.length];
	    b = mergesort(right);
	    merge(a,b,data);
	    return data;
	}
    }

    public static String toString(int[] s) {
	String ans = "";
	for (int r = 0; r < s.length; r++) {
	    ans += s[r];
	    ans += ", ";
	}
	return ans;
    }

    public static void main(String[] args) {
	/*int[] n = {8,3,4,2,5,1,0,7,6,9};
	mergesort(n);
	System.out.println(toString(n));*/
	int[] n = new int[1000];
	for (int i = 0; i < n.length; i++) {
	    n[i] = (int)(Math.random() * 10);
	}
	mergesort(n);
	System.out.println("");
	System.out.println(toString(n));
    }
}
