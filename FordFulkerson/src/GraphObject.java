//* File			: FordFulkerson.java
//* Class           : GraphObject
//* Author	        : Shivakiran Chimatadar (Student ID: 29001067)
//* Co-Author	    : Rakshit BR (Student ID: 12641124)
//* Date			: 19-Nov-2015
//* Description	    : Graph inputs for Ford Fulkerson Algorithm
//* Version		    : 1.0

public class GraphObject {
  public int maxFlow;
  public int[][] residualGraph;
  
  public GraphObject() {
	  maxFlow=Integer.MAX_VALUE;
	  residualGraph=new int[FordFulkerson.V][FordFulkerson.V];
	
}
	
}

