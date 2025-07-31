package core.threadSafe;

import java.util.concurrent.Callable;

//# Collections.sychronizedList(new ArrayList()) 

//# Collections.sychronizedMap(new Map ())

//#ConcurrentHasMap
//#CopyOnWriteArrayList and CopyOnWriteArraySet
//#ConcurrentLinedQueue , CurrentSkipListMap

public class DemoThreadSafe {

    public static void main(String[] args) throws InterruptedException {

        // ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // // map.put("A", 1);
        // // map.put("B", 2);

        // list.add("Red");
        // list.add("Blue");
        // Thread t3 = new Thread(() -> {
        // for (int i = 0; i < 1000; i++)
        // list.add("Green");
        // });
        // Thread t4 = new Thread(() -> {
        // for (int i = 0; i < 1000; i++)
        // list.add("Yellow");
        // });

        // t3.start(); // Runnable and running
        // t4.start();
        // t3.join();// Main Thread waits for t3 to finish
        // for (String color : list) {
        // System.out.println(color);
        // }
        // t4.join();

        // System.out.println(map);

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;

        };

        //Future 
        


    }
}
