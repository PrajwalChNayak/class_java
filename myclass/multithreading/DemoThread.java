package myclass.multithreading;

//# Thread Class 
//# Runnable Interface 

//# start() 
//# run ()
//# sleep (millis) 
//# join()
//# interrupt()

public class DemoThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread :" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        DemoThread myDemoThread = new DemoThread();

        myDemoThread.start();// # call run() in background

        System.out.println("Main Thread is Done ");
    }

}
