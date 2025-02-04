import java.util.Scanner;

public class Main {
	public static void main(String[] _args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a score between 0 and 100");
		float grade = s.nextFloat();
		if (grade < 0 || grade > 100) {
			System.out.println("BAD GRADE: invalid input range.");
			return;
		}
		char letterGrade = 'F';
		if (grade >= 90) {
			letterGrade = 'A';	
		} else if (grade >= 80) {
			letterGrade = 'B';	
		} else if (grade >= 70) {
			letterGrade = 'C';	
		} else if (grade >= 60) {
			letterGrade = 'D';	
		}

		System.out.println("Grade: " + letterGrade);
	}
}
