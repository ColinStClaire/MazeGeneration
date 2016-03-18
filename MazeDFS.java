import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
/**
 * @filename MazeGraph
 * @author Colin St. Claire	
 * @created 11/30/15
 * @modified 12/04/15
 */

public class MazeDFS {
	
	private Graph graph;
	
	public MazeDFS (Graph graph) {
		this.graph = graph;
	}
	
	public int[] mazeDFS(int start) {
		Stack<Integer> stack = new Stack<>();
		int verts = graph.numVerts();
		boolean[] visited = new boolean[verts];
		int[] parent = new int[verts];
		int visitCount = 1;

		parent[start] = -1;
		visited[start] = true;
		stack.push(start);
		
		while (visitCount < verts) {
			ArrayList<Integer> neighbors = graph.adjacents(start);
			ArrayList<Integer> unvisited = unVisitedNeighbors(neighbors, visited);
			if (unvisited.size() > 0) {
				int randomNeighbor = randomNeighbor(unvisited); 
				visited[randomNeighbor] = true;
				visitCount++;	
				parent[randomNeighbor] = start;
				stack.push(randomNeighbor);
				start = randomNeighbor;
			} else {
				start = stack.pop();
			}
		}
		return parent;
	}
	
	
	
	private ArrayList<Integer> unVisitedNeighbors(ArrayList<Integer> neighbors, boolean[] visited) {
		ArrayList<Integer> unvisited = new ArrayList<Integer>();
		assert(neighbors.size() > 0);
		for (int i = 0; i < neighbors.size(); i++) {
			if (!visited[neighbors.get(i)]) {
				unvisited.add(neighbors.get(i));
			}
		}
		return unvisited;
	}
	
	private int randomNeighbor(ArrayList<Integer> unvisited) {
		Random rng = new Random();
		int randInt = rng.nextInt(unvisited.size());
		return unvisited.get(randInt);
	}
	
	public static void main(String[] args) {
		
	}
}
