
//CTCI : 2.2 : Implement an algorithm to find the kth to last element of a singly linked list.

public class nthToLast_iterative {
	
	/* 
	 * We can use two pointers, p1 and p2.
	 * We place them k nodes apart in the linked list by putting p1 at the beginning 
	 * and moving p2 k nodes into the list. 
	 * Then, when we move them at the same pace, p2 will hit the end of the linked list 
	 * after LENGTH - k steps. At that point, p1 will be LENGTH - k nodes into the list, 
	 * or k nodes from the end.
	*/
	
	public class LinkedListNode{
		LinkedListNode next = null;
		int data;
		
		public LinkedListNode(int d){
			data =d;
		}
	}
	
	LinkedListNode nthToLast(LinkedListNode head, int k ){
		
		if(k<=0){
			return null;
		}
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		// Move p2 forward nodes into the list.
		for (int i = 0; i < k - 1; i++) {
			p2 = p2.next;
		}
		
		if (p2 == null) return null;
		
		/* Now, move p1 and p2 at the same speed. 
		 * When p2 hits the end,
		 * p1 will be at the right element. */
		
		while(p2.next != null) { 
			p1 =p1.next;
			p2 =p2.next;
		}
		return p1;
	}

}
