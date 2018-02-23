import java.util.HashMap;

/* Question:
	 * 
	 * Design and implement a data structure for Least Recently Used (LRU) cache. 
	 * It should support the following operations: get and set.
	 * 
	 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	 * 
	 * set(key, value) - Set or insert the value if the key is not already present. 
	 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
	 */

	/*Solution:
	 * 
	 * The key to solve this problem is using a double linked list which enables us to quickly move nodes.
	 * 
	 * 
	 * The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1). The list of double linked nodes make the nodes adding/removal operations O(1).


	 * 
	 */

public class LRUCache {
	
	//Define a Doubly linked list node
	
	class Node{
	    int key;
	    int value;
	    Node pre;
	    Node next;
	 
	    public Node(int key, int value){
	        this.key = key;
	        this.value = value;
	    }
	}
	
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>(); // LRU Cache 
    Node head=null;
    static Node end=null;
 
	//Get Function
    public int get(int key){
    	if(map.containsKey(key)){
    		//Get the node corresponding to that key
    		Node n = map.get(key);
    		//Remove the node 
    		remove(n);
    		//Insert the node to the start of the Doubly linkedList
    		setHead(n);
    		//Return the corresponding value
    		return n.value;
    	}
    	
    	// If value doesn't exists, return -1;
    	return -1;
    }
    
    //Remove the node
    public void remove(Node n){
    	//Re-adjust the pre and next pointers of the previous and next nodes of this node n
    	
    	// First adjust the node's next node
    	if(n.pre != null){
    		n.pre.next = n.next;	
    	} else {
    		head = n.next;
    	}
    	
    	// Next adjust the node's previous node
    	
    	if(n.next !=null){
    		n.next.pre = n.pre;
    	} else {
    		end = n.pre;
    	}
    	
    }
    
    //Insert the node to the start of the Doubly linkedList
    public void setHead(Node n){
    	
    	// Assign the head as n's next node and null as n's previous node
    	n.next = head;
    	n.pre = null;
    	
    	//If head is not null, assign n a head's previous node
    	if(head!=null){
    		head.pre = n;
    	}
    	// If head is null, assign n as head of the node.
    	head = n;
    	
    	// If end is also null, assign end to head
    	if(end ==null){
    		end = head;
    	}
    	
    }
    
    
    // Set Function
    public void set(int key, int value){
    	// If the key is already present in LRU cache
    	if(map.containsKey(key)){
    		//Extract the node
    		Node old = map.get(key);
    		//Set the value
    		old.value = value;
    		//Remove it from the linkedlist
    		remove(old);
    		//Set it as head of the linkedlist
    		setHead(old);
    	} else {
    		// If the key is not present in the LRU Cache
    		//Create a new node of that key and value
    		Node created = new Node(key,value);
    		//Check if the cache's size is exceeded
    		if(map.size()>=capacity){
    			// If cache's size is exceeded, remove end node from LRU cache map
    			if(end !=null){
    			map.remove(end.key);
    			//Also remove the end node from linkedlist
    			remove(end);
    			}
    			//Set newly created node as head
    			setHead(created);
    		} else {
    			// If cache's size is not exceeded, Set newly created node as head
    			setHead(created);
    		}
    		
    		// Insert the newly created node to the cache / map
    		map.put(key, created);
    	}	
    }
	
    public static void display(Node head){
    	while(head == end){
    		System.out.print(" ("+ head.key + ","+head.value+")");
    		head = head.next;
    	}
    }


}
