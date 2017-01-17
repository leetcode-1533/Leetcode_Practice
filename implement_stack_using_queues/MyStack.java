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
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (q1.size() != 1) {
            temp.add(q1.poll());
        }
        q1.poll();
        q1 = temp;
    }

    // Get the top element.
    public int top() {
        Queue<Integer> temp = new LinkedList<>();
        while (q1.size() != 1) {
            temp.add(q1.poll());
        }
        int re = q1.poll();
        temp.add(re);
        q1 = temp;
        return re;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
