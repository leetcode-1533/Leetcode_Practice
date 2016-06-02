package rotate_array;

/**
 * Created by y1275963 on 6/2/16.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        k = k % nums.length;

        reverse(0, nums.length - k - 1, nums);
        reverse(nums.length - k, nums.length - 1, nums);
        reverse(0, nums.length - 1, nums);
    }

    private void reverse(int start, int end, int[] nums) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = new int[] {-1};
//        int[] test = new int[] {};
//        int[] test = new int[] {1, 2, 3, 4, 5, 6, 7};
        sol.rotate(test, 4);
        for (int item : test)
            System.out.print(item);
//        System.out.println(sol.next(0, 7, 4));
    }
}
