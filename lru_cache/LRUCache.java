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
            private final int value;
            private Node before;
            private Node after;

            private Node (int val, Node be, Node af) {
                value = val;
                before = be;
                after = af;
            }
        }

        private Node head = null, tail = null;
        private int size = 0;

        private Node offer(int value) {
            // Add to the tail
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

        private void delHead() {
            head = head.after;
        }

        private void addCount(Node node) {
            // move to the tail
            tail.after = node;
            tail = node;
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
        LRUCache.LinkedList.Node node1 = sol.list.offer(1);
        LRUCache.LinkedList.Node node2 = sol.list.offer(2);
        LRUCache.LinkedList.Node node3 = sol.list.offer(3);
        LRUCache.LinkedList.Node node4 = sol.list.offer(4);
        LRUCache.LinkedList.Node node5 = sol.list.offer(5);
        sol.list.addCount(node3);
    }
}
