package path_sum_iii;

/**
 * Created by y1275963 on 1/16/17.
 */
import utility.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private int dfs(TreeNode current, int cur_sum, int target) {
        int re = 0;
        if (current != null) {
//            System.out.printf("current: %d, sum: %d\n", current.val, cur_sum);

            if (cur_sum + current.val == target)
                return 1;

            re += dfs(current.left, current.val + cur_sum, target);
            re += dfs(current.right, current.val + cur_sum, target);

            re += dfs(current.left, 0, target);
            re += dfs(current.right, 0, target);

            return re;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[] {1,-2,-3,1,3,-2,null,-1});
        Solution sol = new Solution();
        int re = sol.pathSum(root, 3);
        System.out.println(re);

        root = TreeNode.build(new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1});
        re = sol.pathSum(root, 8);
        System.out.println(re);
    }
}