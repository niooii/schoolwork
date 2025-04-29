import java.util.function.BiFunction;

public class PostfixEvaluator {
    StackADT valStack;
    public PostfixEvaluator(StackADT valueStack) {
        this.valStack = valueStack;
    }

    String applyOperator(String _op1, String _op2, String op) {
        int op1 = Integer.parseInt(_op1);
        int op2 = Integer.parseInt(_op2);
        int res = switch (op) {
            case "+" -> op1 + op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            case "-" -> op1 - op2;
            // should be unreachable
            default -> -1;
        };

        return "" + res;
    }

    boolean isOperator(String op) {
        return switch (op) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }

    int evaluate(String expr) {
        String[] tokens = expr.split(" ");
        for (String tok : tokens) {
            if (!isOperator(tok)) {
                valStack.push(tok);
            } else {
                String op2 = valStack.pop();
                String op1 = valStack.pop();
                valStack.push(applyOperator(op1, op2, tok));
            }
        }

        return Integer.parseInt(valStack.pop());
    }
}
