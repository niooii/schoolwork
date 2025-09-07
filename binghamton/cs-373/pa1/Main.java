import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Function;

public class Main {

    static String tapeToStr(ArrayList<String> tape, int head) {
        String s = String.join("", tape).replace("_", " ").trim();
        // find first blank space
        int idx = s.indexOf(' ');
        if (idx == -1) {
            return s.substring(head);
        } else {
            return s.substring(head, idx);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = args[0];
        String in = args[1];
        int max = Integer.parseInt(args[2]);

        HashMap<Integer, String> stateTypes = new HashMap<>();
        HashMap<Integer, HashMap<String, Transition>> transitions = new HashMap<>();
        Integer start = 0;
        
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNextLine()) {
            String ln = sc.nextLine();
            if (ln.startsWith("state")) {
                String[] stuff = ln.trim().split("\\s+");
                Integer state = Integer.parseInt(stuff[1]);
                String type = "";
                if (stuff.length == 3) 
                    type = stuff[2];
                
                stateTypes.put(state, type);

                transitions.put(state, new HashMap<>());

                if (type.equals("start"))
                    start = state;
            } else {
                // transition path
                String[] stuff = ln.trim().split("\\s+");
                Integer from = Integer.parseInt(stuff[1]);
                String input = stuff[2];
                
                Transition t = new Transition();
                t.target = Integer.parseInt(stuff[3]);
                t.toWrite = stuff[4];
                // either L S R
                int a = 0;
                switch (stuff[5]) {
                    case "L":
                        a = -1;
                        break;
                    case "R":
                        a = 1;
                        break;
                }
                t.action = a;

                transitions.get(from).put(input, t);
            } 
        }

        int head = 0, i = 0, currState = start;

        ArrayList<String> tape = new ArrayList<>();
        for (String s : in.split("")) {
            tape.add(s);
        }

        for (i = 0; i < max; i++) {
            String tapeInput = tape.get(head);

            if (!transitions.containsKey(currState) || !transitions.get(currState).containsKey(tapeInput)) {
                System.out.println(tapeToStr(tape, head) + " reject");
                return;
            }

            // if no transition defined, its a reject
            if (!(transitions.containsKey(currState) && transitions.get(currState).contains(tapeInput)) {
                System.out.println(tapeToStr(tape, head) + " reject");
                return;
            }

            Transition t = transitions.get(currState).get(tapeInput);

            tape.set(head, t.toWrite);
            
            // switch to next state
            currState = t.target;
            head += t.action;

            while (head >= tape.size()) {
                tape.add("_");
            }

            if (head < 0) {
                System.out.println(tapeToStr(tape, head) + " crash");
                return;
            }

            String type = stateTypes.get(currState);
            switch (type) {
            case "accept":
                System.out.println(tapeToStr(tape, head) + " accept");
                return;
            case "reject":
                System.out.println(tapeToStr(tape, head) + " reject");
                return;
            }
        }
        System.out.println(tapeToStr(tape, head) + " quit");
    }
}
