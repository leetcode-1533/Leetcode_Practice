package temp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int reductionCost(int[] num) {
        int[] temp_num = num.clone();
        Arrays.sort(temp_num);

        int two_sum = temp_num[0] + temp_num[1];
        int sum = two_sum;
        for (int i = 2; i < temp_num.length; i++) {
            two_sum += temp_num[i];
            sum += two_sum;

        }
        return sum;
    }

    static int reductionCost2(int[] num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(num.length);
        for (int item : num) {
            pq.add(item);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            pq.add(temp);
            sum += temp;
        }

        return sum;
    }

    static int[] removehead(int[] num) {
        int[] num_temp = new int[num.length - 1];
        System.arraycopy(num, 1, num_temp, 0, num_temp.length);
        return num_temp;
    }

    static long countMoves(int[] numbers) {
        long ans = 0;
        int[] temp = numbers.clone();
        Arrays.sort(temp);
        int min_num = temp[0];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i] - min_num;
        }
        for (int i = 0; i < temp.length; i++) {
            ans += temp[i];
        }
        return ans;
    }

    public static void main(String[] args){
        int[] test = new int[]{1, 2};
//        int[] test2 = new int[]{2, 2, 2};
        int re = reductionCost2(test);
//        long re = countMoves(test2);
        System.out.println(re);
//        Scanner in = new Scanner(System.in);
//        int _n;
//        _n = Integer.parseInt(in.nextLine().trim());
    }
}
/**
 * Created by y1275963 on 10/2/16.
 */
