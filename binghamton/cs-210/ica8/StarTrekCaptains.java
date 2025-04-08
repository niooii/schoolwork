public class StarTrekCaptains {

    private static String[][] capt = {
            //id, lastName, firstName, ship
            {"1", "Janeway", "Kathryn", "Voyager"},
            {"2", "Sisko", "Benjamin", "Defiant"},
            {"3", "Picard", "Jean-Luc", "Enterprise-D"},
            {"4", "Kirk", "James", "Enterprise-A"},
            {"5", "Archer", "Jonathan", "Enterprise NX-01"},
            {"71", "Pike", "Christopher", "Enterprise NCC-1701"},
            {"72", "Georgiou", "Philippa", "USS Shenzhou"},
            {"99", "Lorca", "Gabriel", "Discovery"},
    };

    //Return the ship captained by the captain with lastName
    //  This assumes last names are unique in the capt table
    public static String getShip(String lastName) {
        String result = "";
        for (String[] entry : capt) {
        	if (entry[1] == lastName)
        		result = entry[3];
        }
        return result;
    }

    //Return a String[][] with the first and last names of all captains
    public static String[][] getCaptains(){
        String[][] result = new String[capt.length][2];
        for (int i = 0; i < capt.length; i++) {
        	result[i][0] = capt[i][1];
        	result[i][1] = capt[i][2];
        }
        return result;
    }

    //If the id is in table, then return its row; else, return an empty array
    public static String[] getRowData(String id) {
        id = id.trim();
        String[] result = new String[0];
        for (String[] entry : capt) {
        	if (entry[0] == id) 
        		return entry;
        }
        return result;
    }

    private static void printArray(String[] s) {
        if(s == null) {
            System.out.println("null");
        }
        else {
            for(int i = 0; i < s.length; i++) {
                System.out.print(s[i] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(String[][] s) {
        if(s == null) {
            System.out.println("null");
        }
        else {
            for(int i = 0; i < s.length; i++) {
                for(int j = 0; j < s[i].length; j++) {
                    System.out.print(s[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing getShip method");
        System.out.println("Captain Sisko is the captain of " + getShip("Sisko"));
        System.out.println("Captain Pike is the captain of " + getShip("Pike"));
        System.out.println("Captain Janeway is the captain of " + getShip("Janeway"));
        System.out.println("Captain Georgiou is the captain of " + getShip("Georgiou"));
        System.out.println();

        System.out.println("Testing getCaptains method");
        System.out.println("The captains in capt table are:  ");
        printArray(getCaptains());
        System.out.println();

        System.out.println("Testing getRowData function");
        System.out.println("The row with id = 72");
        printArray(getRowData("" + 72));
        System.out.println("The row with id = 3");
        printArray(getRowData("" + 3));
        System.out.println("The row with id = 117");
        printArray(getRowData("" + 117));
        System.out.println("The row with id = 2");
        printArray(getRowData("" + 2));
        System.out.println();

    }

}
