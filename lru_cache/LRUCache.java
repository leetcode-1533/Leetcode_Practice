package lru_cache;

/**
 * Created by y1275963 on 6/13/16.
 */
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    int size;
    PriorityQueue<Entry<Integer, Integer>> leastQ;
    Map<Integer, Integer> map;

    private class counterComparator implements Comparator<Entry<Integer, Integer>> {
        @Override
        public int compare(Entry<Integer, Integer> x, Entry<Integer, Integer> y) {
            return x.getValue().compareTo(y.getValue());
        }
    }

    public LRUCache(int capacity) {
        size = capacity;
        leastQ = new PriorityQueue<>(capacity, new counterComparator());
        map = new HashMap<>(capacity);

    }

    public int get(int key) {
        return 0;
    }

    public void set(int key, int value) {
//        return 0;
    }

    public static void main(String[] args) {
        LRUCache sol = new LRUCache(10);
        sol.leastQ.add(new SimpleImmutableEntry(3, 0));
        sol.leastQ.add(new SimpleImmutableEntry(4, 20));
        sol.leastQ.add(new SimpleImmutableEntry(4, 30));
        System.out.println(sol.leastQ.peek());



    }
}
