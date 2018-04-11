public class ThreadDemo {

    public static void main(String[] args){
        MyThread mt = new MyThread();
        mt.start();
        for(int i = 0; i< 30; i++){
            System.out.println("i="+i+". i*i="+i*i);
        }

        MyRunnableThread mt1 = new MyRunnableThread();
        Thread t1 = new Thread(mt1);
        t1.start();
    }
}

class MyThread extends Thread {

    public void run(){
        for(int count = 1, row = 1; row < 20; row++, count++) {
            for(int i =0; i<count; i++) {
                System.out.print('*');
            }

            System.out.print ('\n');
        }
    }
}

class MyRunnableThread  implements Runnable {

    public void run(){
        System.out.println("thread is running...");     
    }
}


