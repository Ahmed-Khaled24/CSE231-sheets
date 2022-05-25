package Sheet6;

import Sheet6.Problem1.IntCalculator;
import Sheet6.Problem2.DoubleCalculator;
import Sheet6.Problem3.BankAccountPb3;
import Sheet6.Problem3.uncheckedBankAccountException;
import Sheet6.Problem4.BankAccountPb4;
import Sheet6.Problem4.checkedBankAccountException;

public class Main {
    public static void main(String[] args) {
        // testProblem1()
        // testProblem2();
        // testProblem3();
        testProblem4();

    }

    private static void testProblem1(){
        IntCalculator.takeInput_printResult();
    }
    private static void testProblem2(){
        DoubleCalculator.takeInput_printResult();
    }
    private static void testProblem3(){
        BankAccountPb3 account1 = new BankAccountPb3("account1", "customerName1", 5000);
        BankAccountPb3 account2 = new BankAccountPb3("account2", "customerName2", 2000);

        // Try all exceptions.
        // Try to close account with balance.
        try {
            account1.close();
        }catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to reopen opened account.
        try {
            account1.reopen();
        }catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to deposit negative.
        try{
            account1.deposit(-500);
        } catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to withdraw amount of money bigger than balance.
        try{
            account1.withdraw(6000);
        } catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to transfer to another account with no enough balance.
        try{
            account1.transferTo(account2, 6000);
        } catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }


        account1.print();
        account2.print();


        // Try to deposit positive.
        try{
            account1.deposit(1000);
        } catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to withdraw amount of money smaller than balance.
        try{
            account1.withdraw(2000);
        } catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to transfer to another account with  enough balance.
        try{
            account1.transferTo(account2, 2000);
        } catch (uncheckedBankAccountException e){
            System.out.println(e.getMessage());
        }


        account1.print();
        account2.print();


        // Try invalid operation without try-catch block
        account1.close(); // account1 balance is not zero, so an Exception will be thrown.
    }
    private static void testProblem4(){
        BankAccountPb4 account1 = new BankAccountPb4("account1", "customerName1", 5000);
        BankAccountPb4 account2 = new BankAccountPb4("account2", "customerName2", 2000);

        // Try all exceptions.
        // Try to close account with balance.
        try {
            account1.close();
        }catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to reopen opened account.
        try {
            account1.reopen();
        }catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to deposit negative.
        try{
            account1.deposit(-500);
        } catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to withdraw amount of money bigger than balance.
        try{
            account1.withdraw(6000);
        } catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to transfer to another account with no enough balance.
        try{
            account1.transferTo(account2, 6000);
        } catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }


        account1.print();
        account2.print();


        // Try to deposit positive.
        try{
            account1.deposit(1000);
        } catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to withdraw amount of money smaller than balance.
        try{
            account1.withdraw(2000);
        } catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }

        // Try to transfer to another account with  enough balance.
        try{
            account1.transferTo(account2, 2000);
        } catch (checkedBankAccountException e){
            System.out.println(e.getMessage());
        }


        account1.print();
        account2.print();


        // Cannot try invalid operation without try-catch block
        // account1.reopen(); ---> Error
    }
}
