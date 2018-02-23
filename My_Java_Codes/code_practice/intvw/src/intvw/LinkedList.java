package intvw;

public class LinkedList {
	
	public class Node<E>{
		E elem;
		Node<E> next, previous;
	}

	public class SinglyLinkedList<E>{
		

			private Node<E> head = null;
			private Node<E> tail = null;
			private Node<E> temp = null;
			private int counter = 0;

			public SinglyLinkedList() {
			}

			public void print() {
				for (Node n = head; n != null; n = n.next) {
					System.out.print(" " + n.elem.toString());
				}
				System.out.println("");
			}

			public int size() {
				return counter;
			}

			public void add(E elem) {
				//if we don't have any elems in our LinkedList
				if (head == null) {
					head = new Node<E>();
					tail = head;
					head.elem = elem;

					head.next = tail;
				} else {
					tail.next = new Node(); //add a new node to the end of the list
					tail = tail.next; //set the tail pointer to that node
					tail.elem = elem; //set elem to be stored to the end node
				}
				counter++;
			}

			public E remove(int index) {
				assert (index >= 0 && index < size()); //force valid index
				temp = head; //start at the beginning of the list

				//iterate to the position before the index
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				Node<E> two = temp.next;

		//set temp.next to point to the Node next to the Node to be removed
				temp.next = two.next;
				E elem = two.elem; //store the element to return
				two = null; //remove the node
				return elem; //return the element at that position
			}
		}

}
