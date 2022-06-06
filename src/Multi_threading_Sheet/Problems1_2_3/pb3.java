package Multi_threading_Sheet.Problems1_2_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pb3 {
    private static final int[][] problem3Array = new int[10][1000];
    private static final ExecutorService myThreadManager = Executors.newFixedThreadPool(10);

    private static void fillTheArray(){
        for(int rowIndex = 0 ; rowIndex < problem3Array.length; rowIndex++){
            myThreadManager.execute(new fillTask(rowIndex));
        }
        myThreadManager.shutdown();
    }

    private static void  printTheArray(){
        for(int row = 0 ; row < problem3Array.length; row++){
            for(int column = 0; column < problem3Array[0].length; column++){
                System.out.print(problem3Array[row][column] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void problem3Run(){
        fillTheArray();
        printTheArray();
    }

    private static class fillTask implements Runnable{
        private final int rowIndex;
        private fillTask(int rowIndex){
            this.rowIndex = rowIndex;
        }
        @Override
        public void run() {
            for(int columnIndex = 0 ; columnIndex < problem3Array[0].length; columnIndex++){
                problem3Array[rowIndex][columnIndex] = (rowIndex+1) * (columnIndex+1);
            }
        }
    }
}
