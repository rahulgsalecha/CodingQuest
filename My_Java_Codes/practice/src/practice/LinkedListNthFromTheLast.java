package practice;

public class LinkedListNthFromTheLast {
	static Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static void printNthFromLast(int n){
		Node main_ptr = head;
		Node ref_ptr = head;
		
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
                               main_ptr.data);
		}
		
	}
	
	/* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /*Drier program to test above methods */
    public static void main(String [] args)
    {
    	LinkedListNthFromTheLast llist = new LinkedListNthFromTheLast();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);
 
        llist.printNthFromLast(3);
    }

}
