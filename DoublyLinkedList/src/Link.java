
public class Link {
	int data;
	Link prev;
	Link next;
	
	public Link(int data)
	{
		prev=null;
		next=null;
		this.data=data;
	}
	
	public Link(Link prev, int data, Link next)
	{
		this.prev=prev;
		this.data=data;
		this.next=next;
	}
}
