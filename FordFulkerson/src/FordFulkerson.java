//* File			: FordFulkerson.java
//* Class           : FordFulkerson
//* Author	        : Shivakiran Chimatadar (Student ID: 29001067)
//* Co-Author	    : Rakshit BR (Student ID: 12641124)
//* Date			: 19-Nov-2015
//* Description	    : Ford Fulkerson Algorithm
//* Version		    : 1.0


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FordFulkerson {
	public static int V=7;    
	public static void main (String[] args) throws java.lang.Exception
	    {
		int src=-1;
		int destination=-1;
		int[][] graph =new int[V][V];
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				graph[i][j]=0;
			}
		}
		
		String fileName = "Ford_Fulkerson_input.txt";
		String line = null;
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
      
             src= Integer.parseInt(bufferedReader.readLine());
             destination= Integer.parseInt(bufferedReader.readLine());
            while((line = bufferedReader.readLine()) != null) {
            	String[] splittedRow = line.split(" ");
            	graph[Integer.parseInt(splittedRow[0])][Integer.parseInt(splittedRow[1])]=Integer.parseInt(splittedRow[2]);
            }   
            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  

        }
		
		
		

	    FordFulkerson m = new FordFulkerson();
	                               	
	   //----To display the original graph
	    
	    System.out.println("The Original Graph is");
	    for(int i=0;i<graph.length;i++)
	          {
	              for(int j=0;j<graph[i].length;j++)
	                   {
	                     System.out.print(graph[i][j]);
	                     System.out.print(" ");
	                    }
	                     System.out.println();
	                     }
	                     System.out.println();
	        
	                     
	 //----To find residual graph, max flow and min cut
	       GraphObject graph1= m.fordFulkerson(graph, src, destination);
	                               	
	                               	
	                System.out.println("The maximum possible flow is " +
	                           graph1.maxFlow);
	
	                
	            	boolean[] visited = new boolean[V];
	        		visited[0] = true;
	        		dfs(graph1.residualGraph, visited, 0);
	                
	                
	        		System.out.println("The mincut edges are: ");
	        		for (int i = 0; i < V; i++) {
	        			if (visited[i]) {
	        				for (int j = 0; j < V; j++)
	        					if (!visited[j] && graph[i][j] != 0)
	        						System.out.println(i + "->" + j);
	        			}
	        		}
	        		
	                System.out.println();
	                
	                
	         //------To find max flow and min cut if the edge weight changes   
	                
	               //To check for different test cases kindly change node1, node2, updatedWeight variables
	                
	                int node1=1;  //one end of the edge closer to source
	                int node2=5;  // the other end closer to sink
	                int updatedWeight=2; // new weight
	                int source=src; 
	                int sink=destination;
	                int[][] originalGraph=graph;
	                int[][] residualGraph=graph1.residualGraph;
	                
	                GraphObject graph2=m.updateFlow(residualGraph, node1, node2, updatedWeight, source, sink, originalGraph);
	                System.out.println("Updated max flow is "+graph2.maxFlow);
	                
	            	boolean[] visited1 = new boolean[V];
	        		visited1[0] = true;
	        		dfs(graph1.residualGraph, visited1, 0);
	                
	                
	        		System.out.println("The mincut edges for updated flow are: ");
	        		for (int i = 0; i < V; i++) {
	        			if (visited1[i]) {
	        				for (int j = 0; j < V; j++)
	        					if (!visited1[j] && graph[i][j] != 0)
	        						System.out.println(i + "->" + j);
	        			}
	        		}
	                
	    }
	    
	    

