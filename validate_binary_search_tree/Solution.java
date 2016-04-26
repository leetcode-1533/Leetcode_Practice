package validate_binary_search_tree;

import utility.TreeNode;
/**
 * Created by y1275963 on 4/25/16.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return (root == null || isvalid(root, null, null));
    }

    private boolean isvalid(TreeNode root, Integer largert, Integer smallert) {
        boolean lt = true;
        boolean rt = true;
        boolean ist = true;
        if(largert != null)
            ist = root.val > largert;
        if(smallert != null)
            ist = ist && root.val < smallert;

        if(ist && root.left != null)
            lt = isvalid(root.left, largert, root.val);
        if(ist && lt && root.right != null)
            rt = isvalid(root.right, root.val, smallert);

        return ist && lt && rt;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {Integer.MAX_VALUE});
        Solution sol = new Solution();
        System.out.println(sol.isValidBST(tree1));
    }
}
