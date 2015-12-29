import java.util.Stack;

public class Queue {

	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	
	public void queuePush(int item) {
		stack1.push(item);
	}
	
	public Integer queuePop() {
		while(stack1.size()>1)
		{
			int x=stack1.pop();
			stack2.push(x);
		}
		int data=stack1.pop();
while(stack2.size()>0)
{
  stack1.push(stack2.pop());	
}
		
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue queue=new Queue();
		queue.queuePush(1);
		queue.queuePush(2);
		queue.queuePush(3);
		
		System.out.println(queue.queuePop());
		System.out.println(queue.queuePop());
		System.out.println(queue.queuePop());
	}

}
