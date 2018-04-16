class QueueDataStructure {
    int front, rear, size;
    int capacity;
    int[] array;

    public QueueDataStructure(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    public boolean isFull(QueueDataStructure q) {
        return (q.size == q.capacity);
    }

    public boolean isEmpty(QueueDataStructure q) {
        return (q.size == 0);
    }

    public void enqueue(int x) {
        if(isFull(this)) return;

        this.rear = (this.rear+1)%this.capacity;
        this.array[this.rear] = x;
        this.size += 1;
        System.out.println("Item Enqueued : " + x);
    }

    public int dequeue() {
        if(isEmpty(this)) return Integer.MIN_VALUE;

        int x = this.array[this.front];
        this.front = (this.front+1)%this.capacity;
        this.size -= 1;
        System.out.println("Item Dequeued : " + x);
        return x;
    }

    public int front() {
        if(isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    public int rear() {
        if(isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

    public static void main(String[] args)
    {
        QueueDataStructure queue = new QueueDataStructure(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " +  queue.front());
        System.out.println("Rear item is " + queue.rear());

    }


}
