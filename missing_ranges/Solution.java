package missing_ranges;

/**
 * Created by y1275963 on 6/4/16.
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> re = new ArrayList<>();
        int[] nums_copy = new int[nums.length + 2];
        nums_copy[0] = lower - 1;
        for (int i = 1; i < nums_copy.length - 1; i++)
            nums_copy[i] = nums[i - 1];
        nums_copy[nums_copy.length - 1] = upper + 1;

        for (int i = 0; i < nums_copy.length - 1; i++) {
            if (nums_copy[i] + 1 != nums_copy[i + 1]) {
                if (nums_copy[i] + 1 == nums_copy[i + 1] - 1)
                    re.add(Integer.toString(nums_copy[i] + 1));
                else {
                    re.add((nums_copy[i] + 1) + "->" +  (nums_copy[i + 1] - 1));
                }
            }
        }

        return re;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> re = sol.findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99);
        for (String item : re)
            System.out.printf("%s ", item);
    }
}
