/* Java implementation of LRUCache */

import java.util.HashMap;

/* Question:
 * * 
 * * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * * It should support the following operations: get and set.
 * * 
 * * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * * 
 * * set(key, value) - Set or insert the value if the key is not already present. 
 * * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * */

/*Solution:
 * * 
 * * The key to solve this problem is using a double linked list which enables us to quickly move nodes.
 * * The LRU cache is a hash table of keys and double linked nodes. The hash table makes the time of get() to be O(1). 
 * * The list of double linked nodes make the nodes adding/removal operations O(1).
 * * 
 * */

public class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    int capacity;
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    static Node head = null;
    static Node end = null;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        } 

        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        } else {
            Node new_node = new Node(key,value);

            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(new_node);
            } else {
                setHead(new_node);
            }
            
            map.put(key, new_node);
        }
    }

    public void remove(Node n) {
        if(n.prev != null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next != null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }
    }

    public void setHead(Node n) {
        n.next = head;
        n.prev = null;

        if(head !=null){
            head.prev = n;
        }

        head = n;

        if(end == null) {
            end = head;
        }
    }

    public static void display(){

        Node n = head;
        while(n != null){
            System.out.print(" ("+ n.key + ","+n.value+")");
            n = n.next;
        }
        System.out.println("");
    }


    public static void main(String[] args)

    {

        LRUCache lr = new LRUCache(5);

        lr.set(1, 1);
        lr.set(2, 2);
        lr.set(3, 3);
        lr.set(4, 4);
        lr.set(5, 5);

        lr.display();

        int val=lr.get(4);

        System.out.println("Element at key 4: "+val);

        lr.set(6, 6);

        lr.display();

        int val2=lr.get(2);

        System.out.println("Element at key 2: "+val2);

        lr.display();

    }
}
/*Output:
 * 5,5) (4,4) (3,3) (2,2) (1,1)
 * Element at key 4: 4
 *  (6,6) (4,4) (5,5) (3,3) (2,2)
 *  Element at key 2: 2
 *   (2,2) (6,6) (4,4) (5,5) (3,3)
 */
