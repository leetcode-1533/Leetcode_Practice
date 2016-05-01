package balanced_binary_tree;

import utility.TreeNode;
/**
 * Created by y1275963 on 5/1/16.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return depthof(root) != -1;
    }

    private int depthof(TreeNode node) {
        int cur_dl = 0;
        int cur_dr = 0;

        if (node == null)
            return 0;
        if (node.left != null)
            cur_dl = depthof(node.left);
        if (node.right != null)
            cur_dr = depthof(node.right);

        if (cur_dr == -1 || cur_dl == -1 || Math.abs(cur_dl - cur_dr) > 1)
            return -1;
        else
            return Math.max(cur_dl, cur_dr) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {1,2, null, 3});
        Solution sol = new Solution();
        System.out.println(sol.depthof(tree1));
    }
}
