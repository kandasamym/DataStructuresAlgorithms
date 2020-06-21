

public class BinarySearchTree {
	
	public static class Node {
		int n;
		Node left=null;
		Node right=null;
		public Node(int n){
			this.n=n;
		}
	}

	public static void main(String[] args) {
		Node root=null;
		int[] a= {1,3,2,5,4,6,7,11,100,3};
		for(int i=0;i<a.length;i++){
			root=insert(root,a[i]);
		}
		inorder(root);
		System.out.println();
		root= delete(root,3);
		root= delete(root,4);
		inorder(root);
		System.out.println();
		root= delete(root,1);
		inorder(root);
	}

	private static Node delete(Node root, int n) {
		if(root==null)return null;
		if(n<root.n){
			root.left=delete(root.left,n);
		}
		else if(n>root.n){
			root.right=delete(root.right,n);
		}
		else {
			if(root.left==null&&root.right==null)
				return null;
			else if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else {
				// get min from right subtree (that is left most node)
				Node min=getMin(root.right);
				root.n=min.n;
				root.right=delete(root.right,min.n);
			}
		}
		return root;
	}

	private static Node getMin(Node root) {
		if(root.left!=null){
			return getMin(root.left);
		}
		return root;
	}

	private static void inorder(Node root) {
		if(root==null)return;
		inorder(root.left);
		System.out.print(root.n+", ");
		inorder(root.right);
	}

	private static Node insert(Node root, int n) {
		if(root==null){
			root=new Node(n);
			return root;
		}
		if(n<=root.n) {
			root.left=insert(root.left,n);
		}
		else {
			root.right=insert(root.right,n);
		}
		return root;
	}
}
