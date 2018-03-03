/* Java program to implement queue datastructure*/

class Queue {
    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    boolean isFull(Queue q){
        return (q.size == q.capacity);
    }

    boolean isEmpty(Queue q){
        return (q.size == 0);
    }

    void enqueue(int item){
        if(isFull(this))
            return;

        this.rear = (this.rear+1)%this.capacity;
        this.array[this.rear] = item;
        this.size = this.size+1;
        System.out.println(item+ " enqueued to queue");
    }

    int dequeue(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;

        int item = this.array[this.front];
        this.front = (this.front+1)%this.capacity;
        this.size = this.size - 1;
        return item;
    }

    int front(){
        if(isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.front];
    }

    int rear(){
        if(isEmpty(this))  
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }

     public static void main(String[] args) 
     {
         Queue queue = new Queue(1000);

         queue.enqueue(10);
         queue.enqueue(20);
         queue.enqueue(30);
         queue.enqueue(40);
                                                                
         System.out.println(queue.dequeue() + " dequeued from queue\n");
         System.out.println("Front item is " +  queue.front());
         System.out.println("Rear item is " + queue.rear());

     }
}
/* Output:
 * 10 enqueued to queue
 * 20 enqueued to queue
 * 30 enqueued to queue
 * 40 enqueued to queue
 * 10 dequeued from queue
 *
 * Front item is 20
 * Rear item is 40
 */
