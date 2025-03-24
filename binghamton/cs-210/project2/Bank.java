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

    private static void soutln(String s) {
    	System.out.println(s);
    }
    
    private static void sout(String s) {
    	System.out.print(s);
    }

    private static Optional<Integer> promptIntInput(String prompt) {
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.nextInt());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static Optional<Character> promptCharInput(String prompt) {
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.next().charAt(0));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static Optional<Double> promptDoubleInput(String prompt) {
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.nextDouble());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        AtomicBoolean shouldContinue = new AtomicBoolean(true);
		while (shouldContinue.get()) {
			soutln("1. Create Account\n2. Deposit\n3. Withdraw\n4. Display All Accounts\n5. ApplyInterestRateToAccounts\n6. Exit");
            promptIntInput("Choose an option: ").ifPresentOrElse(
                (Integer choice) -> {
                    switch (choice)	{
                        case 1:
                            promptCharInput("Enter 'S' for Saving or 'C' for Checking: ")
                            .ifPresentOrElse(
                                (Character c) -> {
                                    if (c == 'S') {

                                    } else if (c == 'C') {
                                        Optional<Double> initial = promptDoubleInput("Enter initial balance: ");
                                        if (initial.isEmpty() || initial.get() < 0) {
                                            soutln("Invalid initial amount.");
                                            return;
                                        }
                                        Optional<Double> overdraft = promptDoubleInput("Enter overdraft limit: ");
                                        if (overdraft.isEmpty() || overdraft.get() < 0) {

                                        }
                                    } else {
                                        soutln("Invalid account type.");
                                    }
                                },
                                () -> {

                                }
                            );
                        break;

                        case 2:

                        break;

                        case 3:

                        break;

                        case 4:

                        break;

                        case 5:

                        break;

                        case 6:
                            shouldContinue.set(false);
                    }
                },
                () -> {
                    soutln("Invalid choice");
                }
            );
		}
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
