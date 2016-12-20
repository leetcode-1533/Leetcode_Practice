package remove_duplicates_from_sorted_array;

/**
 * Created by y1275963 on 12/20/16.
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        int navigator = 1;
        int writer = 0;
        while (navigator != nums.length) {
            if (nums[navigator] != nums[navigator - 1]) {
                writer++;
                nums[writer] = nums[navigator];
            }
            navigator++;
        }
        return (writer + 1);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 1, 1, 2, 3, 3, 4, 5};
        int re = Solution.removeDuplicates(test);
        for (int item : test) {
            System.out.printf("\t %d", item);
        }
        System.out.println();
        System.out.println(re);
    }
}
