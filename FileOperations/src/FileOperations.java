import java.util.*;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Token {
	private String s;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Token)) {
			return false;
		}
		Token other = (Token) obj;
		if (s == null) {
			if (other.s != null) {
				return false;
			}
		} else if (!s.equals(other.s)) {
			return false;
		}
		return true;
	}

	public String getS() {
		return s;
	}
	
	public void setS(String string) {
		s=string;
	}
	
	public String toString() {
		return s.toString();
	}
	

}

class Palindrome {
	private String s1;
	private String s2;
	private String s3;
	


	public String getS1() {
		return s1;
	}
	
	public void setS1(String string) {
		s1=string;
	}
	public String getS2() {
		return s2;
	}
	
	public void setS2(String string) {
		s2=string;
	}
	public String getS3() {
		return s3;
	}
	
	public void setS3(String string) {
		s3=string;
	}
	
	public String toString() {
		return s1+" "+s2+" "+s3;
	}
	

}

class gram2{
	private String s1;
	private String s2;
	
	public  String gets1() {
		return s1;
	}
	public  String gets2() {
		return s2;
	}
	public  void sets1(String s1) {
		this.s1=s1;
	}
	public  void sets2( String s2) {
		this.s2=s2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s1 == null) ? 0 : s1.hashCode());
		result = prime * result + ((s2 == null) ? 0 : s2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof gram2)) {
			return false;
		}
		gram2 other = (gram2) obj;
		if (s1 == null) {
			if (other.s1 != null) {
				return false;
			}
		} else if (!s1.equals(other.s1)) {
			return false;
		}
		if (s2 == null) {
			if (other.s2 != null) {
				return false;
			}
		} else if (!s2.equals(other.s2)) {
			return false;
		}
		return true;
	}
	public String toString() {
		return s1 +" "+ s2;
		
	}
}

public class FileOperations {

	public static void main(String[] args) {
		String fileName = "Input1.txt";
		List<Token> tokens=tokenizeFile(fileName);
		//print(tokens);
		Hashtable<Token, Integer> wordFreq=computeWordFreq(tokens);
		//print(wordFreq);
		
		Hashtable<gram2, Integer> gram2Freq=computeTwoGramFreq(tokens);
		//print2Gram(gram2Freq);
		
		Hashtable<Palindrome, Integer> palindromeFreq=computePalindromeFrequencies(tokens);
		//printPalindrome(palindromeFreq);
	}

	private static void printPalindrome(Hashtable<Palindrome, Integer> palindromeFreq) {
	      ArrayList<Map.Entry<Palindrome, Integer>> l = new ArrayList(palindromeFreq.entrySet());
	       Collections.sort(l, new Comparator<Map.Entry<Palindrome, Integer>>(){

	         public int compare(Map.Entry<Palindrome, Integer> o1, Map.Entry<Palindrome, Integer> o2) {
	            return o2.getValue().compareTo(o1.getValue());
	        }});

	       System.out.println(l);
	}

	private static Hashtable<Palindrome, Integer> computePalindromeFrequencies(List<Token> tokens) {
		Hashtable<Palindrome, Integer> palindromes=new Hashtable<Palindrome,Integer>();
		List<Palindrome> palindromesList=new ArrayList<Palindrome>();
		for(int i=0;i<tokens.size()-3;i++)
		{
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append(tokens.get(i).toString());
			stringBuffer.append(tokens.get(i+1).toString());
			stringBuffer.append(tokens.get(i+2).toString());
			char[] threeWords=stringBuffer.toString().toCharArray();
			
			int start=0;
			int end=threeWords.length-1;
			boolean flag=true;
			while(start<end)
			{
				if(threeWords[start]==threeWords[end])
				{
					start++;
					end--;
				}
				else
				{
					flag=false;
					break;
				}
					
			}
			
			
			if(flag)
			{
				Palindrome palindrome=new Palindrome();
				palindrome.setS1(tokens.get(i).toString());
				palindrome.setS2(tokens.get(i+1).toString());
				palindrome.setS3(tokens.get(i+2).toString());
				palindromesList.add(palindrome);
			}
		}
		
		for (int i = 0; i < palindromesList.size(); i++) {
			if(palindromes.containsKey(palindromesList.get(i)))
			{
				int count=palindromes.get(palindromesList.get(i));
				count++;
				palindromes.put(palindromesList.get(i), count);
			}
			else {
				palindromes.put(palindromesList.get(i), 1);
			}
		}
		
		return palindromes;
	}

	private static void print2Gram(Hashtable<gram2, Integer> gram2Freq) {
	      ArrayList<Map.Entry<gram2, Integer>> l = new ArrayList(gram2Freq.entrySet());
	       Collections.sort(l, new Comparator<Map.Entry<gram2, Integer>>(){

	         public int compare(Map.Entry<gram2, Integer> o1, Map.Entry<gram2, Integer> o2) {
	            return o2.getValue().compareTo(o1.getValue());
	        }});

	       System.out.println(l);
		
	}

	private static Hashtable<gram2, Integer> computeTwoGramFreq(List<Token> tokens) {
		List<gram2> gram2s=new ArrayList<gram2>();
		for (int i = 0; i < tokens.size(); i=i+2) {
			gram2 Gram2=new gram2();
			Gram2.sets1(tokens.get(i).toString());
			if(i+1<tokens.size())
			Gram2.sets2(tokens.get(i+1).toString());
			gram2s.add(Gram2);
		}
		
		for (int i = 0; i < gram2s.size(); i++) {
			System.out.println(gram2s.get(i));
		}
		
		Hashtable<gram2, Integer> twoGramCount=new Hashtable<>();
		for (int i = 0; i < gram2s.size(); i++) {
			if(twoGramCount.containsKey(gram2s.get(i)))
			{
				int count=twoGramCount.get(gram2s.get(i));
				count++;
				twoGramCount.put(gram2s.get(i), count);
			}
			else {
				twoGramCount.put(gram2s.get(i), 1);
			}
		}
		
		return twoGramCount;
	}

	private static void print(Hashtable<Token, Integer> wordFreq) {
	      ArrayList<Map.Entry<Token, Integer>> l = new ArrayList(wordFreq.entrySet());
	       Collections.sort(l, new Comparator<Map.Entry<Token, Integer>>(){

	         public int compare(Map.Entry<Token, Integer> o1, Map.Entry<Token, Integer> o2) {
	            return o2.getValue().compareTo(o1.getValue());
	        }});

	       System.out.println(l);
		
	}

	private static Hashtable<Token, Integer> computeWordFreq(List<Token> tokens) {
		Hashtable<Token, Integer> wordsCount=new Hashtable<>();
		for (int i = 0; i < tokens.size(); i++) {
			if(wordsCount.containsKey(tokens.get(i)))
			{
				int count=wordsCount.get(tokens.get(i));
				count++;
				wordsCount.put(tokens.get(i), count);
			}
			else {
				wordsCount.put(tokens.get(i), 1);
			}
		}
		return wordsCount;
	}

	private static List<Token> tokenizeFile(String fileName) {
		String line = null;
		List<Token> tokens=new ArrayList<Token>();
		
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	String[] splittedRow = line.split(" ");
            	for (int j = 0; j < splittedRow.length; j++) {
            		Token token=new Token();
                	token.setS(splittedRow[j]);
                	tokens.add(token);	
				}
            }   
            
            bufferedReader.close();        
            return tokens;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");
            return null;
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            return null;
        }

	}

	private static void print(List<Token> tokens) {
		for (int i = 0; i < tokens.size(); i++) {
			System.out.println(tokens.get(i));
		}
	}

	

}
