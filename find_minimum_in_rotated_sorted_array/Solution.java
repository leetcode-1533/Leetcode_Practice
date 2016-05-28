package find_minimum_in_rotated_sorted_array;

/**
 * Created by y1275963 on 5/27/16.
 */
public class Solution {
    /*
     without duplicate, log(n)
     */
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (hi - lo > 1) {
            if (nums[lo] < nums[hi]) // if not rotated
                return nums[lo];

            mid = (lo + hi) / 2;
            if (nums[lo] < nums[mid])
                lo = mid;
            else if (nums[mid] < nums[hi])
                hi = mid;
        }
        return Math.min(nums[lo], nums[hi]);
        // not rotated, return nums[lo] only happen when n=2
        // rotated, return nums[hi]
    }

    /*
    with duplicate, o(n) worst case
     */
//    public int findMin(int[] nums) {
//        int lo = 0;
//        int hi = nums.length - 1;
//        int mid;
//        while (hi - lo > 1) {
//            if (nums[lo] < nums[hi]) // if not rotated
//                return nums[lo];
//
//            mid = (lo + hi) / 2;
//            if (nums[lo] < nums[mid])
//                lo = mid;
//            else if (nums[mid] < nums[hi])
//                hi = mid;
//            else {
//                lo = lo + 1;
//            }
//        }
//        return Math.min(nums[lo], nums[hi]);
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(sol.findMin(new int[] {3, 1}));
    }
}
