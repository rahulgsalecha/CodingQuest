public class QueueThreadRunner {
    public static void main(String[] args) {
        ThreadSafeLinkedQueue<String> queue = new ThreadSafeLinkedQueue<String>();
        final int THREADS = 10;
        final int REPITITIONS = 50;

        for(int i=0;i<=THREADS;++i){
            Producer pr = new Producer(queue,REPITITIONS);
            Consumer cr = new Consumer(queue,REPITITIONS);

            Thread dt = new Thread(pr);
            Thread wt = new Thread(cr);

            dt.start();
            wt.start();

            /*
            dt,join();
            wt.join();
            */
        }
    }
}
