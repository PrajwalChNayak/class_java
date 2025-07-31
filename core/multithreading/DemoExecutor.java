package myclass.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DemoExecutor {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // Poll for 2 thread

        executorService.submit(() -> {
            System.out.println("Task 1 is Running ");
        });

        executorService.submit(() -> {
            System.out.println("Task 2 Running ");
        });

        executorService.shutdown(); // Stop accepting new Task

        executorService.awaitTermination(65, TimeUnit.SECONDS);

        System.out.println("All tasks Are Done ");
    }
}
