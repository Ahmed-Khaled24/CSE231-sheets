package Sheet6.Problem4;

public class BankAccountPb4 {
    private String accountNumber,
                   holderName;
    private double balance;
    private boolean isOpen;

    public BankAccountPb4(String accountNumber, String holderName, double balance) {
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

    public void close() throws checkedBankAccountException {
        if(this.isOpen && this.balance == 0)
            this.isOpen = false;
        else
            throw(new checkedBankAccountException("Account is already closed or balance is not empty."));
    }

    public void reopen() throws checkedBankAccountException {
        if(!this.isOpen){
            this.isOpen = true;
        }
        else
            throw (new checkedBankAccountException("Account is already open."));
    }

    public void deposit(double moneyToAdd) throws checkedBankAccountException {
        if(moneyToAdd > 0 && this.isOpen){
            this.balance += moneyToAdd;
        }
        else
            throw (new checkedBankAccountException("Account is closed or invalid deposit."));
    }

    public void withdraw(double moneyToWithdraw) throws checkedBankAccountException {
        if(this.isOpen && moneyToWithdraw <= this.balance){
            this.balance -= moneyToWithdraw;
        }
        else
            throw(new checkedBankAccountException("Account is closed or has no enough money."));
    }

    public void transferTo(BankAccountPb4 otherAccount, double amountOfMoney) throws checkedBankAccountException {
        if(this.isOpen && otherAccount.isOpen){
            if(this.balance >= amountOfMoney){
                this.balance -= amountOfMoney;
                otherAccount.setBalance(otherAccount.getBalance() + amountOfMoney);
            }
            else throw (new checkedBankAccountException("No enough balance to transfer."));
        }
        else throw (new checkedBankAccountException("One of the two accounts is closed."));
    }

    public static void printAll (BankAccountPb4[] accountsArray){
        for (BankAccountPb4 bankAccount : accountsArray)
            bankAccount.print();
    }

    public static int find(BankAccountPb4[] accountsArray, String accountNumberToFind){

        for (int i = 0 ; i < accountsArray.length; i++){
            BankAccountPb4 currentAccount = accountsArray[i];
            if(currentAccount.getAccountNumber().equals(accountNumberToFind))
                return i;
        }

        return -1;
    }


}
