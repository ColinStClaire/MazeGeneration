import java.util.ArrayList;

/**
 * @filename MazeGraph
 * @author Colin St. Claire	
 * @created 11/30/15
 * @modified 12/04/15
 */

public interface Graph {
	public int numVerts();
	public ArrayList<Integer> adjacents(int vertex);
}
