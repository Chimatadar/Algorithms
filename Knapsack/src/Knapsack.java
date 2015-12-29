import java.io.*;
import java.util.*;


public class Knapsack {

	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName = "KP_input_3.txt";
		String line = null;
		InputValues inputValues=new InputValues();
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
      
            inputValues.totalWeight= Integer.parseInt(bufferedReader.readLine());
            while((line = bufferedReader.readLine()) != null) {
            	String[] splittedRow = line.split(" ");
            	inputValues.itemId.add(Integer.parseInt(splittedRow[0]));
            	inputValues.weights.add(Integer.parseInt(splittedRow[1]));
            	inputValues.values.add(Integer.parseInt(splittedRow[2]));
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
		
        ArrayList<OPTItems> optItems=new ArrayList<OPTItems>();
		for(int i=0;i<=inputValues.totalWeight;i++)
		{
			
			if(i<Collections.min(inputValues.weights))
			{
				OPTItems optItem=new OPTItems();
				optItem.OPT=0;
				//optItem.items.add(0);
				optItems.add(optItem);
			}
			else
			{
				ArrayList<OPTItems> optItemsSub=new ArrayList<>();
		
				for(int j=0;j<=i;j++)
				{
					
					if(inputValues.weights.contains(j))
					{
						int t= inputValues.weights.indexOf(j);
						OPTItems optItem1=new OPTItems();
						optItem1.OPT= optItems.get(i-j).OPT + inputValues.values.get(t);
						optItem1.items.addAll(optItems.get(i-j).items);
						optItem1.items.add(inputValues.itemId.get(t));
						optItemsSub.add(optItem1);
					}
				}
				
					optItems.add(Collections.max(optItemsSub,new Comparator<OPTItems>() {
					public int compare(OPTItems o1, OPTItems o2){
						return o1.getOPT().compareTo(o2.getOPT());
					}
					}));
				
			}
		}
		
		for(int i=0;i<optItems.size();i++)
		{
			System.out.println("OPT("+i+"):"+ optItems.get(i).OPT + "  Items:"+ optItems.get(i).items);
		}
		
		System.out.println();
		System.out.println("Final Result:");
		System.out.println();
		System.out.println("OPT:"+ optItems.get(optItems.size()-1).OPT + "  Items:"+ optItems.get(optItems.size()-1).items);

	}

}
