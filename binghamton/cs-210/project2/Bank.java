import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bank {
    private static final int maxAccounts = 100;
    private final BankAccount[] accounts;
    private int nextAccountNum = 0;

    Bank() {
        accounts = new BankAccount[maxAccounts];
    }

    // Utility methods
    private String intToAccountNumString(int num) {
        return String.format("AC%d", num + 1);
    }

    private int accountNumToIdx(String accountNum) {
        return Integer.parseInt(accountNum.substring(2)) - 1;
    }

    private BankAccount getBankAccountFromNum(String accountNum) {
        int idx = accountNumToIdx(accountNum);
        if (idx >= nextAccountNum) {
            return null;
        }
        return accounts[idx];
    }

    public boolean isFull() { return this.nextAccountNum > maxAccounts - 1; }

    // Returns the account number of the created account, otherwise null.
    public String createSavingsAccount(double initial) {
        if (this.isFull())
            return null;

        String accNumString = intToAccountNumString(nextAccountNum);
        accounts[nextAccountNum] = new SavingAccount(
                accNumString,
            "SavingAccount",
            initial
        );

        nextAccountNum++;
        return accNumString;
    }

    // Returns the account number of the created account, otherwise null.
    public String createCheckingsAccount(double initial, double overdraft) {
        if (this.isFull())
            return null;

        String accNumString = intToAccountNumString(nextAccountNum);
        accounts[nextAccountNum] = new CheckingAccount(
                accNumString,
            "CheckingAccount",
            initial,
            overdraft
        );

        nextAccountNum++;
        return accNumString;
    }

    // adds funds to account
    public boolean deposit(String accountNum, double amount) {
        BankAccount account = getBankAccountFromNum(accountNum);

        if (account == null) {
            System.out.println("Account not found.");
            return true;
        }

        return account.deposit(amount);
    }

    // removes funds from account
    public boolean withdraw(String accountNum, double amount) {
        BankAccount account = getBankAccountFromNum(accountNum);

        if (account == null) {
            System.out.println("Account not found.");
            return true;
        }

        return account.withdraw(amount);
    }

    // lists all accounts
    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            if (account == null)
                break;
            System.out.printf("Account number: %s, Type: %s, Balance: %.2f\n", account.getAccountNumber(), account.getAccountType(), account.getBalance());
        }
    }
}
