package find_peak_element;

/**
 * Created by y1275963 on 1/23/17.
 */
import java.util.*;

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null)
            return 0;

        int starti = 0;
        int endi = nums.length - 1;
        int mean = 0;
        while (endi - starti > 1) {
            mean = starti + (endi - starti) / 2;
            if (mean == starti || mean == endi)
                return mean;
            if (nums[mean - 1] > nums[mean])
                endi = mean - 1;
            else if (nums[mean + 1] > nums[mean])
                starti = mean + 1;
            else
                return mean;
        }
        mean = (nums[starti] > nums[endi]) ? starti : endi;
        return mean;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 2};
        Solution sol = new Solution();
        int re = sol.findPeakElement(test);
        System.out.println(re);
    }
}