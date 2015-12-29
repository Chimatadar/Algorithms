
public class QueueClass {

	public static void main(String[] args) {
		Queue queue=new Queue();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		System.out.println(queue.pop());
		queue.push(4);
		queue.push(5);
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());

	}

}
