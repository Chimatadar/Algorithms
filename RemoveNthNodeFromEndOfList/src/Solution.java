import java.util.LinkedList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {

	public static void main(String[] args) {
		String s=" ";
		String[] words=s.split(" ");
		if(s.length()==0)
		{
			System.out.println("Empty");
		}
		
		/*List<ListNode> lists=new LinkedList<ListNode>();
		for(int i=0;i<5;i++){
		ListNode list=new ListNode(i);
		lists.add(list);
		}
		ListNode node=removeNthFromEnd(lists.get(0),2);*/
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow=head;
		ListNode fast=head;
		for(int i=0;i<n;i++)
		{
			fast=fast.next;
		}
		while(fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		slow.next=slow.next.next;
		while(slow.next!=null) slow=slow.next;
		return slow;
    }

}
