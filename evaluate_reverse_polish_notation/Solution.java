package evaluate_reverse_polish_notation;

import java.util.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> container = new Stack<String>();
        for(String item : tokens) {
            container.push(item);
        }
        StdOut.println(container.size() + 1);

        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] intest = new String[]{"2", "1", "+", "3", "*"};
        sol.evalRPN(intest);

    }
}
