package Sheet6.Problem3;

public class BankAccountPb3 {
    private String accountNumber,
                   holderName;
    private double balance;
    private boolean isOpen;

    public BankAccountPb3(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.isOpen = true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void print(){
        System.out.println(
                "\nAccount number: " + this.accountNumber +
                "\nHolder name: " + this.holderName +
                "\nBalance: " + String.format( "%.2f", this.balance) +
                "\nAccount status: " + (this.isOpen ? "open" : "closed")
        );
    }

    public void close(){
        if(this.isOpen && this.balance == 0)
            this.isOpen = false;
        else
            throw(new uncheckedBankAccountException("Account is already closed or balance is not empty."));
    }

    public void reopen(){
        if(!this.isOpen){
            this.isOpen = true;
        }
        else
            throw (new uncheckedBankAccountException("Account is already open."));
    }

    public void deposit(double moneyToAdd){
        if(moneyToAdd > 0 && this.isOpen){
            this.balance += moneyToAdd;
        }
        else
            throw (new uncheckedBankAccountException("Account is closed or invalid deposit."));
    }

    public void withdraw(double moneyToWithdraw){
        if(this.isOpen && moneyToWithdraw <= this.balance){
            this.balance -= moneyToWithdraw;
        }
        else
            throw(new uncheckedBankAccountException("Account is closed or has no enough money."));
    }

    public void transferTo(BankAccountPb3 otherAccount, double amountOfMoney){
        if(this.isOpen && otherAccount.isOpen){
            if(this.balance >= amountOfMoney){
                this.balance -= amountOfMoney;
                otherAccount.setBalance(otherAccount.getBalance() + amountOfMoney);
            }
            else throw (new uncheckedBankAccountException("No enough balance to transfer."));
        }
        else throw (new uncheckedBankAccountException("One of the two accounts is closed."));
    }

    public static void printAll (BankAccountPb3[] accountsArray){
        for (BankAccountPb3 bankAccount : accountsArray)
            bankAccount.print();
    }

    public static int find(BankAccountPb3[] accountsArray, String accountNumberToFind){

        for (int i = 0 ; i < accountsArray.length; i++){
            BankAccountPb3 currentAccount = accountsArray[i];
            if(currentAccount.getAccountNumber().equals(accountNumberToFind))
                return i;
        }

        return -1;
    }


}
