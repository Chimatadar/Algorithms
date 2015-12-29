import java.nio.Buffer;

class Node{
	int key;
	String name;
	Node leftChild;
	Node rightChild;
	
	public Node(int key, String name) {
		this.key=key;
		this.name=name;

	}
	public String toString() {
		return "Key is "+key+" Name is "+name;
	}
}

class BinaryTreeImplementation{
	Node root;
	public void addNode(int key, String name) {
		Node newnode=new Node(key, name);
		if(root==null)
		{
			root=newnode;
		}
		else {
			Node focusNode=root;
			
			while(true)
			{
				Node parent=focusNode;
				if(key<focusNode.key)
				{
					focusNode=focusNode.leftChild;
					if(focusNode==null)
					{
						parent.leftChild=newnode;
						return;
					}
				}
				else {
					focusNode=focusNode.rightChild;
					if(focusNode==null)
					{
						parent.rightChild=newnode;
						return;
					}
				}
			}
		}
	}
	public void inOrderTraversing(Node focusNode) {
		if(focusNode!=null)
		{
			inOrderTraversing(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraversing(focusNode.rightChild);
		}
		
	}
	

public int size(Node node){
if(node==null)
	return 0;
return (size(node.leftChild)+1+size(node.rightChild));
}

public  boolean identicalTrees(Node n1, Node n2) {
	if(n1==null && n2==null)
	{
		return true;
	}
	if(n1!=null && n2!=null) {
		return ((n1.key==n2.key) && identicalTrees(n1.leftChild, n2.leftChild) && identicalTrees(n1.rightChild, n2.rightChild));
	}
	return false;
}
public void preOrderTraversing(Node focusNode) {
	if(focusNode!=null)
	{
		System.out.println(focusNode);
		preOrderTraversing(focusNode.leftChild);
		
		preOrderTraversing(focusNode.rightChild);
	}
	
}


public void postOrderTraversing(Node focusNode) {
	if(focusNode!=null)
	{
		postOrderTraversing(focusNode.leftChild);
		
		postOrderTraversing(focusNode.rightChild);
		System.out.println(focusNode);
	}
	
}

public Node find(int key) {
	Node focusNode=root;
	while (focusNode.key!=key) {
				if(key<focusNode.key)
					focusNode=focusNode.leftChild;
				else {
					focusNode=focusNode.rightChild;
				}
				if(focusNode==null)
					return null;
	}
	return focusNode;
}
}
public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeImplementation tree=new BinaryTreeImplementation();
		tree.addNode(10, "bob");
		tree.addNode(15, "sam");
		tree.addNode(9, "sun");
		tree.addNode(11, "moon");
		tree.addNode(8, "earth");
		tree.addNode(20, "mars");
		
		System.out.println(tree.size(tree.root));
		//tree.inOrderTraversing(tree.root);

	}

}
