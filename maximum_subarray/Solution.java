package maximum_subarray;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by y1275963 on 5/27/16.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int currval = 0;
        Integer bestval = null;
        for (int item : nums) {
            currval = (currval + item > item) ? (currval = currval + item) : (currval = item);
            if (bestval == null || currval > bestval)
                bestval = currval;
        }
        return bestval;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(sol.maxSubArray(new int[] {1}));

    }
}