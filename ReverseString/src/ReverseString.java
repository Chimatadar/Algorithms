import java.util.Arrays;

public class ReverseString {

	public String stringReverse(String s){
		char[] strToChar=s.toCharArray();
		char temp;
		for(int i=0,j=strToChar.length-1; i<j;i++,j--)
		{
			temp=strToChar[j];
			strToChar[j]=strToChar[i];
			strToChar[i]=temp;
		}
		return new String(strToChar);
	}
	public static void main(String[] args) {
		String s="Hello World";
		System.out.println(new ReverseString().stringReverse(s));
		

	}

}
