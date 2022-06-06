package Multi_threading_Sheet.Problems4_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pb4 {

    private static final ExecutorService incrementManager = Executors.newFixedThreadPool(5);
    private static final intToInc[] instances = {new intToInc(), new intToInc(), new intToInc(), new intToInc(), new intToInc()};

    public static void  problem4Run(){
        System.out.println("Values before: ");
        printValues();
        incrementValues();
        System.out.println("Values after: ");
        printValues();
    }

    private static void incrementValues(){
        for(int i = 0 ; i < 5 ; i++){
            incrementManager.execute(new incrementTask(instances[i]));
        }
        incrementManager.shutdown();                // terminate all the threads after completing their task
        while(!incrementManager.isTerminated());    // wait until all threads are terminated.
    }

    private static void printValues(){
        for(intToInc a : instances){
            System.out.println(a.getInteger());
        }
    }

    public static class incrementTask implements Runnable{
        private final intToInc currentObject;
        public incrementTask(intToInc currentObject) {
            this.currentObject = currentObject;
        }
        @Override
        public void run() {
            for(int i = 0 ; i < 3000; i++){
                this.currentObject.increment();
            }
        }
    }
}