private GraphObject fordFulkerson(int[][] graph, int s, int t) {
	// TODO Auto-generated method stub
	GraphObject graphObject=new GraphObject();
	int u;
	int pathFlow=Integer.MAX_VALUE;
	int maxFlow=0;
	int[][]residualGraph=new int[V][V];
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			residualGraph[i][j]=graph[i][j];
		}
	}
	
	int[] parent=new int[V];
	
	while(bfs(residualGraph, s, t, parent))
	{
		for(int v=t;v!=s;v=parent[v])
		{
			u=parent[v];
			pathFlow=Math.min(pathFlow, residualGraph[u][v]);
		}
		for(int v=t;v!=s;v=parent[v])
		{
			u=parent[v];
			residualGraph[u][v]-=pathFlow;
			residualGraph[v][u]+=pathFlow;
		}		
		maxFlow+=pathFlow;
	}
	
	System.out.println("Residual graph is");
	for(int i=0;i<residualGraph.length;i++)
	{
		for(int j=0;j<residualGraph[i].length;j++)
		{
			System.out.print(residualGraph[i][j]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	System.out.println();
	
	graphObject.maxFlow=maxFlow;
	graphObject.residualGraph=residualGraph;
	
	System.out.println();
	return graphObject;
}
	
public boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
	
	boolean[] vistied=new boolean[V];
	for(int i=0;i<V;i++)
	{
		vistied[i]=false;
	}
	
	LinkedList<Integer> queue=new LinkedList<Integer>();
	queue.add(s);
	parent[s]=-1;
	vistied[s]=true;
	
	while(queue.size()>0)
	{
		int u=queue.poll();
	for(int v=0;v<V;v++)
	{
		if(vistied[v]==false && rGraph[u][v]>0)
		{
			vistied[v]=true;
			queue.add(v);
			parent[v]=u;
		}
	}
	}
	return(vistied[t]==true);
}

static void dfs(int[][] graph, boolean[] visited, int start) {
	for (int i = 0; i < V; i++) {
		if (graph[start][i] != 0 && visited[i] == false) {
			visited[i] = true;
			dfs(graph, visited, i);
		}
	}
}


public GraphObject updateFlow(int[][] residualGraph, int e1, int e2, int updatedWeight, int s, int t, int[][] originalGraph) {
	//residualGraph[e1][e2]=updatedWeight;
	//originalGraph[e1][e2]=updatedWeight;
	int bottleNeck= Math.abs(originalGraph[e1][e2]-updatedWeight);
	int[][] updatedResidualGraph=new int[V][V];
	int maxFlow=0;
	
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			updatedResidualGraph[i][j]=residualGraph[i][j];
		}
	}
	
	if(originalGraph[e1][e2] > updatedWeight){
	updatedResidualGraph=updateEdges(bottleNeck, e1, s, residualGraph, updatedResidualGraph, true);
	updatedResidualGraph=updateEdges(bottleNeck, t, e2, residualGraph, updatedResidualGraph, true);
	}
	else{
		updatedResidualGraph=updateEdges(bottleNeck, e1, s, residualGraph, updatedResidualGraph, false);
		updatedResidualGraph=updateEdges(bottleNeck, t, e2, residualGraph, updatedResidualGraph, false);
	}
	
	System.out.println("Residual graph after edge weight changes");
	for(int i=0;i<updatedResidualGraph.length;i++)
	{
		for(int j=0;j<updatedResidualGraph[i].length;j++)
		{
			if(j==0)
			{
				maxFlow+=updatedResidualGraph[i][j];
			}
			System.out.print(updatedResidualGraph[i][j]);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	System.out.println();
	
	GraphObject graphObject=new GraphObject();
	graphObject.maxFlow=maxFlow;
	graphObject.residualGraph=updatedResidualGraph;
	return graphObject;
	
}

public int[][] updateEdges(int bottleNeck, int src, int sink, int[][] residualGraph, int[][] updatedResidualGraph, boolean decrement) {
    int u;
    int[] parent=new int[V];
    int incrementingBottleNeck=0;
    int pathFlow=Integer.MAX_VALUE;
	while(incrementingBottleNeck<bottleNeck)
	{
		boolean isBFS=bfs(updatedResidualGraph, src, sink, parent);
		
		if(isBFS)
		{
			for(int v=sink;v!=src;v=parent[v])
			{
				u=parent[v];
				pathFlow=Math.min(pathFlow, residualGraph[u][v]);
			}
			incrementingBottleNeck+=pathFlow;
			
			if(incrementingBottleNeck<=bottleNeck){
			for(int v=sink;v!=src;v=parent[v])
			{
				u=parent[v];
				if(decrement){
				updatedResidualGraph[u][v]-=incrementingBottleNeck;
				updatedResidualGraph[v][u]+=incrementingBottleNeck;
				}
				else
				{
					updatedResidualGraph[u][v]+=incrementingBottleNeck;
					updatedResidualGraph[v][u]-=incrementingBottleNeck;					
				}
			}
			}
			else{
			for(int v=sink;v!=src;v=parent[v])
			{
				u=parent[v];
				if(decrement){
				updatedResidualGraph[u][v]-=bottleNeck;
				updatedResidualGraph[v][u]+=bottleNeck;
				}
				else
				{
					updatedResidualGraph[u][v]+=bottleNeck;
					updatedResidualGraph[v][u]-=bottleNeck;
				}
			}		
			}
			
		}
	}
	
	return updatedResidualGraph;
	
}
}
