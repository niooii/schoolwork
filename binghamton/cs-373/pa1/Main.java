import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
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
                String[] stuff = ln.split(" ");
                Integer state = Integer.parseInt(stuff[1]);
                String type = "";
                if (stuff.length == 3) 
                    type = stuff[2];
                
                stateTypes.put(state, type);

                transitions.put(state, new HashMap<>());

                if (type == "start")
                    start = state;
            } else {
                // transition path
                String[] stuff = ln.split(" ");
                String from = stuff[1];
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

        String[] tape = in.split("");

        for (i = 0; i < max; i++) {
            String tapeInput = tape[head];

            if (!transitions.containsKey(currState) || !transitions.get(currState).containsKey(tapeInput)) {
                System.out.println(String.join("", tape) + " reject");
                return;
            }

            Transition t = transitions.get(currState).get(tapeInput);

            tape[head] = t.toWrite;
            
            // switch to next state
            currState = t.target;
            head += t.action;

            String type = stateTypes.get(currState);
            switch (type) {
            case "accept":
                System.out.println(String.join("", tape) + " accept");
                return;
            case "reject":
                System.out.println(String.join("", tape) + " reject");
                return;
            }
            if (head < 0) {
                System.out.println(String.join("", tape) + " crash");
                return;
            }
        }
        System.out.println(String.join("", tape) + " quit");
    }
}
