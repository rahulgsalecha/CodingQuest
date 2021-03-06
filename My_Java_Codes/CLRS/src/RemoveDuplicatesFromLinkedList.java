import java.util.Hashtable;


// CTCI 2.1 : Write code to remove duplicates from an unsorted linked list.
// How would you solve this problem if a temporary buffer is not allowed?

// Eg : 1->2->3->4->4->5->6->3->7
// We need to remove 3,4 duplicates.

public class RemoveDuplicatesFromLinkedList {
	
	// Solution 1 : Iterate through each and every element and compare and remove
	// Solution 2 : Hashtable
	
	//Using Solution2
	
	public class LinkedListNode{
		LinkedListNode next = null;
		int data;
		
		public LinkedListNode(int d){
			data =d;
		}
	}
	
	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		
		while(n!=null){
			if(table.containsKey(n.data)){
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;	
		}	
	}
	
	
	//How would you solve this problem if a temporary buffer is not allowed?
	public static void deleteDupsWithoutBuffer(LinkedListNode head) {
		if (head == null) {
			return;
		}
		
		LinkedListNode current = head; 
		
		while (current != null) {
			/* Remove all future nodes that have the same value */ 
			LinkedListNode runner = current;
			
			while (runner.next != null) {
				if (runner.next.data == current.data) { 
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				} 
			}
			current = current.next;
		}
	}

}
