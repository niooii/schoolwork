// checking account with overdraft
public class CheckingAccount extends BankAccount {
    private double overDraftLimit;

    public CheckingAccount(String accountNumber, String accountType, double balance, double overDraftLimit) {
        super(accountNumber, accountType, balance);
        this.overDraftLimit = overDraftLimit;
    }

    // withdraws with overdraft protection
    @Override
    public boolean withdraw(double amount) {
        double newBalance = balance - amount;
        if (newBalance <= -overDraftLimit) {
            balance = newBalance;
            return true;
        }
        return false;
    }
}