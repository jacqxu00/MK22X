import java.util.*;
import java.io.*;

public class Maze{
    private int[][] dir = {
	{0,1,0,-1},
	{1,0,-1,0},
    };
    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
	makeSize(filename);
        loadWords(filename);
    }

    private void makeSize(String fileName){
	try {
	    Scanner in = new Scanner(new File(fileName));
	    int row = 0;
	    int col = 0;
	    while(in.hasNextLine()){
		String line = in.nextLine();
		col = line.length();
		row++;
            }
	    maze = new char[row][col];
	}
	catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}
    }
    
    private void loadWords(String fileName){
	try {
	    Scanner in = new Scanner(new File(fileName));
	    int row = 0;
	    int numE = 0;
	    int numS = 0;
	    while(in.hasNextLine()){
		String line = in.nextLine();
		for (int col = 0; col < line.length(); col++){
		    char c = line.charAt(col);
		    if (c == 'E'){
			numE++;
		    }
		    if (c == 'S'){
			numS++;
		    }
		    maze[row][col] = c;
		}
		row++;	
            }
	    System.out.println(toString());
	    if (numE>1 || numS>1) {
		System.out.println("Invalid number of starts/ends");
		System.exit(1);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}
    }

    public String toString() {
	String ans = "";
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		ans += maze[r][c];
	    }
	    ans+= "\n";
	}
	return ans;
    }
    
    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr=-1,startc=-1;
        //Initialize starting row and starting col with the location of the S. int
        for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		if (maze[r][c] == 'S'){
		    startr = r;
		    startc = c;
		}
	    }
	}
	maze[startr][startc] = '@';//erase the S, and start solving!
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
	    //wait(20);
        }
	
	for (int move = 0; move < 4; move++) {
	    int newRow = row + dir[0][move];
	    int newCol = col + dir[1][move];
	    int revRow = row - dir[0][move];
	    int revCol = col - dir[0][move];
	    if (isValidMove(newRow,newCol)) {
		if (maze[newRow][newCol]=='E'){
		    return true;
		}
		mark(newRow,newCol);
		if (solve(newRow,newCol)) {
		    return true;
		}
		unmark(newRow,newCol);
		//return solve(rev,col);
	    }
	}
	return false;
    }

    private boolean isValidMove(int r,int c) {
	return maze[r][c]==' ' || maze[r][c]=='E';
    }

    private void mark(int row,int col) {
	maze[row][col]='@';
	//System.out.println("marked\n"+toString());
    }

    private void unmark(int row,int col) {
	maze[row][col]='.';
    }
    
    public static void main(String[] args) {
        Maze f;
        f = new Maze("data3.txt");//true animates the maze.
        f.setAnimate(true);
        f.solve();
        System.out.println(f);
    }
    
}
