// savings account with interest
public class SavingAccount extends BankAccount {
    private static final double interestRate = 0.025; // defined interest rate in the project pdf

    public SavingAccount(String accountNumber, String accountType, double balance) {
        super(accountNumber, accountType, balance);
    }

    // applies interest to account
    public void applyInterest() {
        balance += calculateInterest();
    }

    // calculates the interest amount gained
    public double calculateInterest() { return balance * interestRate; }
}
