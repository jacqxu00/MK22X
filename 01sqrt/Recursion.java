import java.lang.Math;

public class Recursion{
    
    public static String name(){
	return "Xu,Jackie";
    }
    
    public static double sqrt(double n){
	if (n < 0) {
	    throw new IllegalArgumentException("value must be > 0");
	}
	if (n == 0) {
	    return 0;
	}
	else {
	    return sqrtH(n,1);
	}
    }

    private static double sqrtH(double n, double guess){
	if (percDiff(guess*guess,n)<=0.00000000001 && percDiff(guess*guess,n)>=-0.00000000001) {
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

    public static boolean closeEnough(double a, double b){
	if(a==0.0 && b==0.0)return true;
	if(a==0.0)return b < 0.00000000001;
	if(b==0.0)return a < 0.00000000001;
	return Math.abs(a-b)/a < 0.0001;//very generous %error accepted
    }
    
    public static void main(String[]args) {
	System.out.println(percDiff(100,80));
	System.out.println(percDiff(100,90));
	System.out.println(percDiff(100,99));
	System.out.println(percDiff(100,99.99));
	System.out.println(percDiff(100,99.999999999999999999));
	System.out.println(closeEnough(Math.sqrt(1),sqrt(1)));
	System.out.println(closeEnough(Math.sqrt(2),sqrt(2)));
	System.out.println(closeEnough(Math.sqrt(4),sqrt(4)));
	System.out.println(closeEnough(Math.sqrt(7),sqrt(7)));
	System.out.println(closeEnough(Math.sqrt(10),sqrt(10)));
	System.out.println(closeEnough(Math.sqrt(100),sqrt(100)));
	System.out.println(closeEnough(Math.sqrt(1024),sqrt(1024)));
	System.out.println(closeEnough(Math.sqrt(0),sqrt(0)));
	System.out.println(closeEnough(Math.sqrt(-1),sqrt(-1)));

    }
    
}
