public class Bank {
    private static final int maxAccounts = 100;
    private final BankAccount[] accounts;
    private int nextAccountNum = 0;

    Bank() {
        accounts = new BankAccount[maxAccounts];
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
    }

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

    public boolean createSavingsAccount(double initial) {
        if (nextAccountNum > maxAccounts - 1)
            return false;

        accounts[nextAccountNum] = new SavingAccount(
            intToAccountNumString(nextAccountNum),
            "SavingAccount",
            initial
        );

        nextAccountNum++;
        return true;
    }

    public boolean createCheckingsAccount(double initial, double overdraft) {
        if (nextAccountNum > maxAccounts - 1)
            return false;

        accounts[nextAccountNum] = new CheckingAccount(
            intToAccountNumString(nextAccountNum),
            "CheckingAccount",
            initial,
            overdraft
        );

        nextAccountNum++;
        return true;
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
    public String displayAllAccounts() {
        return null;
    }

    // applies interest to all savings accounts
    public String applyInterestRateToAllSavings() {
        return null;
    }
}