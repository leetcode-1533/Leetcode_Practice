package evaluate_reverse_polish_notation;

import java.util.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> container = new Stack<Integer>();
        for (String item : tokens) {
            if(isOperator(item)) {
                int op2 = container.pop();
                int op1 = container.pop();
                int re = operation(op1, op2, item);
                container.push(re);
            } else {
                container.push(Integer.parseInt(item));
            }
        }
        return container.pop();
    }

    private boolean isOperator(String operator) {
        return (operator.equals("*") || operator.equals("+") || operator.equals("-") || operator.equals("/"));
    }

    private int operation(int op1, int op2, String operator) {
        switch (operator) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": return op1 / op2;
        }
        return 0; // can't happen
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] intest = new String[]{"4", "13", "5", "/", "+"};
        StdOut.println(sol.evalRPN(intest));
    }
}
