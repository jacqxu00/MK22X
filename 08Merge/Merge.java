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
	    for (int i = 0; i < data.length; i++) {
		if (i < left.length) {
		    left[i] = data[i];
		}
		else {
		    right[i] = data[i];
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
}
