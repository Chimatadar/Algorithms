import java.util.Iterator;

import javax.lang.model.element.VariableElement;

public class UniqueString {

	public boolean uniqueChars(String s)
	{
		boolean[] charSet=new boolean[256];
		for(int i=0;i<s.length();i++)
		{
			int val=s.charAt(i);
			if(charSet[val])
			{
				return false;
			}
			charSet[val]=true;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        UniqueString uniqueString=new UniqueString();
		String s="Hello";
		boolean x=uniqueString.uniqueChars(s);
		System.out.println(x);
	}

}
