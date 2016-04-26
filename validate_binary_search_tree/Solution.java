package validate_binary_search_tree;

import utility.TreeNode;
/**
 * Created by y1275963 on 4/25/16.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return (root == null || isvalid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private boolean isvalid(TreeNode root, int largert, int smallert) {
        boolean lt = true;
        boolean rt = true;
        boolean ist = root.val > largert && root.val < smallert;
        if(ist && root.left != null)
            lt = isvalid(root.left, largert, root.val);
        if(ist && lt && root.right != null)
            rt = isvalid(root.right, root.val, smallert);
        return ist && lt && rt;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {10,5,15,null,null,6,20});
        Solution sol = new Solution();
        System.out.println(sol.isValidBST(tree1));
    }
}
