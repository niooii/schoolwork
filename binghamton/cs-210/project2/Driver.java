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

    private static Optional<Integer> promptIntInput(String prompt) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.nextInt());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static Optional<Character> promptCharInput(String prompt) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.next().charAt(0));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static Optional<Double> promptDoubleInput(String prompt, double min, double max) {
        sout(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            double val = scanner.nextDouble();
            if (val < min || val > max) {
                return Optional.empty();
            }
            return Optional.of(val);
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
                                if (bank.isFull()) {
                                    soutln("Cannot create more accounts.");
                                    return;
                                }
                                promptCharInput("Enter 'S' for Saving or 'C' for Checking: ")
                                        .ifPresentOrElse(
                                                (Character c) -> {
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

                                break;

                            case 3:

                                break;

                            case 4:
                                bank.displayAllAccounts();
                                break;

                            case 5:

                                break;

                            case 6:
                                shouldContinue.set(false);
                        }
                    },
                    () -> soutln("Invalid choice")
            );
        }
    }
}
