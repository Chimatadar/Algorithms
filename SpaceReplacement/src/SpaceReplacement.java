import java.lang.reflect.Array;

public class SpaceReplacement {

	public String replaceSpace(String s)
	{
		char[] strToArr=s.toCharArray();
		char[] arr=new char[200];
		int count=0;
		for (int i = 0; i < strToArr.length; i++) {
			if(strToArr[i]==' ')
			{
				arr[i+count]='%';
				arr[i+count+1]='2';
				arr[i+count+2]='0';
				count+=2;
			}
			else
			arr[i+count]=strToArr[i];
		}
		
		return new String(arr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="How are you?";
		System.out.println(new SpaceReplacement().replaceSpace(s));

	}

}
