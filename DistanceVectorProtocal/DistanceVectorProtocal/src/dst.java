import java.util.*;
import java.io.*;

public class dst {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		File file = new File("simple.txt");
		Scanner sc = new Scanner(file);
		
		int totalVer = sc.nextInt();
		vertex[] ver = new vertex[totalVer];
		
		//creating instances of vertices
		for(int i=0; i<totalVer; i++){
			ver[i] = new vertex(i,totalVer);
		}
		
		sc.nextInt();
		
		//putting edges into vertices
		while(sc.hasNextInt()){
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			ver[i].outedges.add(new edge(j,k));
			
			ver[i].dst[j][0] = j;
			ver[i].dst[j][1] = j;
			ver[i].dst[j][2] = k;
			
		}
		
		sc.close();
		
		//initializing the nodes
		for(int i=0; i<totalVer; i++){
			for(int j=0; j<totalVer; j++){
				if(ver[i].dst[j][0] == j && j!=0 ){
					
					continue;
					}else if(j == 0 && ver[i].dst[j][2] != 0 ){
						continue;
					}
				else{
					if(i==j){
						ver[i].dst[j][0] = i;
		    			ver[i].dst[j][1] = i;
		    			ver[i].dst[j][2] = 0;
					}else{
						ver[i].dst[j][0] = j;
		    			ver[i].dst[j][1] = -1;
		    			ver[i].dst[j][2] = Integer.MAX_VALUE-100;
					}
				}
			}
		}
		
		//updating DST table
		int z=1;
		while(z>0){
			z=0;
			for(int i=0; i<totalVer ;i++ ){
			
			ver[i].flag = 0;
			
			for(int j=0;j<ver[i].outedges.size();j++){
				
				int k = ver[i].outedges.get(j).to;
				int w = ver[i].outedges.get(j).weight;
				//System.out.println(k+""+w);
				for(int m =0; m < totalVer ; m++){
					
						if(m == i || m == k)
							continue;
						else{
							if (ver[i].dst[m][2] > ver[k].dst[m][2] + w){
								ver[i].flag = 1;z++;
								ver[i].dst[m][2] = ver[k].dst[m][2] + w;
								ver[i].dst[m][1] = k;
							}
						}
					
				}
			}
		
		}
		}
		
		
		//printing outputs
		
		
		
		
		for(int i=0; i<totalVer ; i++){
			System.out.println();
			System.out.println("node" + i);
			System.out.println();
			
			for(int j =0; j<totalVer; j++){
				
				System.out.println(ver[i].dst[j][0]+ " "+ ver[i].dst[j][1]+ " "+ ver[i].dst[j][2]);
			}
			
		}
		

	}

}

class vertex{
	int vertexID;
	ArrayList<edge> outedges = new ArrayList<edge>();
	int flag = 0;
	int[][] dst;
	public vertex(int id, int a){
		vertexID = id;
		dst = new int[a][3];
	}
}

class edge{
	int to;
	int weight;
	public edge(int a, int b){
		to = a;
		weight = b;
	}
}
