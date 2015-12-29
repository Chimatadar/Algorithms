import java.util.Stack;

public class SortingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> stack=new Stack<Integer>();
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(5);
		
/*		System.out.println("Without Sorting:");
		for(int i=0;i<stack.size();i++)
		{
			System.out.print(stack.pop()+" ");
		}*/
		
		System.out.println();
		
		Stack<Integer> stack1=new Stack<Integer>();
		
		while(!stack.isEmpty()){
		int x=stack.pop();
		
			
		    while(stack1.peek()>x && !stack1.isEmpty())
		    {
		    	stack.push(stack1.pop());
		    	
		    }
		    
				stack1.push(x);
			
		
		
		System.out.println("Sorted");
		for(int i=0;i<stack1.size();i++)
		{
			System.out.print(stack1.pop()+" ");
		}
	}

	}
}
