import java.util.Scanner;

class AvgOfInputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input1: ");
        float i1 = scanner.nextFloat();
        System.out.print("Enter input2: ");
        float i2 = scanner.nextFloat();
        System.out.print("Enter input3: ");
        float i3 = scanner.nextFloat();

        System.out.println("Average of the three: " + (i1 + i2 + i3)/3);
    }
}