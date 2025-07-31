package core.threadSafe;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorFature {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // * Step 1

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // *Step 2 */

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "Result From Thread";
        };

        // * Step 3 */
        Future<String> future = executorService.submit(task);

        System.out.println("Task Is Submitted ");

        // *Step 4 */

        String result = future.get();

        System.out.println("The Answer is " + result);

        // *Step 5 */

        executorService.shutdown();

    }

}
