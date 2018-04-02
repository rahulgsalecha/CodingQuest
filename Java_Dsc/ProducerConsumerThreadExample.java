import java.util.LinkedList;

class ProducerConsumerThreadExample {

    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer pc = new ProducerConsumer();

        // Create a Producer Thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create a consumer Thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //Start both threads
        t1.start();
        t2.start();

        //t1 finishes before t2
        t1.join();
        t2.join();
    }

    public static class ProducerConsumer{
        LinkedList<Integer> list = new LinkedList<Integer>();
        int capacity = 2;

        public void produce() throws InterruptedException {
            int value = 0;
            while(true) {
                synchronized(this) {
                    // producer thread waits while list is full
                    while(list.size() == capacity) {
                        wait();
                    }

                    System.out.println("Producer produced-" + value);
                    
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        
        public void consume() throws InterruptedException {
            while(true) {
                synchronized(this) {
                    // consumer thread waits while list is empty
                    while(list.size() == 0) {
                        wait();
                    }
                    int value = list.removeFirst();
                    System.out.println("Consumer consumed-" + value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}
/* Output
 * Producer produced-0
 * Producer produced-1
 * Consumer consumed-0
 * Consumer consumed-1
 * Producer produced-2
 * Producer produced-3
 * Consumer consumed-2
 * Consumer consumed-3
 * Producer produced-4
 * Producer produced-5
 * Consumer consumed-4
 * Consumer consumed-5
 * Producer produced-6
 * Producer produced-7
 * Consumer consumed-6
 * Consumer consumed-7
 * Producer produced-8
 * Producer produced-9
 * Consumer consumed-8
 * Consumer consumed-9
 * Producer produced-10
 * Producer produced-11
 * Consumer consumed-10
 * Consumer consumed-11
 * Producer produced-12
 * Producer produced-13
 * ...
 * ...
 * ..
 */
