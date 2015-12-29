class LinkedList{
	private int data;
	public LinkedList next;
	
	public LinkedList(int data)
	{
		this.data=data;
	}
	
	public int getData()
	{
		return data;
	}
}
public class LinkedListClass {
	private LinkedList head;
	
	public LinkedListClass()
	{
		head=null;
	}
	
	public boolean IsEmpty(){
		return head==null;
	}
	public void Insert(int data)
	{
		LinkedList node=new LinkedList(data);
		node.next=head;
		head=node;
	}
	public boolean delete()
	{
		if(head==null)
			return false;
		
		head=head.next;
		return true;
	}
	public void print()
	{
		LinkedList current=head;
		while(current!=null){
			System.out.println(current.getData());
			current=current.next;
		}
	}
	public static void main(String[] args) {
		LinkedListClass list= new LinkedListClass();
		list.Insert(1);
		list.Insert(2);
		list.Insert(3);
		list.print();
		list.delete();
		list.print();

	}

}
