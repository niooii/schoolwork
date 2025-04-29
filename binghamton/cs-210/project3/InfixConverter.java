public class InfixConverter {
    StackADT opStack;
    public InfixConverter(StackADT operatorStack) {
        this.opStack = operatorStack;
    }

    int operatorPrecedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    public String toPostfix(String expr) {
        StringBuilder pfExpr = new StringBuilder();
        String[] tokens = expr.split(" ");
        for (String tok : tokens) {
            int currOpPrecedence = operatorPrecedence(tok);
            if (currOpPrecedence == -1) {
                // not an operator - check for paren
                if (tok.equals("(")) {
                    opStack.push(tok);
                } else if (tok.equals(")")) {
                    while (!opStack.peek().equals("(")) {
                        pfExpr.append(opStack.pop()).append(" ");
                    }
                    // pop the left paren
                    opStack.pop();
                } else {
                    // is operand
                    pfExpr.append(tok).append(" ");
                }
            } else {
                // is operator
                while (!opStack.isEmpty()) {
                    String op = opStack.peek();
                    int opPrecedence = operatorPrecedence(op);
                    // if it is -1, then it should be a left paren.
                    // right paren are never pushed
                    if (opPrecedence == -1) {
                        break;
                    }
                    if (opPrecedence < currOpPrecedence) {
                        break;
                    }
                    pfExpr.append(opStack.pop()).append(" ");
                }
                opStack.push(tok);
            }
        }
        while (!opStack.isEmpty()) {
            pfExpr.append(opStack.pop()).append(" ");
        }
        return pfExpr.toString().trim();
    }
}
