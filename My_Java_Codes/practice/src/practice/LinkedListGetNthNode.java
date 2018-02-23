package practice;

public class LinkedListGetNthNode {
	
	static Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public static int GetNthNode(int index){
		int count = 0;
		Node current = head;
		
		while(current != null){
			if(count ==index){
				return current.data;
			}
			current = current.next;
			count++;
		}
		
		assert(false);
        return 0;
	}
	
	public void push(int new_data)
    {
 
        /* 1. alloc the Node and put data*/
        Node new_Node = new Node(new_data);
 
        /* 2. Make next of new Node as head */
        new_Node.next = head;
 
        /* 3. Move the head to point to new Node */
        head = new_Node;
    }
 
    /* Drier program to test above functions*/
    public static void main(String[] args)
    {
        /* Start with empty list */
    	LinkedListGetNthNode llist = new LinkedListGetNthNode();
 
        /* Use push() to construct below list
           1->12->1->4->1  */
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);
 
        /* Check the count function */
        System.out.println("Element at index 3 is "+llist.GetNthNode(3));
    }
	
	

}
