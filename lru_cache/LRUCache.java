package lru_cache;

/**
 * Created by y1275963 on 6/13/16.
 */
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int size;
    private LinkedList list = new LinkedList();
    private Map<Integer, LinkedList.Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int re = map.get(key).getValue();
            list.addCount(map.get(key));
            return re;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.size() == size) {
            int keytodel = list.poll().getKey();
            map.remove(keytodel);
        }
        LinkedList.Node newnode = list.offer(key, value);
        map.put(key, newnode);
    }

    private class LinkedList {
        public class Node {
            /*
            head   <- before Node after ->  tail
             */
            private final int key;
            private final int value;
            private Node before;
            private Node after;

            public Node (int init_key, int init_val, Node be, Node af) {
                value = init_val;
                key = init_key;
                before = be;
                after = af;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }
        }

        private Node head = null, tail = null;

        public Node offer(int key, int value) {
            // Add to the tail
            if (head == null && tail == null) {
                head = new Node(key, value, null, null);
                tail = head;
            } else {
                Node newnode = new Node(key, value, tail, null);
                tail.after = newnode;
                tail = newnode;
            }
            return tail;
        }

        public Node poll() {
            Node temp = head;
            head = head.after;
            return temp;
        }

        public void addCount(Node node) {
            // move to the tail
            if (node != tail) {
                if (node == head)
                    head = head.after;

                Node be = node.before;
                Node af = node.after;

                if (be != null) // in case node is the head
                    be.after = af;
                af.before = be;

                tail.after = node;
                node.before = tail;
                tail = node;
                tail.after = null;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache sol = new LRUCache(5);
        int[] keySet = new int[] {3, 4, 5, 6, 7};
        for (int item : keySet) {
            sol.set(item, item);
        }
        sol.get(7);
        sol.get(10);
        sol.get(5);
        sol.get(3);
        sol.set(8, 8);
    }


}