import java.util.*;

public class Producer implements Runnable {
    private static final int DELAY = 1000;
    private ThreadSafeLinkedQueue<String> queue;
    private int count;

    public Producer(ThreadSafeLinkedQueue<String> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public void run() {
        try {
            for(int i=0;i<count;++i){
                String date = new Date().toString();
                System.out.println("Producer Date : " + date);
                queue.enqueue(date);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer Class : InterruptedException");
        }
    }
}
