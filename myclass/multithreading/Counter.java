package myclass.multithreading;

public class Counter {
    private int count = 0;

    // # unsync
    public void increment() {
        count++;
    }

    // # sync
    public synchronized void safeIncrement() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

         Counter counter = new Counter(); // New 

        // Thread t1 = new Thread(() -> {
        // for (int i = 0; i < 1000; i++)
        // counter.increment();
        // });
        // Thread t2 = new Thread(() -> {
        // for (int i = 0; i < 1000; i++)
        // counter.increment();
        // });

        // t1.start();
        // t2.start();
        // t1.join();
        // t2.join();

        // System.out.println("Unsafely Increment" + counter.getCount());

       

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter.safeIncrement();
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter.safeIncrement();
        });

        t3.start(); //Runnable and running 
        t4.start();
        t3.join();//Main Thread waits for t3 to finish 
        t4.join();

        System.out.println("Safely Increment" + counter.getCount());//Terminated 
    }

}
