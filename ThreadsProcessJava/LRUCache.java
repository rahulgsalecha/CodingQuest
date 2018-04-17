import java.util.*;

public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    int capacity;
    static HashMap<Integer,Node> map = new HashMap<Integer,Node>();
    static Node head = null;
    static Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public static int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public static void remove(Node n) {
        if(n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    public static void setHead(Node n) {
        n.next = head;
        n.pre = null;

        if(head != null) {
            head.pre = n;
        }

        head = n;

        if(end == null) {
            end = head;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old_node = map.get(key);
            old_node.value  = value;
            remove(old_node);
            setHead(old_node);
        } else {
            Node new_node = new Node(key,value);
            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(new_node);
            } else {
                setHead(new_node);
            }
            map.put(key,new_node);
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
