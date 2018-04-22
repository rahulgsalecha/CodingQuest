class ThreadSafeQueue {
    int size = 0;
    int MAX_QUEUE_SIZE = 10;
    Node first;
    Node last;

    class Node {
        int x;
        Node next;

        Node(int x) {
            this.x = x;
            this.next = null;
        }
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized boolean isFull() {
        return size == MAX_QUEUE_SIZE;
    }

    public synchronized void enqueue(int val) {
        while(size == MAX_QUEUE_SIZE) {
            wait();
        }

        Node old_last = last;
        Node last = new Node(val);

        if(size == 0) {
            first = last;
        } else {
            old_last.next = last;
        }
        size++;
        notifyAll();
    }

    public synchronized int dequeue() {
        while(size == 0) {
            wait();
        }

        int item = first.x;
        first = first.next;

        size--;
        if(size == 0) {
            last = null;
        }

        notifyAll();
        return item;
    }

    public synchronized int size() {
        return size;
    }

}
