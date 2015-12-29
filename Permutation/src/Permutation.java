import java.lang.reflect.Array;
import java.util.Arrays;

import javax.naming.ldap.SortControl;

public class Permutation {
    public String sort(String s)
    {
    	char[] str=s.toCharArray();
    	Arrays.sort(str);
    	return new String(str);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="god";
		String s2="dog";
		if(s1.length()!=s2.length())
		{
			System.out.println("No permutation");
		}
		else
		{
			System.out.println(new Permutation().sort(s1).equals(new Permutation().sort(s2)));
			
		}

	}

}
