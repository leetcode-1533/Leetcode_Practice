package path_sum;

import utility.TreeNode;
/**
 * Created by y1275963 on 1/16/17.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode current, int cur_sum, int target) {
        if (current != null) {
            if (current.left == null && current.right == null) {
                return cur_sum + current.val == target;
            }
            else
                return dfs(current.left, cur_sum + current.val, target) || dfs(current.right, cur_sum + current.val, target);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.build(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1});
        Solution sol = new Solution();
        boolean re = sol.hasPathSum(tree, 22);
        System.out.println(re);
    }
}