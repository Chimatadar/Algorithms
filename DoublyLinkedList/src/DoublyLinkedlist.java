
public class DoublyLinkedlist {
	public Link head;
	int size=0;
	
	public DoublyLinkedlist(){
		head=null;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public void addFront(int data){

		if(head==null)
	{
      head=new Link(null,data,null);
	}
		else{
			Link node=new Link(data);
			node.prev=null;
			node.next=head;
			head=node;
		}
		size++;
		
	}
	
	public void addRear(int data)
	{
		if(head==null)
		{
			head=new Link(null,data,null);
		}
		else{
			Link current=head;
			while(current!=null)
				current=current.next;
			Link node=new Link(current, data, null);
			current.next=node;
		}
		size++;
	}
	
	public void removeFront()
	{
		if(head==null) return;
		head=head.next;
		head.prev=null;
		size--;
	}
	
	public void removeRear()
	{
		if(head==null) return;
		if(head.next==null)
		{
			head=null;
		}
		Link current=head;
		while (current.next.next!=null) {
			current=current.next;
		}
		current.next=null;
		size--;
	}
	
	public void insertAt(int data, int index) {
		if(head==null) return;
		if(index<1 && index>size) return;
		int i=0;
		Link current=head;
		while(i<index){
			current=current.next;
			i++;
		}
		if(current.prev==null)
		{
			Link node=new Link(null,data,current);
		}
		else {
			Link node=new Link(current.prev, data, current);
			current.prev=node;
		}
		
	}
	
	public void removeAt(int index) {
		if(head==null) return;
		if(index<0&&index>size) return;
		int i=0;
		Link current=head;
		while(i<index)
		{
			current=current.next;
			i++;
		}
		if(current.next==null)
			current.prev.next=null;
		else if(current.prev==null){
			current.next.prev=null;
			head=current.next;
		}
		else{
			current.next.prev=current.prev;
			current.prev.next=current.next;
		}
		
	}
	
	public void print()
	{
		Link current= head;
		while(current!=null)
		{
			System.out.println(current.data);
			current=current.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedlist list=new DoublyLinkedlist();
		list.addFront(3);
		list.addFront(4);
		list.addFront(5);
		
		list.print();
	}

}
