
public class Queue {
		int[] object;
		int front;
		int rear;
		int queueSize;
		
		public Queue()
		{
			front=-1;
			rear=-1;
			queueSize=1;
			object=new int[queueSize];
			
		}
		
		public void push(int item)
		{
			if(front+1>=queueSize)
			resize();
			object[++front]=item;
		}
		
		public Integer pop()
		{
			if(front>rear)
			{
				return object[++rear];
			}
			return null;
		}
		
		public boolean isEmpty()
		{
			return front<=rear;
		}

		private void resize() {
			int[] temp=object;
			queueSize*=2;
			object=new int[queueSize];
			
			for(int i=0;i<=front;i++)
			{
				object[i]=temp[i];
			}
			
		}
}
