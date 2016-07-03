package threesum;

import java.util.*;

/**
 * Created by y1275963 on 6/28/16.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> ele_table = new HashMap<>(nums.length);
        List<List<Integer>> re = new ArrayList<>();

        int[] nums_copy = nums.clone();
        Arrays.sort(nums_copy);

        for (int i = 0; i < nums_copy.length; i++)
            ele_table.put(nums_copy[i], i);

        for (int i = 0; i < nums_copy.length; i++) {
            if (i > 0 && nums_copy[i - 1] == nums_copy[i])
                continue;
            for (int j = i + 1; j < nums_copy.length; j++) {
                if (j > i + 1 && nums_copy[j - 1] == nums_copy[j])
                    continue;

                int target = 0 - nums_copy[i] - nums_copy[j];
                if (ele_table.containsKey(target) && ele_table.get(target) > j)
                    re.add(Arrays.asList(nums_copy[i], nums_copy[j], target));
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        List<List<Integer>> re = sol.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        List<List<Integer>> re = sol.threeSum(new int[] {0, 0, 0, 0});

        for (List<Integer> item : re) {
            System.out.println(item);
        }
    }
}
