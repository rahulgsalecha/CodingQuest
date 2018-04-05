import java.util.HashMap;

class Node {
    Node next;
    Node prev;
    int key, val;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = prev = null;
    }
}

public class LRUCacheRevision {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    static Node head = null;
    static Node tail = null;

    public LRUCacheRevision(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        } 

        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            remove(n);
            setHead(n);
        } else {
            Node new_node = new Node(key,value);
            if(map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
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
            tail = n.prev;
        }
    }

    public void setHead(Node n) {
        n.next = head;
        n.prev = null;

        if(head != null) {
            head.prev = n;
        } 

        head = n;

        if (tail == null) {
            tail = head;
        }
    } 

    public static void display(){
        Node n = head;
        while(n != null){
            System.out.print(" ("+ n.key + ","+n.val+")");
            n = n.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LRUCacheRevision cache = new LRUCacheRevision(2);

        cache.set(1,1);
        cache.set(2,2);
        cache.display();
        
        cache.get(1);
        cache.display();

        cache.set(3,3);
        cache.get(2);
        cache.display();

        cache.set(4,4);
        cache.get(1);
        cache.get(3);
        cache.display();
        cache.get(4);
        cache.display();
    }

}
