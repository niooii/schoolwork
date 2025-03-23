
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class ParseException extends RuntimeException {
    public ParseException(String message) {
        super(message);
    }
}

class Tweet {
    String type, details, location;
    float lat, lng;

    // Parses a new tweet from the format
    public Tweet(String raw) throws ParseException, NumberFormatException {
        // strip the quotes if it was entered with quotes (kinda unclear instructions)
        if (raw.startsWith("\"") && raw.endsWith("\"")) {
            raw = raw.substring(1, raw.length() - 1);
        }
        HashMap<String, String> tokenMap = new HashMap<>();

        Arrays.stream(raw.split(";"))
            .map(String::trim)
            .forEach((String s) -> {
                String k = s.substring(s.indexOf('#')+1, s.indexOf(' ')).trim();
                String v = s.substring(s.indexOf(' ')).trim();
                tokenMap.put(k, v);
            });

        this.type = tokenMap.get("typ");
        this.details = tokenMap.get("det");
        this.location = tokenMap.get("loc");
        if (type == null || details == null || location == null) {
            throw new ParseException("Could not find expected field.");
        }
        this.lat = Float.parseFloat(tokenMap.get("lat"));
        this.lng = Float.parseFloat(tokenMap.get("lng"));
    }

    @Override
    public String toString() {
        return String.format("Type:      %s \nDetails:   %s \nLocation:  %s \nLatitude:  %f \nLongitude: %f\n", type, details, location, lng, lat);
    }
}


public class ParseTheTweet {
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
