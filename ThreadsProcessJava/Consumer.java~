import java.util.*;

public class Consumer implements Runnable {
    private static final int DELAY = 1000;
    private ThreadSafeLinkedQueue<String> queue;
    private int count;

    public Consumer(ThreadSafeLinkedQueue<String> queue, int count) {
        this.queue = queue;
        this.count = count;
    }
    public void run() {
        try{
            for(int i=0; i<count; ++i){
                String date = queue.dequeue();
                System.out.println("Consumer Date : " + date);
                Thread.sleep(DELAY);
            }
        } catch(InterruptedException e) {
            System.out.println("Consumer class: InterruptedException");
        }
    }
}
