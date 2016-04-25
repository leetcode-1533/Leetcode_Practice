package validate_binary_search_tree;

import utility.TreeNode;
/**
 * Created by y1275963 on 4/25/16.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        else if (root.left != null && root.right == null)
            return (root.val > root.left.val && isValidBST(root.left));
        else if (root.left == null && root.right != null)
            return (root.val < root.right.val && isValidBST(root.right));
        else
            return (root.val < root.right.val && root.val > root.left.val
                    && isValidBST(root.left)
                    && isValidBST(root.right));
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {10,5,15,null,null,6,20});
        Solution sol = new Solution();
        System.out.println(sol.isValidBST(tree1));
    }
}
