import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Driver {
    private static void soutln(String s) {
        System.out.println(s);
    }

    private static void sout(String s) {
        System.out.print(s);
    }

   /*
    * Bunch of utility functions for receiving and validating user input
    */

    // Prompt a user for an integer input.
    // Returns None if invalid input.
    private static Optional<Integer> promptIntInput(String prompt) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.nextInt());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Prompt a user for a single character input.
    // Returns None if invalid input, otherwise returns the first character found.
    private static Optional<Character> promptCharInput(String prompt) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.next().charAt(0));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Prompt a user for a string input that satisfies a particular regex.
    // Returns None if invalid input, or the regex is not satisfied.
    private static Optional<String> promptStrInput(String prompt, String regex) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().trim();

            return input.matches(regex) ? Optional.of(input) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Prompt a user for a double input that satisfies a particular constraint.
    // Returns None if invalid input, or the constraint is not satisfied.
    private static Optional<Double> promptDoubleInput(String prompt, double min, double max) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            double val = scanner.nextDouble();

            return (val <= min || val >= max) ? Optional.empty() : Optional.of(val);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /*
     * Main bank CLI
     */

    public static void main(String[] args) {
        Bank bank = new Bank();
        // atomic bool to avoid capturing primitives in lambdas
        AtomicBoolean shouldContinue = new AtomicBoolean(true);
        while (shouldContinue.get()) {
            soutln("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Display All Accounts\n5. ApplyInterestRateToAccounts\n6. Exit");
            promptIntInput("Choose an option: ").ifPresentOrElse(
                (Integer choice) -> {
                    switch ((int)choice)	{
                        case 1:
                            if (bank.isFull()) {
                                soutln("Cannot create more accounts.");
                                return;
                            }
                            promptCharInput("Enter 'S' for Saving or 'C' for Checking: ")
                                .ifPresentOrElse(
                                    (Character _c) -> {
                                        char c = Character.toUpperCase(_c);
                                        if (c == 'S') {
                                            promptDoubleInput(
                                                "Enter initial balance: ",
                                                0,
                                                Double.MAX_VALUE
                                            ).ifPresentOrElse(
                                                (Double initial) -> soutln("Account created with account number: " + bank.createSavingsAccount(initial)),
                                                () -> soutln("Invalid initial amount.")
                                            );
                                        } else if (c == 'C') {
                                            Optional<Double> initial = promptDoubleInput(
                                                "Enter initial balance: ",
                                                0,
                                                Double.MAX_VALUE
                                            );
                                            if (initial.isEmpty()) {
                                                soutln("Invalid initial amount.");
                                                return;
                                            }
                                            Optional<Double> overdraft = promptDoubleInput(
                                                "Enter overdraft limit: ",
                                                0,
                                                Double.MAX_VALUE
                                            );
                                            if (overdraft.isEmpty()) {
                                                soutln("Invalid overdraft amount.");
                                                return;
                                            }
                                            String accNumber = bank.createCheckingsAccount(initial.get(), overdraft.get());
                                            soutln("Account created with account number: " + accNumber);
                                        } else {
                                            soutln("Invalid account type.");
                                        }
                                    },
                                    () -> soutln("Invalid input.")
                                );
                            break;

                        case 2:
                        case 3:
                            promptStrInput("Enter account number: ", "[aA][cC]\\d+").ifPresentOrElse(
                                (String _ac) -> {
                                    String ac = _ac.toUpperCase();
                                    if (!bank.accountExists(ac)) {
                                        soutln("Account does not exist.");
                                        return;
                                    }
                                    if (choice == 2) {
                                        promptDoubleInput("Enter deposit amount: ", 0, Double.MAX_VALUE).ifPresentOrElse(
                                            (Double amount) -> {
                                                BankAccount modified = bank.deposit(ac, amount);
                                                if (modified != null)
                                                    soutln("Successful deposit, New Balance: " + modified.getBalance());
                                                else
                                                    soutln("Deposit failed.");
                                            },
                                            () -> soutln("Invalid deposit amount.")
                                        );
                                    } else {
                                        promptDoubleInput("Enter withdraw amount: ", 0, Double.MAX_VALUE).ifPresentOrElse(
                                            (Double amount) -> {
                                                BankAccount modified = bank.withdraw(ac, amount);
                                                if (modified != null)
                                                    soutln("Successful withdrawal, New Balance: " + modified.getBalance());
                                                else
                                                    soutln("Withdrawal failed.");
                                            },
                                            () -> soutln("Invalid withdrawal amount.")
                                        );
                                    }
                                },
                                () -> soutln("Invalid account number.")
                            );
                            break;

                        case 4:
                            bank.displayAllAccounts();
                            break;

                        case 5:
                            int modified = bank.applyInterestToAll();
                            soutln("Applied interest to " + modified + " account(s).");
                            break;

                        case 6:
                            shouldContinue.set(false);
                            break;

                        default:
                            soutln("Invalid option.");
                    }
                },
                () -> soutln("Invalid choice")
            );
        }
    }
}
