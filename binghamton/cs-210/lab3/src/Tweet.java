import java.util.Arrays;
import java.util.HashMap;

public class Tweet {
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
