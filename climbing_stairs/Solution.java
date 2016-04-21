package climbing_stairs;

import java.util.concurrent.ArrayBlockingQueue;
/**
 * Created by y1275963 on 4/21/16.
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            int[] ans = new int[]{1, 2};
            return ans[n - 1];
        } else {
            ArrayBlockingQueue<Integer> que = new ArrayBlockingQueue<Integer>(3);
            que.add(1);
            que.add(2);

            int counter = 2;
            int ans = 0;
            while (counter != n) {
                ans = 0;
                for(Integer item : que) {
                    ans += item;
                }
                que.poll();
                que.add(ans);
                counter++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(1));
    }
}
