package two_sum;

/**
 * Created by y1275963 on 5/28/16.
 */
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            table.put(nums[i], i);
        for (int i = 0; i < nums.length; i ++) {
            int candidate = target - nums[i];
            if (table.containsKey(candidate) && table.get(candidate) != i)
                return new int[] {i, table.get(candidate)};
        }
        return null; // never reach, contain exactly one solution
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        Solution sol = new Solution();
        int[] indices = sol.twoSum(nums, target);
        for (int item : indices)
            System.out.println(item);
    }
}
