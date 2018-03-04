/* Java implementation of Linked List Data Structure */
class LinkedList {

    LinkedListNode head;

    class LinkedListNode {

        LinkedListNode next;
        int val;

        LinkedListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /*
     List insert : before head, after tail , between 2 nodes
     List delete : Delete one node, full delete
     List search
     List : Get Nth node
     List : Get Nth from the last
     Print middle element in the list 
    */

    /* Insert at Front of the List */
    public void insertAtFront(int data) {
        LinkedListNode new_node = new LinkedListNode(data);
        new_node.next = head;
        head = new_node;
    }

    /* Append a new node at the end of the list */
    public void insertAtLast(int data) {
        LinkedListNode new_node = new LinkedListNode(data);
        if(head == null) {
            head = new LinkedListNode(data);
            return;
        }

        new_node.next = null;

        LinkedListNode current = head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = new_node;
        return;
    }

    /* Inserts a new node after the given prev_node. */
    public void insertAfter(int data, LinkedListNode prev_node) {

        if(prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        LinkedListNode new_node = new LinkedListNode(data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    /*Delete a Node in LinkedList*/
    public void delete(int key) {

        if(head == null) {
            System.out.println("There is nothing to delete, head is null");
            return;
        }

        LinkedListNode current = head;
        LinkedListNode previous = null;

        if(current != null && current.val == key) {
            head = current.next;
            return;
        }

        while(current != null && current.val != key) {
            previous = current;
            current = current.next;
        }

        if(current == null) {
            System.out.println("There is nothing to delete, key is not present in list");
            return;
        }

        previous.next = current.next;
        return;
    }

    /* Function deletes the entire linked list */
    public void deleteList() {
        head = null;
    }

    /* Print Middle element in the list */
    public void printMiddle() {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        if(head != null) {
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("The middle element is [" + slow.val + "]");
        }
    }

    /* Get Nth node in the list */
    public int getNthNode(int index) {
        int count = 0;
        LinkedListNode current = head;

        while (current != null) {
            if ( count == index) {
                return current.val;
            }
            current = current.next;
            count++;
        }

        assert(false);
        return 0;
    }

    /* Print Nth from Last */
    public void printNthFromLast(int n){
        LinkedListNode main_ptr = head;
        LinkedListNode ref_ptr = head;

        int count = 0;
        if(head != null) {
            while ( count < n) {
                if(ref_ptr == null) {
                    System.out.println(n+" is greater than the no "+" of nodes in the list");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count++;
            }

            while(ref_ptr !=null) {
                main_ptr = main_ptr.next;
                ref_ptr = ref_ptr.next;
            }
            System.out.println("Node no. "+n+" from last is "+main_ptr.val);
        }
    }

    public void printList() {
        LinkedListNode tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.val+" ");
            tnode = tnode.next;

        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtFront(1);
        list.insertAtFront(10);
        list.insertAtFront(100);
        list.insertAtFront(1000);
        list.insertAtFront(10000);
        
        list.insertAtLast(2);
        list.insertAtLast(20);
        list.insertAtLast(200);
        list.insertAtLast(2000);
        list.insertAtLast(20000);

        //LinkedListNode node = new LinkedListNode(1);
        list.insertAfter(9999, list.head);

        System.out.print("List Before deleting : ");
        list.printList();

        list.delete(1000);

        System.out.print("List After deleting :");
        list.printList();

        list.printMiddle();
        System.out.println("Get 6th Node from list : " + list.getNthNode(6));
        list.printNthFromLast(3);
    }
}
/*
 * Output : 
 *
 * List Before deleting : 10000 9999 1000 100 10 1 2 20 200 2000 20000 
 * List After deleting :10000 9999 100 10 1 2 20 200 2000 20000 
 * The middle element is [2]
 * Get 6th Node from list : 20
 * Node no. 3 from last is 200
 *
 */
