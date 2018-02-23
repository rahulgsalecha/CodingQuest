public class myLinkedList {
	
	class LinkedListNode{
		int val;
		LinkedListNode next;
		
		LinkedListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	// List insert : before head, after tail , between 2 nodes
	// List delete : Delete one node, full delete
	// List search
	// List : Get Nth node
	// List : Get Nth from the last
	// Print middle element in the list
	
	LinkedListNode head;
	
	/* Inserts a new Node at front of the list. */
	public void insertAtStart(int data){
		LinkedListNode new_node = new LinkedListNode(data);
		new_node.next = head;
		head = new_node;
		
	}
	 /* Appends a new node at the end.*/
	public void insertAtEnd(int data){	
		LinkedListNode new_node = new LinkedListNode(data);
		if(head == null){
			head = new LinkedListNode(data);
			return;
		}
		new_node.next= null;
		
		LinkedListNode current = head;
		
		while(current.next !=null){
			current = current.next;
		}
		
		current.next = new_node;
		return;	
	}
	
	/* Inserts a new node after the given prev_node. */
	public void insertAfter(int data, LinkedListNode prev_node){	
		if(prev_node == null){
			System.out.println("The given previous node cannot be null");
			return;
		}
		LinkedListNode new_node = new LinkedListNode(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;	
	}
	
	/*Delete a Node in LinkedList*/
	public void delete(int key){
		if(head == null){
			System.out.println("There is nothing to delete, head is null");
			return;
		}
		
		LinkedListNode current = head;
		LinkedListNode previous = null;
		
		if(current != null && current.val == key){
			head = current.next;
			return;
		}
		
		while(current != null && current.val != key){
			previous = current;
			current = current.next;
		}
		
		if(current == null){
			System.out.println("There is nothing to delete, key is not present in list");
			return;
		}
		
		previous.next = current.next;
		return;
	}
	
	/* Function deletes the entire linked list */
    public void deleteList()
    {
        head = null;
    }
    
    public void printMiddle(){
    	LinkedListNode slow_ptr = head;
    	LinkedListNode fast_ptr = head;
		
		if(head !=null){
			while(fast_ptr != null && fast_ptr.next != null){
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next.next;
			}
			System.out.println("The middle element is [" +
                    slow_ptr.val + "] \n");
		}
	}
	
    public int GetNthNode(int index){
		int count = 0;
		LinkedListNode current = head;
		
		while(current != null){
			if(count ==index){
				return current.val;
			}
			current = current.next;
			count++;
		}
		
		assert(false);
        return 0;
	}
    
    public  void printNthFromLast(int n){
    	LinkedListNode main_ptr = head;
    	LinkedListNode ref_ptr = head;
		
		int count = 0;
		if(head !=null){
			while(count < n){
				if (ref_ptr == null)
                {
                    System.out.println(n+" is greater than the no "+
                                      " of nodes in the list");
                    return;
                }
				ref_ptr = ref_ptr.next;
                count++;
			}
			
			while (ref_ptr != null)
            {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no. "+n+" from last is "+
                               main_ptr.val);
		}
		
	}
    
	public void printList()
    {
		LinkedListNode tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.val+" ");
            tnode = tnode.next;
        }
    }
}
