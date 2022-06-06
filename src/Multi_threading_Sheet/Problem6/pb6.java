package Multi_threading_Sheet.Problem6;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pb6 {
    private static final int [][] problem6Array = new int[10][1000000];
    private static final long [] sums = new long [10];
    private static void fillTheArray(){
        ExecutorService manager = Executors.newCachedThreadPool();
        for(int rowIndex =0; rowIndex < problem6Array.length; rowIndex++){
            manager.execute(new fillAndSumTask(rowIndex));
        }
        manager.shutdown();
        while(!manager.isTerminated());
    }
    private static void printSums(){
        System.out.println("Array size is: " + problem6Array.length + "x" + problem6Array[0].length
        + "\nThe next data is the sum of each row of the array.");
        for(long l : sums){
            System.out.print(l + " ");
        }
    }
    public static void problem6Run(){
        fillTheArray();
        printSums();
    }

    private static class fillAndSumTask implements Runnable{
        private final int rowIndex;
        public fillAndSumTask(int rowIndex) {
            this.rowIndex = rowIndex;
        }
        @Override
        public void run() {
            for(int columnIndex = 0 ; columnIndex < problem6Array[0].length; columnIndex++){
                int newRandomNumber = generateRandomInt();
                problem6Array[rowIndex][columnIndex] = newRandomNumber;
                sums[rowIndex] += newRandomNumber;
            }
        }

        private static int generateRandomInt(){
            Random generator = new Random();
            int upperBound = 10;
            return generator.nextInt(upperBound);
        }

    }
}
