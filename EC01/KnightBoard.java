import java.util.*;

public class KnightBoard {
    private int[][] board;
    private int[][] moves = {
	{-2,-1,1,2, 2, 1,-1,-2},
	{ 1, 2,2,1,-1,-2,-2,-1},
    };
    private int[][] nummoves;
    private ArrayList<Integer> moveindex  = new ArrayList<Integer>();

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
	nummoves = new int[startingRows][startingCols];
	calcMoves();
    }

    public String toString() {
	int sum = 0;
	String ans = "solution for "+board.length+"x"+board[0].length+":\n";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		sum+=board[r][c];
	    }
	}
	if (!(sum==1)) {
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board[0].length; c++) {
		    if (board.length*board[0].length>=10 && board[r][c]<10) {
			    ans += "  ";
			    ans += board[r][c];
		    }
		    else {
			ans += " ";
			ans += board[r][c];
		    }
		}
		ans+= "\n";
	    }
	}
	return ans;
    }
    
    public void solveFast() {
	solveFastH(0,0,1);
    }
    
    public boolean solveFastH(int row, int col, int level) {
	System.out.println("level = "+level);
	sortMoveIndex(row,col);
	if (level==1) {
	    for (int r = 0; r < board.length/2+1; r++) {
		for (int c = 0; c < board.length/2+1; c++) {
		    mark(r,c,1);
		    return solveFastH(r,c,2);
		}
	    }
	}
	System.out.println("finished = "+(level > board.length*board[0].length));
	if (level > board.length*board[0].length){
	    return true;
	}
	for (int move = 0; move < moveindex.size(); move++) {
	    System.out.println(toString());
	    int newRow = row + moves[0][moveindex.get(move)];
	    int newCol = col + moves[1][moveindex.get(move)];
	    if (isValidMove(newRow,newCol)) {
		mark(newRow,newCol,level);
		System.out.println("solve of next  = "+solveFastH(newRow,newCol,level+1));
		if (solveFastH(newRow,newCol,level+1)) {
		    return true;
		}
		unmark(newRow,newCol);
	    }
	}
	return false;
    }

    private boolean checkzero() {
	boolean ans = true;
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		ans = ans && board[r][c] != 0;
	    }
	}
	return ans;
    }
    
    private void calcMoves() {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		int ans = 0;
	        for (int i = 0; i < 8; i++) {
		    int newRow = r + moves[0][i];
		    int newCol = c + moves[1][i];
		    if (isValidMove(newRow,newCol)) {
			ans++;
		    }
		}
		nummoves[r][c] = ans;
	    }
	}
    }

    private void fillMoveIndex(int row, int col) {
	moveindex  = new ArrayList<Integer>();
	//System.out.println(row+", "+col);
	for (int move = 0; move < 8; move++) {
	    int newRow = row + moves[0][move];
	    int newCol = col + moves[1][move];
	    //System.out.println(newRow+", "+newCol);
	    //System.out.println(isValidMove(newRow,newCol));
	    if (isValidMove(newRow,newCol)) {
	        moveindex.add(move);
	    }
	}
    }

    private void sortMoveIndex(int row, int col) {
	fillMoveIndex(row,col);
	System.out.println("before"+printmove());
	if (moveindex.size() > 1) {
	    int temp;
	    for (int i = 1; i < moveindex.size(); i++) {
		for(int j = i ; j > 0 ; j--){
		    int row1 = row + moves[0][moveindex.get(j)];
		    int col1 = col + moves[1][moveindex.get(j)];
		    int row2 = row + moves[0][moveindex.get(j-1)];
		    int col2 = col + moves[1][moveindex.get(j-1)];
		    if(nummoves[row1][col1] < nummoves[row2][col2]){
			temp = moveindex.get(j);
		        moveindex.set(j,moveindex.get(j-1));
			moveindex.set(j-1,temp);
		    }
		}
	    }
	}
	System.out.println("after"+printmove());
    }

    private String printmove() {
	String ans = "";
	for (int i = 0; i < moveindex.size(); i++) {
	    ans += moveindex.get(i);
	    ans += ", ";
	}
	return ans;
    }
    
    private boolean isValidMove(int newRow,int newCol) {
	return newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol]==0;
    }

    private void mark(int row,int col,int level) {
	board[row][col]=level;
	//System.out.println("marked\n"+toString());
    }

    private void unmark(int row,int col) {
	board[row][col]=0;
    }

    public static void main(String[] args) {
	//for (int r = 7; r < 25; r++) {
	//for (int c = 7; c < 25; c++) {
		KnightBoard h = new KnightBoard(5,6);
		h.solveFast();
		System.out.println(h.toString());
		//}
    //}
    }

}
