import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IllegalArgumentException;

public class GuessTheNumber {	
	static int getUserGuess() throws InputMismatchException, IllegalArgumentException {
		Scanner scanner = new Scanner(System.in);
		int guess = scanner.nextInt();
		if (guess < 1 || guess > 9) {
			throw new IllegalArgumentException();
		}

		return guess;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to 'Guess the Number'!");

		Random rand = new Random(System.currentTimeMillis());
		int ans = rand.nextInt(9) + 1;
		
		System.out.println("I'm thinking of a number between 1 and 10.");

		int guess;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter your guess: ");
			try {
				guess = getUserGuess();
				if (guess == ans)
					break;

				System.out.println("Try again!");		
			} catch (InputMismatchException e) {
				System.out.println("Error: That's not a valid number. Please enter an integer.");
			} catch (IllegalArgumentException e) {
				System.out.println("Error: Please guess a number between 1 and 10.");
			}
		}

		System.out.println("Congradulations! You guessed the right number!");
	}
}
