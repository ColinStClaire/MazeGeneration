# MazeGeneration
Maze Generator implemented with DFS
Author: Colin St. Claire colinst.claire@gmail.com
Created: 11/30/15
Modified: 12/04	/15

Description:

    	The Graph ADT interface, implemented in Java, supports:

	int numVerts();
	ArrayList<Integer> adjacents(int vertex);

    	The numVerts() return the number of vertices in a Graph ADT and the adjacents() method returns an ArrayList containing a vertex’s neighbors. Note that this is for an undirected graph.
    
	MazeGraph.java builds the graph and implements the previous 2 methods.

	MazeDFS.java houses the int[] mazeDFS(Graph graph, int start) method which returns a spanning tree for a random path from the starting vertex through all vertices.

	MazeGen.java uses the spanning tree from mazeDFS() to actually build the maze. However, the output of the method just an int[][]. To actually build the maze, drag and drop the .txt output file here: 
http://ezekiel.vancouver.wsu.edu/~cs223/projects/mazegen/webmaze/webmaze.html 
	
	

To build in Terminal:
    	javac MazeGen.java

To run in Terminal:
	java MazeGen 80 80 maze.txt 
	(where 80 80 is the width and the height respectively, and maze.txt is the name of the output file)


Contents:
README.txt~~~~~~~~this file
MazeGraph.java~~~~Builds the Graph and implements numVerts() and adjacents()
MazeDFS.java~~~~~~Finds a random path through a graph and returns the path in the form of an int[]
Graph.java~~~~~~~~The Graph interface
MazeGen.java~~~~~~Generates the maze in the form of an int[][]


