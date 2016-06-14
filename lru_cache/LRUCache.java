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
            int re = map.get(key);
            list.addCount(key);
            return re;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.size() == size) {

        }

    }

    public static void main(String[] args) {
    }
}

class LinkedList {
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

        public int getValue() {
            return value;
        }
    }

    private Node head = null, tail = null;

    public Node offer(int value) {
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

    public Node poll() {
        Node temp = head;
        head = head.after;
        return temp;
    }

    public void addCount(Node node) {
        // move to the tail
        tail.after = node;
        tail = node;
    }
}