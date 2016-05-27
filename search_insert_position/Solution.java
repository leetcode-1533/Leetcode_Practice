package search_insert_position;

/**
 * Created by y1275963 on 5/27/16.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) {
            if (target <= nums[0])
                return 0;
            else
                return 1;
        }


        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        if (hi - lo > 1) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                return binarySearch(nums, mid, hi, target);
            else // (target < nums[mid])
                return binarySearch(nums, lo, mid, target);
        } else { // hi - lo == 1
            if (target <= nums[lo]) // equality check
                return lo;
            else if (target > nums[hi])
                return hi + 1;
            else
                return hi;
        }
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int midab =  (int) Math.ceil((double) a/b);
//        System.out.println(midab);

        int[] nums = new int[] {1, 3};
        Solution sol = new Solution();
        int target = 1;
        System.out.println(sol.searchInsert(nums, target));
    }
}