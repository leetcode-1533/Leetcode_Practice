package median_of_two_sorted_arrays;

/**
 * Created by y1275963 on 8/4/16.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    private int i, j;

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
        int[] test1 = new int[]{1, 2, 3, 4};
        int[] test2 = new int[]{4, 5, 6, 7};
        Solution sol = new Solution();

        for (int i = 0; i < test1.length + test2.length; i++)
            System.out.println(sol.next(test1, test2));
    }
}