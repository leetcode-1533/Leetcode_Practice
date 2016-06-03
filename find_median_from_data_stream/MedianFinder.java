package find_median_from_data_stream;

/**
 * Created by y1275963 on 6/3/16.
 */

import java.util.Comparator;
import java.util.PriorityQueue;
public class MedianFinder {
    private static final int INITIALSIZE = 10;

    private class reverseIntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return -x.compareTo(y);
        }
    }

    private PriorityQueue<Integer> upperbound = new PriorityQueue<>(INITIALSIZE, new reverseIntComparator());
    private PriorityQueue<Integer> lowerbound = new PriorityQueue<>(INITIALSIZE);

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (upperbound.size() == 0)
            upperbound.add(num);
        else {
            if (num < upperbound.peek())
                upperbound.add(num);
            else
                lowerbound.add(num);
            balance();
        }
    }

    private void balance() {
        if (Math.abs(upperbound.size() - lowerbound.size()) >= 2) {
            if (upperbound.size() > lowerbound.size())
                lowerbound.add(upperbound.poll());
            else if (upperbound.size() < lowerbound.size())
                upperbound.add(lowerbound.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (lowerbound.size() == 0 && upperbound.size() == 0)
            throw new IllegalStateException();

        if ((lowerbound.size() + upperbound.size()) % 2 == 1) {
            // odd
            if (upperbound.size() > lowerbound.size())
                return upperbound.peek();
            else
                return lowerbound.peek();
        } else {
            return (lowerbound.peek() + upperbound.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder sol = new MedianFinder();
//        sol.upperbound.add(1);
//        sol.upperbound.add(5);
//        sol.upperbound.add(2);
//
//        System.out.println(sol.upperbound.peek());
//
//        sol.lowerbound.add(1);
//        sol.lowerbound.add(5);
//        sol.lowerbound.add(2);
//
//        System.out.println(sol.lowerbound.peek());
        int[] testSet = new int[] {1, 2};
        for (int item : testSet)
            sol.addNum(item);

        System.out.println(sol.findMedian());

    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();