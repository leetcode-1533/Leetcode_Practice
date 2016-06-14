package lru_cache;

/**
 * Created by y1275963 on 6/13/16.
 */
import java.util.HashMap;


public class LRUCache {
    private int size;
    private LinkedList list = new LinkedList();

    private class LinkedList {
        public class Node {
            /*
            head   <- before Node after ->  tail
             */
            private int value;
            private int count;
            private Node before;
            private Node after;

            private Node (int val, Node be, Node af) {
                value = val;
                before = be;
                after = af;
            }
        }

        private Node head = null, tail = null;

        private Node offer(int value) {
            if (head == null && tail == null) {
                head = new Node(value, null, null);
                tail = head;
            } else {
                Node newnode = new Node(value, tail, null);
                tail.after = newnode;
                tail = newnode;
            }
            return tail;
        }
    }

    public int get(int key) {
        return 0;
    }

    public void set(int key, int value) {
//        return 0;
    }

    public static void main(String[] args) {
        LRUCache sol = new LRUCache();
        sol.list.offer(5);
        sol.list.offer(3);
        sol.list.offer(5);
        sol.list.offer(3);
    }
}
