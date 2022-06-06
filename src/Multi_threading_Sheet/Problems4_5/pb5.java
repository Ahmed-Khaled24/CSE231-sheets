package Multi_threading_Sheet.Problems4_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pb5 {
    private static final ExecutorService incrementManager = Executors.newFixedThreadPool(5);
    private static final intToInc instance = new intToInc();

    private static void incrementValue() {
        for (int i = 0; i < 5; i++) {
            incrementManager.execute(new incrementTask());
        }
        incrementManager.shutdown();                  // terminate all the threads after completing their task
        while (!incrementManager.isTerminated()) ;    // wait until all threads are terminated.
    }

    public static void problem5Run() {
        System.out.println("Value before: " + instance.getInteger());
        incrementValue();
        System.out.println("Value after: " + instance.getInteger());

    }

    public static class incrementTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 3000; i++) {
                instance.increment();
            }
        }
    }
}
