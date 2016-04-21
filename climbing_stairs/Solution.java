package climbing_stairs;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * Created by y1275963 on 4/21/16.
 */
public class Solution {
    public int climbStairs(int n) {
        int counter = 2;

        int[] cal = new int[]{1, 2};
        if (n <= counter) {
            return cal[n - 1];
        } else {
            while( counter !=n ) {
                int temp = cal[1];
                cal[1] = cal[0] + cal[1];
                cal[0] = temp;
                counter++;
            }
        }
        return cal[1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(4));
    }
}
