
//CTCI : 2.2 : Implement an algorithm to find the kth to last element of a singly linked list.

public class nthToLast_recursive {

	/*
	 * This algorithm recurses through the linked list. 
	 * When it hits the end, the method passes back a counter set to 0. 
	 * Each parent call adds 1 to this counter. When the counter equals k, 
	 * we know we have reached the kth to last element of the linked list.
	 */
	
	public class LinkedListNode{
		LinkedListNode next = null;
		int data;
		
		public LinkedListNode(int d){
			data =d;
		}
	}
	
	public static int nthToLast(LinkedListNode head, int k) {
		if(head == null) {
			return 0;
		}
		
		int i = nthToLast(head.next, k) + 1;
		if (i == k) {
			System.out.println(head.data);
		}
		
		return i;
		
	}
}
