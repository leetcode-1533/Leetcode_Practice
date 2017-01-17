package implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by y1275963 on 1/17/17.
 * The simulation is o(n) penalty;
 */
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        temp.add(x);
        while (!q1.isEmpty())
            temp.add(q1.poll());
        q1 = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
