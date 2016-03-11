package min_stack;

import java.util.*;
public class Solution {
    
    private Stack<Integer> container = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    
    
    public void push(int x) {
        container.push(x);
        if(min.empty() || min.peek() > x) {
            min.push(x);
        }
    }

    public void pop() {
        int x = container.pop();
        if(x == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return container.peek();
    }

    public int getMin() {
        return min.peek();       
    }
}
