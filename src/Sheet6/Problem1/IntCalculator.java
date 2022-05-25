package Sheet6.Problem1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static int num1, num2;

    public static void takeInput_printResult(){

        // Take input
        while(true){
            try{
             num1 = scanner.nextInt();
             num2 = scanner.nextInt();
             scanner.nextLine();
             break;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input please try again.");
                scanner.nextLine();
            }
        }

        // Print result
        System.out.println(
                "\nSum: " + (num1 + num1) +
                "\nDifference: " + (num1 - num2) +
                "\nProduct: " + (num1 * num2) +
                "\nQuotient: " + divide() +
                "\nRemainder: " + remainder()
        );
    }
    private static int divide(){
        try{
            return num1 / num2;
        } catch (ArithmeticException e){
            System.out.println("Divide by zero error");
            return Integer.MIN_VALUE;
        }
    }
    private  static int remainder(){
        try{
            return num1 % num2;
        }
        catch (ArithmeticException e){
            System.out.println("Remainder by zero error");
            return 0;
        }
    }
}
