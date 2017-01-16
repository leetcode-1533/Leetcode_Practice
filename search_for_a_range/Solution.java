package search_for_a_range;

import java.util.*;
/**
 * Created by y1275963 on 1/11/17.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ln = lowersearch(nums, target);
        int rn = highersearch(nums, target);

        if(ln == -1 || rn == -1 || ln > rn)
            return new int[]{-1, -1};
        else
            return new int[]{ln, rn};
    }

    private int lowersearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int lp = 0;
        int rp = nums.length - 1;
        int mean = 0;
        while (rp - lp > 1) {
            mean = lp + (rp - lp) / 2;
            if (target <= nums[mean])
                rp = mean;
            else
                lp = mean;
        }
        if (nums[lp] > target)
            return -1;
        else if (nums[lp] == target) {
//            System.out.println("Test");

            return lp;
        }
        else if (nums[mean] == target) {
//            System.out.println("test 2");

            return mean;
        }
        else {
//            System.out.println("test 3");
            return rp;
        }
    }

    private int highersearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int lp = 0;
        int rp = nums.length - 1;
        int mean = 0;
        while (rp - lp > 1) {
            mean = lp + (rp - lp) / 2;
            if (target >= nums[mean])
                lp = mean;
            else
                rp = mean;
        }

        if (nums[rp] < target)
            return -1;
        else if (nums[rp] == target)
            return rp;
        else if (nums[mean] == target)
            return mean;
        else
            return lp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d\t", nums[i]);
        }
        System.out.println();

        int[] re = sol.searchRange(nums, 5);
        for (int item : re)
            System.out.println(item);
//        Set<Integer> test = new HashSet<>();
//
//        for (int item : nums)
//            test.add(new Integer(item));
//

//
//        for (int item : test) {
//            System.out.printf("input: %d, output: %d\n", item, sol.lowersearch(nums, item));
//        }

//        System.out.println(sol.lowersearch(nums, 8));
    }
}
