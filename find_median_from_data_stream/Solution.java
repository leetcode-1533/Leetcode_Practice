package find_median_from_data_stream;

/**
 * Created by y1275963 on 6/3/16.
 */

import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution {
    private static final int INITIALSIZE = 10;

    private class reverseIntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer x, Integer y) {
            return -x.compareTo(y);
        }
    }

    PriorityQueue<Integer> lowerbound = new PriorityQueue<>(INITIALSIZE, new reverseIntComparator());
    PriorityQueue<Integer> upperbound = new PriorityQueue<>(INITIALSIZE);

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (lowerbound.size() == 0 && upperbound.size() == 0)
            lowerbound.add(num);
        else if (lowerbound.size() == 0) {
            if (num > upperbound.peek())
                lowerbound.add(num);
            else
                upperbound.add(num);
        } else if (upperbound.size() == 0) {
            if (num < lowerbound.peek())
                upperbound.add(num);
            else
                lowerbound.add(num);
        } else {
            if (num > upperbound.peek() && num < lowerbound.peek()) {
                if (upperbound.size() > lowerbound.size())
                    lowerbound.add(num);
                else
                    upperbound.add(num);
            } else if (num < upperbound.size())
                upperbound.add(num);
            else
                lowerbound.add(num);
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
        Solution sol = new Solution();
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
        sol.addNum(1);
        sol.addNum(2);
        sol.addNum(3);


        System.out.println(sol.findMedian());

    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();