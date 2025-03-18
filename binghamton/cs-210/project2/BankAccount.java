public abstract class BankAccount {
    protected String accountNumber;
    protected final String accountType;
    protected double balance;

    public BankAccount(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // returns current balance
    public double getBalance() {
        return balance;
    }

    // sets new balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // sets account number
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = String.format("AC%d", accountNumber);
    }

    // adds money to account
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // removes money from account
    public boolean withdraw(double amount) {
        double newBalance = balance - amount;
        if (newBalance >= 0) {
            balance = newBalance;
            return true;
        }
        return false;
    }

    // gets account type
    public String getAccountType() {
        return accountType;
    }

    // gets account number
    public String getAccountNumber() {
        return accountNumber;
    }
}