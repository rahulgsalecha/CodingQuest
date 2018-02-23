import java.util.Scanner;

public class DoublyLinkedList {
	
	public class DoublyListNode {
		
		protected int data;
		protected DoublyListNode next,prev;
		
		public DoublyListNode(){
			next = null;
			prev = null;
			data = 0;
		}
		
		public DoublyListNode(int d, DoublyListNode n, DoublyListNode p){
			next = n;
			prev = p;
			data = d;
		}
		
		/* Function to set link to next node */
		public void setLinkNext(DoublyListNode n){
			next = n;
		}
		
		/* Function to get link to next node */
		public DoublyListNode getLinkNext(){
			return next;
		}
		
		/* Function to set link to prev node */
		public void setLinkPrev(DoublyListNode p){
			prev = p;
		}
		
		/* Function to get link to prev node */
		public DoublyListNode getLinkPrev(){
			return prev;
		}
		
		/* Function to set data to  node */
		public void setData(int d){
			data = d;
		}
		
		/* Function to get link to prev node */
		public int getData(){
			return data;
		}
		
		
	}
	
	protected DoublyListNode start,end;
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
		DoublyListNode nptr = new DoublyListNode(val,null,null);
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
		DoublyListNode nptr = new DoublyListNode(val,null,null);
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
		DoublyListNode nptr = new DoublyListNode(val,null,null);
		if(pos == 1){
			insertAtStart(val);
			return;
		}
		DoublyListNode ptr = start;
		for(int i=2; i<=size; i++){
			if(i==pos){
				DoublyListNode tmp = ptr.getLinkNext();
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
		DoublyListNode ptr = start;
		for(int i=2; i<=size; i++){
			if(i==pos){
				DoublyListNode p = ptr.getLinkPrev();
				DoublyListNode n = ptr.getLinkNext();
				
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
        DoublyListNode ptr = start;
        System.out.print(start.getData()+ " <-> ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getData()+ " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }

	 public static void main(String[] args)
	    {            
	        Scanner scan = new Scanner(System.in);
	        /* Creating object of linkedList */
	        DoublyLinkedList list = new DoublyLinkedList(); 
	        System.out.println("Doubly Linked List Test\n");          
	        char ch;
	        /*  Perform list operations  */
	        do
	        {
	            System.out.println("\nDoubly Linked List Operations\n");
	            System.out.println("1. insert at begining");
	            System.out.println("2. insert at end");
	            System.out.println("3. insert at position");
	            System.out.println("4. delete at position");
	            System.out.println("5. check empty");
	            System.out.println("6. get size");
	 
	            int choice = scan.nextInt();            
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                list.insertAtStart( scan.nextInt() );                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter integer element to insert");
	                list.insertAtEnd( scan.nextInt() );                     
	                break;                         
	            case 3 : 
	                System.out.println("Enter integer element to insert");
	                int num = scan.nextInt() ;
	                System.out.println("Enter position");
	                int pos = scan.nextInt() ;
	                if (pos < 1 || pos > list.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                    list.insertAtPos(num, pos);
	                break;                                          
	            case 4 : 
	            	System.out.println("Enter integer element to insert");
	            	int n = scan.nextInt() ;
	                System.out.println("Enter position");
	                int p = scan.nextInt() ;
	                if (p < 1 || p > list.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                    list.deleteAtPos(p,n);
	                break;     
	            case 5 : 
	                System.out.println("Empty status = "+ list.isEmpty());
	                break;            
	            case 6 : 
	                System.out.println("Size = "+ list.getSize() +" \n");
	                break;                         
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }    
	            /*  Display List  */ 
	            list.display();
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);    
	 
	        } while (ch == 'Y'|| ch == 'y');               
	    }

}
