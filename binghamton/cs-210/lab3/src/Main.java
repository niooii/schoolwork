import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String test = "#typ STRUCTURE; #det damaged and stuff; #loc washington; #lat 353.2424; #lng 90.3434;";
        Tweet ttest = new Tweet(test);
        System.out.println(ttest);

        System.out.println("test case done");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a tweet below");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            try {
                Tweet t = new Tweet(line);
                System.out.println(t);
            } catch (Exception e) {
                System.out.println("Error parsing tweet: " + e.getMessage());
            } finally {
                System.out.println("Enter a tweet below");
            }
        }
    }
}
