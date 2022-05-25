package Sheet6.Problem2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DoubleCalculator {
        private static Scanner scanner = new Scanner(System.in);
        private static double num1, num2;

        public static void takeInput_printResult(){

            // Take input
            while(true){
                try{
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
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
                            "\nQuotient: " + (num1 / num2) +
                            "\nRemainder: " + (num1 % num2)
            );
        }
}
