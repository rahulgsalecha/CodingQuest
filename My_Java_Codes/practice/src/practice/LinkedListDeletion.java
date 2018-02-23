package practice;

public class LinkedListDeletion {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int d){
			data =d;
			next = null;
		}
	}

	void deleteNode(int key){
		
		Node temp = head, prev = null;
		
		if (temp != null && temp.data == key)
        {
            head = temp.next; // Changed head
            return;
        }
		
		while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }   
		
		if (temp == null) return;
		
		prev.next = temp.next;
		
	}
	
	public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
 
	public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
	
	public static void main(String[] args)
    {
		LinkedListDeletion llist = new LinkedListDeletion();
 
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
 
        System.out.println("\nCreated Linked list is:");
        llist.printList();
 
        llist.deleteNode(1); // Delete node at position 4
 
        System.out.println("\nLinked List after Deletion at position 4:");
        llist.printList();
    }
}

