import java.util.*;

public class MazeSolver {
    private Maze board;
    private boolean aStar = false;
    private boolean animate;
    private int[][] dir = {
	{0,1,-1,0},
	{-1,0,0,1},
    };

    public MazeSolver(String filename) {
	this(filename,false);
    }
    
    public MazeSolver(String filename, boolean anim) {
	animate = anim;
        board = new Maze(filename);
    }

    private boolean isValidMove(int row, int col) {
	return board.get(row,col) == ' ';
    }

    public void solve() {
	solve(1);
    }

    public void solve(int style){
	Frontier solver;
	if (style == 0) {
	    solver = new FrontierStack();
	}
	else if (style == 1) {
	    solver = new FrontierQueue();
	}
	else if (style == 2) {
	    solver = new FrontierPQ();
	}
	else if (style == 3) {
	    solver = new FrontierPQ();
	    aStar = true;
	}
	else {
	    throw new Error("Please enter in a valid style:\n(0) depth first search\n(1) breadth first search\n(2) best first search\n(3) A* search");
	}
	Location current = board.getStart();
	solver.add(current);
	while (!(current.row()==board.getEnd().row() && current.col()==board.getEnd().col())) {
	    current = solver.next();
	    int row = current.row();
	    int col = current.col();
	    board.set(row,col,'.');
	    for (int move = 0; move < 4; move++) {
		int newRow = row + dir[0][move];
		int newCol = col + dir[1][move];
		if(isValidMove(newRow,newCol)) {
		    int distToS = Math.abs(newRow - board.getStart().row()) + Math.abs(newCol - board.getStart().col());
		    int distToE = Math.abs(newRow - board.getEnd().row()) + Math.abs(newCol - board.getEnd().col());
		    Location next = new Location(newRow, newCol, current, distToS, distToE, aStar);
		    solver.add(next);
		    board.set(newRow,newCol,'?');
		    System.out.println(board.toString(100));
		}
	    }
	    }
	Location prev = current;
	while (prev != board.getStart()) {
	    int row = prev.row();
	    int col = prev.col();
	    board.set(row,col,'@');
	    prev = prev.getPrev();
	}
	int row = prev.row();
	int col = prev.col();
	board.set(row,col,'@');
	System.out.println(board.toString(300));   
    }

    public static void main(String[] args) {
	MazeSolver a = new MazeSolver("data4.txt",true);
	a.solve(3);
    }

}
