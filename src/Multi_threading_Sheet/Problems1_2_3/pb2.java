package Multi_threading_Sheet.Problems1_2_3;

public class pb2 {
    private static final int[][] problem2Array = new int [10][1000];

    private static void fillTheArray(){
        for(int rowIndex = 0 ; rowIndex < problem2Array.length ; rowIndex++){
            Thread filler = new FillerThread(rowIndex);
            filler.start();
        }
    }
    private static void printTheArray(){
        for(int row = 0 ; row < problem2Array.length; row++){
            for(int column = 0; column < problem2Array[0].length; column++){
                System.out.print(problem2Array[row][column] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void problem2Run(){
        fillTheArray();
        printTheArray();
    }

    private static class FillerThread extends Thread{
        private final int rowIndex;
        private FillerThread(int rowIndex){
            this.rowIndex = rowIndex;
        }
        @Override
        public void run() {
            for(int columnIndex = 0 ; columnIndex < problem2Array[0].length; columnIndex++){
                problem2Array[this.rowIndex][columnIndex] = (this.rowIndex+1)*(columnIndex+1);
            }
        }
    }
}
