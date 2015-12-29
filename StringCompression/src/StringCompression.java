
public class StringCompression {
	public String compressString(String s) {
		//char[] strChar=s.toCharArray();
		boolean[] char_set=new boolean[300];
		String res = null;
		int count=1;
		for (int i = 0; i < s.length(); i++) {
			int val=s.charAt(i);
			if(char_set[val])
				count++;
			else{
			count=1;
			char_set[val]=true;
			if(i!=0)
			res+=s.charAt(i-1)+count;
			}
		}
		if(res.length()<s.length())
		return res;
		else {
			return s;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringCompression().compressString("aabbbccc"));

	}

}
