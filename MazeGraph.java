import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @filename MazeGraph
 * @author Colin St. Claire	
 * @created 11/30/15
 * @modified 12/04/15
 */

public class MazeGraph implements Graph {
	private int width;
	private int height;
	
	public MazeGraph(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public int numVerts() {
		return width * height;
	}

	
	@Override
	public ArrayList<Integer> adjacents(int vertex) {
		ArrayList<Integer> L = new ArrayList<Integer>();
		final int ROW = vertex / width;
		final int COL = vertex % width;
		
		if (ROW > 0) { 
			// add vertex directly above
			L.add((ROW - 1) * width + COL);
		}
		if (ROW < height-1) {
			// add vertex directly below
			L.add((ROW + 1) * width + COL);
		}
		if (COL > 0) {
			// add vertex directly to left
			L.add((ROW * width + (COL - 1)));
		}
		if (COL < width - 1) {
			// add vertex directly to right	
			L.add((ROW * width + (COL + 1)));
		}
		
		return L;
	}

	
	
	public static void main(String[] args) {
		
	}
}
