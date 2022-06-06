package Multi_threading_Sheet.Problems1_2_3;

public class pb1 {
    private static final int[][] problem1Array = new int [10][1000];

    private static void fillTheArray(){
        for(int row = 0 ; row < problem1Array.length; row++){
            for(int column = 0; column < problem1Array[0].length; column++){
                int operand1 = row+1;
                int operand2 = column+1;
                problem1Array[row][column] = operand1 * operand2;
            }
        }
    }
    private static void printTheArray(){
        for(int row = 0 ; row < problem1Array.length; row++){
            for(int column = 0; column < problem1Array[0].length; column++){
                System.out.print(problem1Array[row][column] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void problem1Run(){
        fillTheArray();
        printTheArray();
    }

}
