import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeSerializeBinaryTree {
	
	public static class Node {
		int data;
		Node left=null;
		Node right=null;
		public Node(int n){
			this.data=n;
		}
	}

	public static void main(String[] args) {
			Node root=createBinaryTree();
			// before serialize
			inorder(root);
			System.out.println();
			String serializedStr=serializeBinaryTree(root);
			System.out.println("serialized string, will be stored to file: "+serializedStr);
			root = deSerializeBinaryTree(serializedStr);
			// before deserialize
			inorder(root);
	}
	
	private static String serializeBinaryTree(Node root) {
		// preorder traversal
		if(root==null) return "x,";
		return root.data + ","
				+ serializeBinaryTree(root.left)
				+ serializeBinaryTree(root.right);
	}
	
	private static Node deSerializeBinaryTree(String serializedStr) {
		Queue<String> queue=new LinkedList<String>();
		String[] arr=serializedStr.split(",");
		queue.addAll(Arrays.asList(arr));
		Node root = deSerializeBinaryTree(queue);
		return root;
	}
	
	private static Node deSerializeBinaryTree(Queue<String> queue) {
		String val=queue.poll();
		if(val.equals("x")) return null;
		
		Node node=new Node(Integer.valueOf(val));
		node.left = deSerializeBinaryTree(queue);
		node.right = deSerializeBinaryTree(queue);
		return node;
	}

	public static Node createBinaryTree() {
		Node node1= new Node(1);
		Node node2= new Node(2);
		Node node3= new Node(3);
		Node node4= new Node(4);
		Node node5= new Node(5);
		Node node6= new Node(6);
		Node node7= new Node(7);
		Node node8= new Node(8);
		Node node9= new Node(9);
		Node root=node1;
		root.left=node2;
		root.right=node3;
		node2.left=node4;
		node3.left=node5;
		node2.right=node6;
		node3.right=node7;
		node6.right=node8;
		node7.left=node9;
		
		
//		              1
//               2         3
//             4   6     5    7
//		            8        9  
//		inorder traversal: 4, 2, 6, 8, 1, 5, 3, 9, 7
		return root;		
	}


	private static void inorder(Node root) {
		if(root==null)return;
		inorder(root.left);
		System.out.print(root.data+", ");
		inorder(root.right);
	}

}
