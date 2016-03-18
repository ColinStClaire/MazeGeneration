
import java.io.PrintStream;

/**
 * @filename MazeGraph
 * @author Colin St. Claire	
 * @created 11/30/15
 * @modified 12/04/15
 */

public class MazeGen {
	
	
	private int[][] cellGen(int[] spanTree, int width, int height) {
		final int EAST = 1;
		final int NORTH = 2; 
		final int WEST = 4;
		final int SOUTH = 8;		
		
		int cells[][] = new int[height][width];
		for (int row = 0 ; row < height; row++) {
			for (int col = 0; col < width; col++) {
				cells[row][col] = 0xF; // 1111;
			}
		}
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				int vertex = row * width + col;
				int parent = spanTree[vertex]; 
				if (parent >= 0) { // if vertex has a parent
					int rowP = parent / width; // row of parent
					int colP = parent % width; // col of parent
					if (colP == col + 1) { // parent is to the left of child
						cells[row][col] &= ~EAST;
						cells[rowP][colP] &= ~WEST;
					}
					if (colP == col - 1) { // parent is to the right of child
						cells[row][col] &= ~WEST;
						cells[rowP][colP] &= ~EAST;
					}
					if (rowP == row + 1) { // parent is below child
						cells[row][col] &= ~SOUTH;
						cells[rowP][colP] &= ~NORTH;
					}
					if (rowP == row - 1) { // parent is above child
						cells[row][col] &= ~NORTH;
						cells[rowP][colP] &= ~SOUTH;
					}
				}
			}
		}
		cells[(int) Math.random() * height][0] &= ~WEST;
		cells[(int) Math.random() * height][width-1] &= ~EAST;
		
		return cells;
	}
	
	
	public static void main(String[] args) {
	    int W, H;
	   
	    String fname;
	    if (args.length != 3) {
	    	W = 16;
	    	H = 16;
		fname = "maze16x16.txt";
	    } else {
	    	W = Integer.parseInt(args[0]);
	    	H = Integer.parseInt(args[1]);
	    	if (W < 5 || H < 5) {
	    		System.err.println("bogus size!");
	    		return;
	    	}
	    	fname = args[2];
	    }
	    
	    MazeGraph mazeGraph = new MazeGraph(W, H);
	    MazeDFS dfs = new MazeDFS(mazeGraph);
	    int[] dfsTree = dfs.mazeDFS(mazeGraph, 0);
	    MazeGen maze = new MazeGen();
	    int[][] cells = maze.cellGen(dfsTree, W, H);
	    
	    try {
	        PrintStream ps = new PrintStream(fname);
	        ps.println(W + " " + H);
	        for (int r = 0; r < H; r++) {
	            for (int c = 0; c < W; c++) {
	                ps.print(cells[r][c] + " ");
	            }
	            ps.println();
	        }
	        ps.close();
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	    }
	}
}
