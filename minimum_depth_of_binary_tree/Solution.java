package minimum_depth_of_binary_tree;

import utility.TreeNode;
/**
 * Created by y1275963 on 4/25/16.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else
          return getMinDepth(root, 1);
    }

    private int getMinDepth(TreeNode node, int curDepth) {
        if(node.left == null && node.right == null)
            return curDepth;
        if(node.left == null || node.right == null) {
            if(node.left == null)
                return getMinDepth(node.right, curDepth + 1);
            else
                return getMinDepth(node.left, curDepth + 1);
        }
        return Math.min(getMinDepth(node.left, curDepth + 1), getMinDepth(node.right, curDepth + 1));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode tree1 = TreeNode.build(new Integer[] {1, 2, 2, 3, null, null, null, 4});

        System.out.println(sol.minDepth(tree1));
    }
}
