public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	int size = board.length;
        board = new int[size][size];
	solveH(0,0);
    }

    private boolean solveH(int row, int col){
	if (row==board.length-1) {
	    return isValidRow(row);
	}
	else {
	    if (col < board.length-1 && !isValidMove(row,col)) {
		if (moveQueenDown(row-1)==-1) {
		    return false;
		}
		else {
		    int a = moveQueenDown(row-1);
		    System.out.println(toString());
		    return solveH(row-1,a);
		}
	    }
	    else if (!isValidMove(row,col)) {
		return solveH(row,col+1);
	    }
	    else {
		addQueen(row,col);
		System.out.println("addqueen\n"+ toString());
		return solveH(row+1,0);
	    }
	}
    }

    private boolean isValidMove(int row, int col) {
	return board[row][col]==0;
    }

    private boolean isValidRow(int row) {
	boolean ans = false;
	for (int i = 0; i < board.length; i++) {
	    ans = ans || (board[row][i]==0);
	}
	return ans;
    }
    
    private void addQueen (int row, int col) {
	board[row][col] = -1;
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (r==row || c==col || r+c==row+col || row-r == col-c) {
		    if (!(r==row && c==col)){
			int val = board[r][c];
			board[r][c] = val+1;
		    }
		}
	    }
	}
    }

    private void removeQueen (int row) {
	for (int col = 0; col < board.length; col++) {
	    if (board[row][col]==-1) {
		board[row][col] = 0;
		for (int r = 0; r < board.length; r++) {
		    for (int c = 0; c < board.length; c++) {
			if (r==row || c==col || r+c==row+col || row-r==col-c) {
			    int val = board[r][c];
			    board[r][c] = val-1;
			}
		    }
		}
	    }
	}
    }

    private int moveQueenDown (int row) {
	for (int col = 0; col < board.length-1; col++) {
	    if (board[row][col]==-1) {
		removeQueen(row);
		addQueen(row,col+1);
		return col+1;
	    }
	}
	return -1;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	String ans =  "";
        for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		ans += board[r][c];
		ans += " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args) {
	QueenBoard q = new QueenBoard(4);
	q.solve();
	System.out.println(q.toString());
    }
}
