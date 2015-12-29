
public class QueueUsingCircularArray {

	int[] array;
	int front;
	int rear;
	int N;
	
	public QueueUsingCircularArray(int N)
	{
		array=new int[N];
		front=0;
		rear=0;
		this.N=N;
	}
	public boolean Isempty(){
		return front==rear;
	}
	
	public Integer size(){
		return (N-front+rear) % N;
	}
	
	public void resize(){
		int s=N;
		N*=2;
		int[] arr=new int[N];
		int i=0;
		while(s>0)
		{
			s--;
			arr[i++]=array[front++];
			if(front==s)
				front=0;

		}
		front=0;
		rear=i+1;
		array=arr;
	}
	
	public void Enqueue(int data){
		int s=size();
		if(s==N-1)
			resize();
		array[rear++]=data;
		if(rear==N)
			rear=0;
	}
	
	public Integer Dequeue(){
		if(Isempty())
			return null;
		int x=array[front++];
		if(front==N)
			front=0;
		return x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
