package median_of_two_sorted_arrays;

/**
 * Created by y1275963 on 8/4/16.
 */
public class Solution {
    private int i, j;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    public double findMedianSortedArrays_merge(int[] nums1, int[] nums2) {
        i = 0;
        j = 0;

        int target = (nums1.length + nums2.length + 1) / 2 - 1;
        while (i + j < target)
            next(nums1, nums2);

        if ((nums1.length + nums2.length) % 2 == 0)
            return (next(nums1, nums2) + next(nums1, nums2)) / 2.0;
        else
            return next(nums1, nums2);
    }

    private int next(int[] nums1, int[] nums2) {
        if (i == nums1.length)
            return nums2[j++];
        else if (j == nums2.length)
            return nums1[i++];
        else if (nums1[i] < nums2[j])
            return nums1[i++];
        else
            return nums2[j++];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test1 = new int[]{1};
        int[] test2 = new int[]{};

        System.out.println(sol.findMedianSortedArrays_merge(test1, test2));


//
//        for (int i = 0; i < test1.length + test2.length; i++)
//            System.out.println(sol.next(test1, test2));

    }
}