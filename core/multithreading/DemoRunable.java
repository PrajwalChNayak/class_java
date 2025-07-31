package myclass.multithreading;

public class DemoRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread :" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println(e);
            }
            System.out.println("Runnable  Thread is Done ");
        }
    }

    public static void main(String[] args) {

        Thread myThread = new Thread(new DemoRunable());

        myThread.start();

        System.out.println("Main Thread is Done ");
    }

}
