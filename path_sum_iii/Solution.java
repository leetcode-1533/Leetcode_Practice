package path_sum_iii;

/**
 * Created by y1275963 on 1/16/17.
 */
import utility.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        return dfs(root, 0, sum) + this.pathSum(root.left, sum) + this.pathSum(root.right, sum);
    }

    private int dfs(TreeNode current, int cur_sum, int target) {
        if (current != null) {
            int re = 0;

            if (cur_sum + current.val == target)
                re = 1;

            re += dfs(current.left, cur_sum + current.val, target);
            re += dfs(current.right, cur_sum + current.val, target);

            return re;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[] {1,-2,-3,1,3,-2,null,-1});
        Solution sol = new Solution();
        int re;
         re = sol.pathSum(root, 3);
        System.out.println(re);

        root = TreeNode.build(new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1});
        re = sol.pathSum(root, 8);
        System.out.println(re);

        root = TreeNode.build(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1});
        re = sol.pathSum(root, 22);
        System.out.println(re);
    }
}