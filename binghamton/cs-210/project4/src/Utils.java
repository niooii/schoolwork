import java.util.Optional;
import java.util.Scanner;

public class Utils {
    /// Prompt a user for an integer input.
    /// Returns None if invalid input.
    public static Optional<Integer> promptIntInput(String prompt) {
        System.out.print(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.nextInt());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /// Prompt a user for a single character input.
    /// Returns None if invalid input, otherwise returns the first character found.
    public static Optional<Character> promptCharInput(String prompt) {
        System.out.print(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            return Optional.of(scanner.next().charAt(0));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /// Prompt a user for a string input that satisfies a particular regex.
    /// Returns None if invalid input, or the regex is not satisfied.
    public static Optional<String> promptStrInput(String prompt, String regex) {
        System.out.print(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();

            return input.matches(regex) ? Optional.of(input) : Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /// Prompt a user for a double input that satisfies a particular constraint.
    /// Returns None if invalid input, or the constraint is not satisfied.
    public static Optional<Double> promptDoubleInput(String prompt, double min, double max) {
        System.out.print(prompt);
        try {
            Scanner scanner = new Scanner(System.in);
            double val = scanner.nextDouble();

            return (val <= min || val >= max) ? Optional.empty() : Optional.of(val);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
