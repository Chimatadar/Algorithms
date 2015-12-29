import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DistanceVectorProtocol {

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "DV_example_input.txt";
		String line = null;
		int totalNodes=0;
		ArrayList<InputVariables> inputVariables=new ArrayList<InputVariables>();
		ArrayList<Integer> fromNodes=new ArrayList<>();
		ArrayList<Integer> toNodes=new ArrayList<>();
		ArrayList<Integer> weights=new ArrayList<>();
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
      
            totalNodes= Integer.parseInt(bufferedReader.readLine());
            
            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null) {
            	InputVariables inputVariable=new InputVariables();
            	String[] splittedRow = line.split(" ");
            	
            	inputVariable.fromNode=Integer.parseInt(splittedRow[0]);
            	inputVariable.toNode=Integer.parseInt(splittedRow[1]);
            	inputVariable.edgeWeight=Integer.parseInt(splittedRow[2]);
            	
            	inputVariables.add(inputVariable);
            }   
            
            bufferedReader.close();
            
            //Jugaad..Change it.. learn how to implement .contains on multiple fields in an ArrayList of object.
            for(int i=0;i<inputVariables.size();i++)
            {
            	fromNodes.add(inputVariables.get(i).fromNode);
            	toNodes.add(inputVariables.get(i).toNode);
            	weights.add(inputVariables.get(i).edgeWeight);
            }
        
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
        
      //Jugaad..Change it.. learn how to implement .contains on multiple fields in an ArrayList of object.
        ArrayList<Integer> source=new ArrayList<>();
		ArrayList<Integer> destination=new ArrayList<>();
		ArrayList<Integer> distance=new ArrayList<>();
		ArrayList<OutputParam> outputParameters=new ArrayList<>();
		
		
        
        for(int i=0;i<totalNodes;i++)
        {
        	for(int j=0;j<totalNodes;j++)
        	{
        		for(int k=0;k<totalNodes;k++)
        		{
        			ArrayList<OutputParam> outputParams=new ArrayList<>();
        			for(int l=0; l<totalNodes-1;l++)
        			{
        				if(j!=k){
        				if(fromNodes.contains(j) && toNodes.contains(l) && fromNodes.indexOf(j)==toNodes.indexOf(l))
        				{
        					OutputParam outputParam=new OutputParam();
        					outputParam.source=j;
        					outputParam.destination=k;
        					
        					
        					if(source.contains(l) && destination.contains(k) && source.indexOf(l)==destination.indexOf(k))
        					{
        						outputParam.distance=weights.get(j)+distance.get(l);
        						outputParam.hop=l;
        					}
        					else
        					{
        						outputParam.distance=0;
        						outputParam.hop=-l;
        					}
                                    					
        					outputParams.add(outputParam);
        					source.add(j);
        					destination.add(k);
        					distance.add(outputParam.distance);
        					
        				}
        				}
        			}
        			
        			outputParameters.add(Collections.max(outputParams,new Comparator<OutputParam>() {
    					public int compare(OutputParam o1, OutputParam o2){
    						return o1.getDistance().compareTo(o2.getDistance());
    					}
    					}));
        		}
        	}
        	
        }
	}
}
