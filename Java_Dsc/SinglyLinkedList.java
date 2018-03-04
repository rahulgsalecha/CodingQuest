/* Java program for implementation of singly linked list */
class SinglyLinkedList<T> {

    ListNode<T> head, tail;
    int size;

    public class ListNode<T> {

        ListNode<T> next;
        T val;

        ListNode(T item) {
            this.next = null;
            this.val = item;
        }

    }

    SinglyLinkedList() {
        head = tail = null;
        size = 0;
    }

    /* Add a ListNode to the start of a list */
    public void insertAtFirst(T new_val) {

        ListNode<T> new_node = new ListNode<T>(new_val);

        if(tail == null) {
            tail = new_node;
        }
        
        new_node.next = head;
        head = new_node;
        size++;
    }

    /* Add a ListNode at the end of the list */
    public void insertAtLast(T new_val) {

        ListNode<T> new_node = new ListNode<T>(new_val);

        new_node.next = null;
        tail.next = new_node;
        tail = new_node;
        size++;
    }

    /* Add a ListNode after a certain ListNode */
    public void insertAfter(T new_val, T curr_val){
        ListNode<T> new_node = new ListNode<T>(new_val);
        ListNode<T> curr_node = new ListNode<T>(curr_val);

        if(curr_node == tail) {
            tail = new_node;
            return;
        }

        ListNode<T> dummy = head;

        while(dummy.next != null) {
            if(dummy.next == curr_node) {
                new_node.next = curr_node.next;
                curr_node.next = new_node;
            }
            dummy = dummy.next;
        }
        
        size++;
        
    }

    /*Add a ListNode before a certain ListNode*/
    public void insertBefore(T new_val, T curr_val){

        ListNode<T> new_node = new ListNode<T>(new_val);
        ListNode<T> curr_node = new ListNode<T>(curr_val);

        ListNode<T> dummy = head;
        while(dummy.next != null) {
            if(dummy.next == curr_node) {
                new_node.next = dummy;
                dummy = new_node;
            }

            dummy = dummy.next;
        }

        size++;
    }

    /* Remove first element from the list */
    public ListNode<T> removeFirst() {
        if(head == null) {
            return null;
        }

        ListNode<T> temp = head;

        head = head.next;
        temp.next = null;
        size--;

        return temp;
    }

    /* Remove last element from the list */
    public ListNode<T> removeLast(){
        ListNode<T> node_before;
        ListNode<T> node_to_remove;

        if(size == 0) {
            return null;
        }

        node_before = head;

        for (int i=0; i<size-2;i++){
            node_before = node_before.next;
        }

        node_to_remove = tail;

        node_before.next = null;
        tail = node_before;

        size--;

        return node_to_remove;
    }

    /* Remove a known ListNode from the list. */
    public void remove(T ListNodeToRemoveVal) {
        ListNode<T> ListNodeToRemove = new ListNode<T> (ListNodeToRemoveVal);
        ListNode<T> ListNodeBefore, currentListNode;

        if(size == 0)
            System.err.println("Error:  Attempt to remove fron an empty list");
         
        currentListNode = head;

        if (currentListNode == ListNodeToRemove)
            removeFirst();

        currentListNode = tail;

        if (currentListNode == ListNodeToRemove)
            removeLast();

        if(size - 2 > 0) {
            ListNodeBefore = head;
            currentListNode = head.next;

            for (int i=0; i<size-2;i++){
                if(currentListNode == ListNodeToRemove){
                    ListNodeBefore.next = currentListNode.next;
                    size--;
                    break;
                }

                ListNodeBefore = currentListNode;
                currentListNode = currentListNode.next;
            }
        }
    }


    public static void main(String[] args) {
       SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

       list.insertAtFirst(3);
       list.insertAtFirst(2);
       list.insertAtLast(5);
       list.insertAtFirst(1);
       list.insertAtLast(6);

       list.removeFirst();
       

       SinglyLinkedList<Integer> print_list = new SinglyLinkedList<Integer>();
       print_list = list;

       while(print_list.head != null) {
           System.out.print(" "+print_list.head.val);
           print_list.head = print_list.head.next;
       }

       System.out.println("");
    }
}

/*
 * Output : 2 3 5 6
 */
