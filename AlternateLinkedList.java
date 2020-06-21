

public class AlternateLinkedList {
	
	public static class Node {
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}


	public static void main(String[] args) {
		int[] a= {1,2,5,4,7,8};
		Node head =createLinkedList(a);

		Node lastNode = makeAlternateLink(head);
		lastNode.next=null;
		printLinkedList(head);
		
//		Node newHead = reverseLink(head);
//		head.next=null;
//		printLinkedList(newHead);
		
	}

	private static Node makeAlternateLink(Node current) {
		if(current==null || current.next==null)
			return current;
		Node next = current.next;
		if(next.next!=null){
			current.next=next.next;
			Node node = makeAlternateLink(next.next);
			node.next=next;
		}		
		return next;
	}
	
	private static Node reverseLink(Node current) {
		if(current==null||current.next==null)
			return current;
		Node next = reverseLink(current.next);
		current.next.next=current;
//		current.next=null;
		
		return next;
	}

	private static void printLinkedList(Node head) {
		while(head!=null)
		{
			System.out.print(head.data+"->");
			head=head.next;
		}	
		System.out.println();
	}

	private static Node createLinkedList(int[] a) {
		Node head=null;
		Node tail =null;
		for(int i=0;i<a.length;i++){
			Node node = new Node(a[i]);
			if(tail==null){
				tail =node;
				head=node;
			}
			else{
				tail.next=node;
				tail = node;
			}
		}
		return head;
	}
}
