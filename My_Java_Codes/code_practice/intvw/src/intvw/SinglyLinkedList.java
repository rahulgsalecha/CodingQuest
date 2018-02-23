package intvw;

public class SinglyLinkedList<T> {
	protected Node<T> head,tail;
	protected long size;
	
	public SinglyLinkedList () {
		head = tail = null;
		size = 0;
	}
	
	public Node<T> getFirst() {
        return head;
    }
 
    public Node<T> getLast() {
        return tail;
    }
 
    public long getSize() {
        return size;
    }
	
	//Add a node to the start of a list
	public void insertAtFirst(Node<T> node){
		//Set the tail only if this is the very first node
		if(tail == null){
			tail = node;
		}
		//Make the next of the new node refer to the head
		node.setNext(head);
		//Make node as head and give new value
		head = node;
		
		size++;
	}
	
	//Add a node at the end of the list
	public void insertAtEnd(Node<T> node){
		node.setNext(null);
		tail.setNext(node);
		tail = node;
		size++;
	}
	
	//Add a node after a certain node
	public void insertAfter(Node<T> curr_node, Node<T> new_node){

		if(curr_node == tail){
			tail = new_node;
			return;
		}
		
		Node<T> current = head;
		
		while(current.getNext() != null){
			if(current.getNext() == curr_node){			// x-> curr_node(current) -> curr_node.next
				new_node.setNext(current.getNext()); // x-> curr_node -----> new_node -> curr_node.next
				current.setNext(new_node);		   // x-> curr_node -> new_node -> new_node.next
			}
			
			current = current.getNext();
		}
		size++;
	}
	
	//Add a node before a certain node
	public void insertBefore(Node<T> curr_node, Node<T> new_node){
		
		Node<T> current = head;
		
		while(current.getNext() != null){
			if(current.getNext() == curr_node){		// x->curr_node(current)->curr_node.next
				new_node.setNext(current); 			// x-> new_node --> curr_node(current)-> curr_node.next
	            current = new_node;			//x-> new_node(current) -> curr_node ->curr_node.next
			}
			
			current = current.getNext();
		}
		
		size++;
		
	}
	//Remove first element from the list
	public Node<T> removeFirst(){
		if(head == null){
			return null;
		}
		//Save the one to return
		Node<T> temp = head;
		
		//do reference manipulation
		head = head.getNext();
		temp.setNext(null);
		size--;
		
		return temp;
	}
	
	//Remove last element from the list
	public Node<T> removeLast(){
		Node<T> NodeBefore;
		Node<T> NodeToRemove;
		
		if(size == 0){
			return null;
		}
		// Traverse through the list, 
		//getting a reference to the Node before the trailer. 
		//Since there is no previous reference.
        
		NodeBefore = getFirst();
		
		for (int count = 0; count < size - 2; count++)
			NodeBefore = NodeBefore.getNext();
		
		//Save the last node
		NodeToRemove = tail;
			
		// Let's do the pointer manipulation
	    NodeBefore.setNext(null);
	    tail = NodeBefore;
	    size--;
	    
	    return NodeToRemove;
		
	}
	
	// Remove a known Node from the list. No need to search or return a value. This method makes use of a 'before' reference in order to allow list manipulation.
    public void remove(Node<T> NodeToRemove) {
        // Declare local variables/references
    	Node<T> NodeBefore, currentNode;
 
        // Make sure we have something to remove
        if (size == 0)
            System.err.println("Error:  Attempt to remove fron an empty list");
 
        // Starting at the beginning check for removal
        currentNode = getFirst();
        if (currentNode == NodeToRemove)
            removeFirst();
        currentNode = getLast();
        if (currentNode == NodeToRemove)
            removeLast();
 
        // We've already check two Nodes, check the rest
        if (size - 2 > 0) {
            NodeBefore = getFirst();
            currentNode = getFirst().getNext();
            for (int count = 0; count < size - 2; count++) {
                if (currentNode == NodeToRemove) {
                    // remove current Node
                    NodeBefore.setNext(currentNode.getNext());
                    size--;
                    break;
                }
 
                // Change references
                NodeBefore = currentNode;
                currentNode = currentNode.getNext();
            } 
        } 
 
    }
	
	
	//Reverse
    
    public static void main(String[] args)
    {
    	SinglyLinkedList list = new SinglyLinkedList();
    	Node<String> node = new Node<String>(null, null);
    	
    	node.setData("l");
 		list.insertAtEnd(node);
 		
 		node.setData("i");
 		list.insertAtEnd(node);
 		
 		node.setData("s");
 		list.insertAtEnd(node);
 		
 		node.setData("t");
 		list.insertAtEnd(node);
 		
 		System.out.println(list);
 		
 		node.setData("Singly ");
 		list.insertAtFirst(node);
 		/*
 		node.setData(" !!!! ");
 	
 		
 		Node<String> node_1 = new Node<String>("Singly ", null);
 		Node<String> node_2 = new Node<String>("l ", null);
 		
 		list.insertBefore(node_1, node_2);
 		
 		
 		System.out.println(list);
 		*/
 		list.removeFirst();
 		System.out.println(list);
 		
 		list.removeLast();
 		System.out.println(list);
 		
 	}
	
}
