package two_sum_ii_input_array_is_sorted;

/**
 * Created by y1275963 on 5/28/16.
 */
import java.util.Arrays;
public class Solution {
    // binary search
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int x = target - numbers[i];
            int id = Arrays.binarySearch(numbers, x);
            if (id == i) {
                if (numbers[i-1] == x)
                    return new int[] {i - 1 + 1, i + 1};
                else if (numbers[i+1] == x)
                    return new int[] {i + 1, i + 1 + 1};
                else
                    continue;
            }

            if (id >= 0)
                return new int[] {i + 1, id + 1};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // two pointer
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i != j) {
            int x = numbers[i] + numbers[j];
            if (target > x)
                i++;
            else if (target < x)
                j--;
            else
                return new int[] {i + 1, j + 1};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2};
        int target = 3;
        Solution sol = new Solution();
        int[] indices = sol.twoSum2(nums, target);
        for (int item : indices)
            System.out.println(item);
    }

}
