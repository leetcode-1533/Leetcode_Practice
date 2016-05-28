package hanoi_tower;

/**
 * Created by y1275963 on 5/28/16.
 * My own recursion practice
 */

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static int mem_num_precedure(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        Map<Integer, Integer> mem = new HashMap<>();
        return mem_precedure(n, 'A', 'B', 'C', mem);
    }

    private static int mem_precedure(int n, char beg, char aux, char end, Map<Integer, Integer> mem) {
        int count = 0;
        if (n > 1) {
            int temp = 0;
            if (mem.containsKey(n))
                temp = mem.get(n);
            else
                temp = mem_precedure(n - 1, beg, end, aux, mem);

            count = count + temp * 2 + 1;

//            count += precedure(n - 1, beg, end, aux);
            //precedure(1, beg, aux, end);
//            count++;
//            count += precedure(n - 1, aux, beg, end);
        } else { // n == 1
            return 1;
        }
        return count;
    }
    /*
    * BF method
     */
    public static int printprecedure(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        return precedure(n, 'A', 'B', 'C');
    }

    private static int precedure(int n, char beg, char aux, char end) {
        int count = 0;
        if (n > 1) {
            count += precedure(n - 1, beg, end, aux);
            //precedure(1, beg, aux, end);
            count++;
            count += precedure(n - 1, aux, beg, end);
        } else { // n == 1
            return 1;
        }
        return count;
    }


    public static void main(String[] args) {

        int n = 3;

        long bf_start = System.nanoTime();
            Solution.printprecedure(n);
        long bf_end = System.nanoTime();
        System.out.printf("Brute-Force  : %f milliseconds\n", (bf_end - bf_start) / 1000000.0);

        long mem_start = System.nanoTime();
            Solution.mem_num_precedure(n);
        long mem_end = System.nanoTime();
        System.out.printf("Memorization : %f milliseconds\n", (mem_end - mem_start) / 1000000.0);
    }
}
