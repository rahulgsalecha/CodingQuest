
// CTCI 2.7 : Implement a function to check if a linked list is a palindrome.

public class isPalindrome_LinkedList {

	// Solution 1 : Reverse and Compare
	// Solution 2 : Iterative Approach : fast & slow runners
	// Solution 3 : Recursive Approach

	
	public class ListNode{
		ListNode next = null;
		int val;
		
		public ListNode(int d){
			val =d;
		}
	}
	
	
	// Solution 1 : Reverse and Compare : We can create a new list in reversed order and then compare each node. 
	//				The time and space are O(n).
	
	public boolean isPalindrome_ReverseCompare(ListNode head) {
		if(head == null)
	        return true;
		
		ListNode p = head;
	    ListNode prev = new ListNode(head.val); // new list for reversed order
	    
	    // Create a reversed order list : Reverse the pointers
	    
	    // Eg : 1-> 2 -> 3 -> 4 -> 5
	    // p = 1
	    // prev = 1
	    
	    // temp = 2 ( p = 2)
	    // temp.next = 1
	    // prev = 2
	    // p = 3	
	    
	    // temp = 3
	    // temp.next = 2
	    // prev = 3 
	    // p = 4
	    
	    // temp = 4
	    // temp.next = 3
	    // prev = 4
	    // p = 5

	    while(p.next != null){
	        ListNode temp = new ListNode(p.next.val);
	        temp.next = prev;
	        prev = temp;
	        p = p.next;
	    }
	    
	    ListNode p1 = head; // original list
	    ListNode p2 = prev; // reversed list
	    
	    while(p1!=null){
	        if(p1.val != p2.val)
	            return false;
	 
	        p1 = p1.next;
	        p2 = p2.next;
	    }
		
		return true;
		
	}
	
	
	// Solution 2 : Iterative Approach : Using fast & slow pointers : Break and reverse second half
	// 				We can use a fast and slow pointer to get the center of the list, then reverse the 
	//				second list and compare two sublists. The time is O(n) and space is O(1).
	
	
	public boolean isPalindrome_Iterative(ListNode head) {
		if(head == null || head.next==null)
	        return true;
	 
	    //find list center
	    ListNode fast = head;
	    ListNode slow = head;
	 
	    while(fast.next!=null && fast.next.next!=null){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    
	    ListNode secondHead = slow.next;
	    slow.next = null;
	 
	    //reverse second part of the list
	    ListNode p1 = secondHead;
	    ListNode p2 = p1.next;
	    
	    while(p1!=null && p2!=null){
	        ListNode temp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = temp;
	    }
	    
	    secondHead.next = null;
	    
	    //compare two sublists now
	    ListNode p = (p2==null?p1:p2);
	    ListNode q = head;
	    while(p!=null){
	        if(p.val != q.val)
	            return false;
	 
	        p = p.next;
	        q = q.next;
	 
	    }
	 
	    return true;
	}
	
	// Solution 3 : Recursive Approach : Time is O(n) and space is O(1).

	public class Solution3_Recursive {
	    ListNode left;
	 
	    public boolean isPalindrome(ListNode head) {
	        left = head;
	 
	        boolean result = helper(head);
	        return result;
	    }
	 
	    public boolean helper(ListNode right){
	 
	        //stop recursion
	        if (right == null)
	            return true;
	 
	        //if sub-list is not palindrome,  return false
	        boolean x = helper(right.next);
	        if (!x)
	            return false;
	 
	        //current left and right
	        boolean y = (left.val == right.val);
	 
	        //move left to next
	        left = left.next;
	 
	        return y;
	    }
	}
	
	
}
