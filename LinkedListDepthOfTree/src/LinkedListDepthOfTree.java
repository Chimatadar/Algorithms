import java.util.ArrayList;
import java.util.LinkedList;

class Node{
	int key;
	Node left;
	Node right;
	public Node(int key) {
		// TODO Auto-generated constructor stub
	this.key=key;
	}
}
public class LinkedListDepthOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node=new Node(5);
		int level=0;
		ArrayList<LinkedList<Node>> lists=new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(lists, node, level);
	}

	private static void createLevelLinkedList(ArrayList<LinkedList<Node>> lists, Node node, int level) {
		// TODO Auto-generated method stub
		if(node==null)
			return;
		LinkedList<Node> list;
		if(lists.size()==level)
		{
			list=new LinkedList<>();
			lists.add(list);
		}
		else{
			list=lists.get(level);
		}
		list.add(node);
		
		createLevelLinkedList(lists, node.left, level+1);
		createLevelLinkedList(lists, node.right, level+1);
		
	}

}
