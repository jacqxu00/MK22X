public class Recursion{
    
    public static String name(){
	return "Xu,Jackie";
    }
    
    public static double sqrt(double n){
	return sqrtH(n,1);
    }

    private static double sqrtH(double n, double guess){
	if (percDiff(guess*guess,n)<=0.000000000000001 && percDiff(guess*guess,n)>=-0.000000000000001) {
	    return guess;
	}
	else {
	    double betterG = (n*1.0/guess + guess)/2.0;
	    return sqrtH(n, betterG);
	}
    }
    
    private static double percDiff(double x, double y) {
	return (x-y)*1.0/((x+y)*1.0/2);
    }

    /*
    public static void main(String[]args) {
	System.out.println(percDiff(100,80));
	System.out.println(percDiff(100,90));
	System.out.println(percDiff(100,99));
	System.out.println(percDiff(100,99.99));
	System.out.println(percDiff(100,99.999999999999999999));
	System.out.println(sqrt(64));
	System.out.println(sqrt(4));
	System.out.println(sqrt(2));
	System.out.println(sqrt(25));
    }
    */
}
