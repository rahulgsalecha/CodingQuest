import java.util.Iterator;

public class ThreadSafeLinkedQueue<T> implements Iterable<T> {
    private Node first, last;
    private int size = 0;
    private static final int MAX_QUEUE_SIZE = 10;
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized boolean isFull() {
        return size == MAX_QUEUE_SIZE;
    }

    public synchronized void enqueue(final T item) throws InterruptedException {
        while(size == MAX_QUEUE_SIZE) {
            wait();
        }

        final Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(size == 0) {
            first = last;
        } else {
            oldLast.next = last;
        }

        size++;
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while(size == 0){
            wait();
        }

        final T item = first.item;
        first = first.next;

        size--;
        if(size == 0){
            last = null;
        }

        notifyAll();
        return item;
    }

    public synchronized int size() {
        return size;
    }

    private class QueueIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext(){
            return current  != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
        }
    }
}
