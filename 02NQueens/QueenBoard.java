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
        if (solveH(0,0)) {
	}
	else { //edit board
	}
    }

    private boolean solveH(int row, int col){
	if (row==board.length && col==board.length) {
	    return isValidMove(row,col);
	}
	else {
	    if (col < board.length-1 && !isValidMove(row,col)) {
		    if (moveQueenDown(row-1)==-1) {
			return false;
		    }
		    else {
			int a = moveQueenDown(row-1);
			return solveH(row-1,a);
		    }
		}
	    else {
		    addQueen(row,col);
		    return solveH(row+1,col);
	    }
	}
    }

    private boolean isValidMove(int row, int col) {
	return board[row][col]==0;
    }
    
    private void addQueen (int row, int col) {
    }

    private void removeQueen (int row) {
    }

    private void moveQueenDown (int row) {
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
    	return "";
    }
}
