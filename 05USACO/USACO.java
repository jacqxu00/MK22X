import java.util.*;
import java.io.*;

public class USACO {
    //bronze
    private int[][] lake;
    private int e;
    private Scanner in;
    private int n;
    //silver
    private int t;
    private int[][] pasture;
    private int startR;
    private int startC;
    private int endR;
    private int endC;
    
    
    //BRONZE------------------------------------------------------------------------------
    public int bronze(String fileName){
	try {
	    in = new Scanner(new File(fileName));
	    makeSize(fileName);
	    loadWords(fileName);
	    bronzeStomp();
	    bronzeLake();
	}
	catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}
	return bronzeSize();
    }

    public static String toString(int[][] s) {
	String ans = "";
	for (int r = 0; r < s.length; r++) {
	    for (int c = 0; c < s[r].length; c++) {
		ans += s[r][c];
		ans += ' ';
	    }
	    ans+= "\n";
	}
	return ans;
    }

    private void makeSize(String fileName){
	String firstline = in.nextLine();
	//System.out.println(firstline);
	Scanner f = new Scanner(firstline);
	int row = f.nextInt();
	int col = f.nextInt();
	e = f.nextInt();
	n = f.nextInt();
	//System.out.println(row);
	//System.out.println(col);
	//System.out.println(e);
	//System.out.println(n);
	lake = new int[row][col];
    }
    
    private void loadWords(String fileName){
	for (int r = 0; r < lake.length; r++) {
	    String line = in.nextLine();
	    Scanner s = new Scanner(line);
	    for (int c = 0; c < lake[r].length; c++){
		//System.out.println(line);
		lake[r][c] = s.nextInt();
	    }
	}
    }

    private void bronzeStomp(){
	try{
	    while(in.hasNextLine()){
		String instruction = in.nextLine();
		Scanner z = new Scanner(instruction);
		int row = z.nextInt();
		int col = z.nextInt();
		int inc = z.nextInt();
		//System.out.println(row+" "+col+" "+inc);
		int largest = 0;
		for(int r = row; r < row + 3; r++){
		    for(int c = col; c < col + 3; c++){
			if(lake[r-1][c-1] > largest){
			    largest = lake[r-1][c-1];
			}
		    }
		}
		for(int r = row; r < row + 3; r++){
		    for(int c = col; c < col + 3; c++){
			if (lake[r-1][c-1]>largest-inc){
			    lake[r-1][c-1] = largest-inc;
			}
			//System.out.println(toString());
		    }
		}
	    }
	    //System.out.println(toString());
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Invalid Index.");
	}
    }

    private void bronzeLake(){
	for(int r = 0; r < lake.length; r++){
	    for(int c = 0; c < lake[0].length; c++){
		if(lake[r][c] < e){
		    int temp = lake[r][c];
		    lake[r][c] = e - temp;
		}
		else{
		    lake[r][c] = 0;
		}
	    }
	}
	//System.out.println(toString());
    }

    private int bronzeSize(){
	int dep = 0;
	for(int r = 0; r < lake.length; r++){
	    for(int c = 0; c < lake[0].length; c++){
		dep += lake[r][c];
	    }
	}
	return dep*72*72;
    }

    //SILVER-------------------------------------------------------------------------------------
    public int silver(String fileName){
	try {
	    in = new Scanner(new File(fileName));
	    makeSizeS(fileName);
	    //System.out.println(toString(pasture));
	    loadWordS(fileName);
	    //System.out.println(toString(pasture));
	    moveCows(t);
	    //System.out.println(toString(pasture));
	}
	catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}
	return pasture[endR][endC];
    }

    private void makeSizeS(String fileName){
	String firstline = in.nextLine();
	//System.out.println(firstline);
	Scanner f = new Scanner(firstline);
	int row = f.nextInt();
	int col = f.nextInt();
	t = f.nextInt();
	//System.out.println(row);
	//System.out.println(col);
	//System.out.println(t);
	pasture = new int[row][col];
    }

    private void loadWordS(String fileName){
	for (int r = 0; r < pasture.length; r++) {
	    String line = in.nextLine();
	    for (int c = 0; c < pasture[r].length; c++){
		//System.out.println(line);
		if (line.charAt(c)=='.'){
		    pasture[r][c] = 0;
		}
		else {
		    pasture[r][c] = -1;
		}
	    }
	}
    }

    private void moveCows(int n){
	String line = in.nextLine();
	Scanner s = new Scanner(line);
	startR = s.nextInt()-1;
	startC = s.nextInt()-1;
	endR = s.nextInt()-1;
	endC = s.nextInt()-1;
	//System.out.println(startR);
	//System.out.println(startC);
	//System.out.println(endR);
	//System.out.println(endC);
	if(isValid(startR,startC+1)){
	    pasture[startR][startC+1] = 1;
	}
	if(isValid(startR,startC-1)){
	    pasture[startR][startC-1] = 1;
	}
	if(isValid(startR+1,startC)){
	    pasture[startR+1][startC] = 1;
	}
	if(isValid(startR-1,startC)){
	    pasture[startR-1][startC] = 1;
	}
	//System.out.println(toString(pasture));
	if (n > 1) {
	    for (int i = 1; i < n; i++) {
		int[][] temp = new int[pasture.length][pasture[0].length];
		for (int r = 0; r < pasture.length; r++) {
		    for (int c = 0; c < pasture[0].length; c++) {
			if (pasture[r][c]!= -1){
			    int sum = num(r+1,c)+num(r-1,c)+num(r,c+1)+num(r,c-1);
			    temp[r][c] = sum;
			}
			else {
			    temp[r][c] = -1;
			}
		    }
		}
		pasture = temp;
		//System.out.println(toString(pasture));
	    }
	}
    }

    private boolean isValid(int r, int c){
	return r >= 0 && r < pasture.length && c >= 0 && c < pasture[0].length && pasture[r][c]!= -1;
    }
    
    private int num(int r, int c) {
	int ans = 0;
	if (isValid(r,c)) {
	    ans = pasture[r][c];
	}
	return ans;
    }
    
    public static void main (String[] args) {
        USACO x = new USACO(); //does not have to do anything.
	
	//tests for bronze
	System.out.println(x.bronze("btest1.txt"));
	System.out.println("Answer: 342144");
	
	System.out.println(x.bronze("btest2.txt"));
	System.out.println("Answer: 102762432");
	    
	System.out.println(x.bronze("btest3.txt"));
	System.out.println("Answer: 1058992704");
	
	//tests for silver
	System.out.println(x.silver("stest1.txt"));
	System.out.println("Answer: 1");

    }

}
