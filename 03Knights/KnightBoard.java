public class KnightBoard {
    private int[][] board;
    private int[][] moves = {
	{-2,-1,1,2,2,1,-1,-2},
	{1,2,2,1,-1,-2,-2,-1},
    };

    public KnightBoard(int startingRows,int startingCols) {
	board = new int[startingRows][startingCols];
    }

    public String toString() {
	int sum = 0;
	String ans = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		sum+=board[r][c];
	    }
	}
	if (!(sum==0)) {
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board[0].length; c++) {
		    if (board.length*board[0].length>=10 && board[r][c]<10) {
			    ans += " ";
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

    public void solve() {
	int size1 = board.length;
	int size2 = board[0].length;
        board = new int[size1][size2];
	solveH(0,0,0);
    }

    // level is the # of the knight
    private boolean solveH(int row ,int col, int level){
	if (level==0) {
	    mark(0,0,0);
	    solveH(0,0,1);
	}
	if (level>board.length*board[0].length){
	    return true;
	}
	for (int move = 0; move < 8; move++) {
	    int newRow = row + moves[0][move];
	    int newCol = col + moves[1][move];
	    if (isValidMove(newRow,newCol)) {
		mark(newRow,newCol,level);
		if (solveH(newRow,newCol,level+1)) {
		    return true;
		}
		unmark(newRow,newCol);
	    }
	}
	return false;
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
	for (int i = 5; i < 63; i++) {
	    KnightBoard h = new KnightBoard(i,i);
	    h.solve();
	    System.out.println(h.toString()+"\n");
	    }
	KnightBoard h = new KnightBoard(5,5);
	h.solve();
	System.out.println(h.toString()+"\n");
    }

}
