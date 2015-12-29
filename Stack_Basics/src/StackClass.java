
public class StackClass {

	public String reverse(String s)
	{
		StackOperations stack=new StackOperations();
		StringBuffer s1=new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			stack.push(s.charAt(i));
		}
		for(int i=0;i<stack.stackSize;i++)
		{
			s1.append(stack.pop());
		}
		return s1.toString();
	}
	public static void main(String[] args) {
		System.out.println(new StackClass().reverse("Hello"));
		StackOperations stackOperations=new StackOperations();
		
		stackOperations.push(1);
		stackOperations.push(2);
		stackOperations.push(3);
		
		System.out.println(stackOperations.pop());
		
		stackOperations.push(4);
		stackOperations.push(5);
		
		System.out.println(stackOperations.pop());
		System.out.println(stackOperations.pop());

	}

}
