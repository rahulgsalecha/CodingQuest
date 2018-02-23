

public class SinglyLinkedList<T> {
	protected ListNode<T> head,tail;
	protected long size;
	
	public static class ListNode<T> {
		private ListNode<T> next;
		private T data;

		public  ListNode(T val, ListNode<T> n){
			this.next = n;
			this.data = val;
		}
		
		public T getData(){
			return data;
		}
		
		public ListNode<T> getNext(){
			return next;
		}
		
		public void setData(T val){
			this.data = val;
		}
		
		public void setNext(ListNode<T> n){
			this.next = n;
		}

	}
	
	public SinglyLinkedList(){
		head=tail=null;
		size = 0;
	}
	
	public ListNode<T> getFirst() {
        return head;
    }
 
    public ListNode<T> getLast() {
        return tail;
    }
 
    public long getSize() {
        return size;
    }
    
    //Add a ListNode to the start of a list
    public void insertAtFirst(ListNode<T> node){
    	//Set the tail only if this is the very first ListNode
    	if(tail == null){
			tail = node;
		}
    	//Make the next of the new ListNode refer to the head
    	node.setNext(head); //ListNode.next = head;
    	
    	//Make ListNode as head and give new value
    	head = node;
    	
    	size++;
    }
    
    //Add a ListNode at the end of the list
    public void insertAtEnd(ListNode<T> node){
    	node.setNext(null);
    	tail.setNext(node);
    	tail = node;
    	size++;
    }
    
  //Add a ListNode after a certain ListNode
  	public void insertAfter(ListNode<T> curr_ListNode, ListNode<T> new_ListNode){

  		if(curr_ListNode == tail){
  			tail = new_ListNode;
  			return;
  		}
  		
  		ListNode<T> current = head;
  		
  		while(current.getNext() != null){
  			if(current.getNext() == curr_ListNode){			// x-> curr_ListNode(current) -> curr_ListNode.next
  				new_ListNode.setNext(current.getNext()); // x-> curr_ListNode -----> new_ListNode -> curr_ListNode.next
  				current.setNext(new_ListNode);		   // x-> curr_ListNode -> new_ListNode -> new_ListNode.next
  			}
  			
  			current = current.getNext();
  		}
  		size++;
  	}
  	
  //Add a ListNode before a certain ListNode
  	public void insertBefore(ListNode<T> curr_ListNode, ListNode<T> new_ListNode){
  		
  		ListNode<T> current = head;
  		
  		while(current.getNext() != null){
			if(current.getNext() == curr_ListNode){		// x->curr_ListNode(current)->curr_ListNode.next
				new_ListNode.setNext(current); 			// x-> new_ListNode --> curr_ListNode(current)-> curr_ListNode.next
	            current = new_ListNode;			//x-> new_ListNode(current) -> curr_ListNode ->curr_ListNode.next
			}
			
			current = current.getNext();
		}
  		size++;
  	}
  	
  	
  //Remove first element from the list
  	public ListNode<T> removeFirst(){
		if(head == null){
			return null;
		}
		//Save the one to return
		ListNode<T> temp = head;
		
		//do reference manipulation
		head = head.getNext();
		temp.setNext(null);
		size--;
		
		return temp;
	}
  	
  //Remove last element from the list
  	public ListNode<T> removeLast(){
  		ListNode<T> ListNodeBefore;
		ListNode<T> ListNodeToRemove;
		
		if(size == 0){
			return null;
		}
		// Traverse through the list, 
		//getting a reference to the ListNode before the trailer. 
		//Since there is no previous reference.
        
		ListNodeBefore = getFirst();
		
		for (int count = 0; count < size - 2; count++)
			ListNodeBefore = ListNodeBefore.getNext();
		
		//Save the last ListNode
		ListNodeToRemove = tail;
			
		// Let's do the pointer manipulation
	    ListNodeBefore.setNext(null);
	    tail = ListNodeBefore;
	    size--;
	    
	    return ListNodeToRemove;
  	}
  	
  	// Remove a known ListNode from the list. 
  	// No need to search or return a value. 
  	// This method makes use of a 'before' reference in order to allow list manipulation.
  	public void remove(ListNode<T> ListNodeToRemove) {
        // Declare local variables/references
    	ListNode<T> ListNodeBefore, currentListNode;
 
        // Make sure we have something to remove
        if (size == 0)
            System.err.println("Error:  Attempt to remove fron an empty list");
 
        // Starting at the beginning check for removal
        currentListNode = getFirst();
        if (currentListNode == ListNodeToRemove)
            removeFirst();
        currentListNode = getLast();
        if (currentListNode == ListNodeToRemove)
            removeLast();
 
        // We've already check two ListNodes, check the rest
        if (size - 2 > 0) {
            ListNodeBefore = getFirst();
            currentListNode = getFirst().getNext();
            for (int count = 0; count < size - 2; count++) {
                if (currentListNode == ListNodeToRemove) {
                    // remove current ListNode
                    ListNodeBefore.setNext(currentListNode.getNext());
                    size--;
                    break;
                }
 
                // Change references
                ListNodeBefore = currentListNode;
                currentListNode = currentListNode.getNext();
            } 
        } 
 
    }
}