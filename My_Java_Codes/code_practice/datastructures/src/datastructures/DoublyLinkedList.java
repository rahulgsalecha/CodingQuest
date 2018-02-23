package datastructures;

public class DoublyLinkedList {
	
	protected DLNode start, end;
	public int size;
	
	public DoublyLinkedList(){
		start = end = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return start == null;
	}
	
	public int getSize(){
		return size;
	}
	
	/* Function to insert element at beginning */
	public void insertAtStart(int val){
		DLNode nptr = new DLNode(val,null,null);
		if(start == null){
			start = nptr;
			end = start;
		} else {
			start.setLinkNext(nptr);
			nptr.setLinkPrev(start);
			start = nptr;
		}
		size++;
	}
	
	/* Function to insert element at end */
	public void insertAtEnd(int val){
		DLNode nptr = new DLNode(val,null,null);
		if(start == null){
			start = nptr;
			end = start;
		} else {
			nptr.setLinkNext(end);
			end.setLinkPrev(nptr);
			end = nptr;
		}
		size++;
	}
	
	/* Function to insert element at position */
	public void insertAtPos(int val , int pos){
		DLNode nptr = new DLNode(val,null,null);
		if(pos == 1){
			insertAtStart(val);
			return;
		}
		DLNode ptr = start;
		for(int i=2; i<=size; i++){
			if(i==pos){
				DLNode tmp = ptr.getLinkNext();
				ptr.setLinkNext(nptr);
				nptr.setLinkPrev(ptr);
				nptr.setLinkNext(tmp);
				tmp.setLinkPrev(nptr);
			}
			ptr = ptr.getLinkNext();
		}
		size++;
	}
	
	/* Function to delete node at position */
	public void deleteAtPos(int val , int pos){
		if(pos == 1){
			if(size == 1){
				start = null;
				end = null;
				size =0;
				return;
			}
			start = start.getLinkNext();
			start.setLinkPrev(null);
			size--;
			return;
		}
		if(pos == size){
			end = end.getLinkPrev();
			end.setLinkNext(null);
			size--;
		}
		DLNode ptr = start;
		for(int i=2; i<=size; i++){
			if(i==pos){
				DLNode p = ptr.getLinkPrev();
				DLNode n = ptr.getLinkNext();
				
				p.setLinkNext(n);
				n.setLinkPrev(p);
				size--;
				return;
			}
			ptr = ptr.getLinkNext();
		}
	}
	
	/* Function to display status of list */
	public void display()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLinkNext() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        DLNode ptr = start;
        System.out.print(start.getData()+ " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }

}
