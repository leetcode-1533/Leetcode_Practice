package minimum_depth_of_binary_tree;

import utility.TreeNode;
/**
 * Created by y1275963 on 4/25/16.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        return getMinDepth(root, 0);
    }

    private int getMinDepth(TreeNode node, int curDepth) {
        if(node == null)
            return curDepth;
        else {
            return Math.min(getMinDepth(node.left, curDepth + 1), getMinDepth(node.right, curDepth + 1));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode tree1 = TreeNode.build(new Integer[] {1, 2, 2, 3, null, null, null, 4});

        System.out.println(sol.minDepth(tree1));
    }
}
