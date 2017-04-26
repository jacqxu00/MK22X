import java.util.*;

public class StackCalc {

    private static boolean isOp(String s) {
	return s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("%");
    }

    private static double apply(String op, double b, double a) {
	if (op.equals("/")) {
	    return a * 1.0 / b;
	}
	else if (op.equals("-")) {
	    return a - b;
	}
	else if (op.equals("+")) {
	    return a + b;
	}
	else if (op.equals("*")) {
	    return a * b;
	}
	else {
	    return a % b;
	}
    }
	
    public static double eval(String s) {
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for (String token : tokens) {
	    if (isOp(token)) {
		values.push(apply(token,values.pop(),values.pop()));
	    }
	    else {
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }
		    
    public static void main(String[] args) {
	System.out.println(eval("10 2 +"));//12.0
	System.out.println(eval("10 2 -"));//8.0
	System.out.println(eval("10 2.0 +"));//12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
	System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
    
}
