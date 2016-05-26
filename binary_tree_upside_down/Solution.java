package binary_tree_upside_down;

/**
 * Created by y1275963 on 5/26/16.
 */
import utility.TreeNode;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null)
            return root;
        return dfs(root);
    }

    private TreeNode dfs(TreeNode pnode) {
        TreeNode cnode = pnode.left;
        TreeNode ans;

        if (cnode.left != null)
            ans = dfs(cnode);
        else
            ans = cnode;

        cnode.left = pnode.right;
        cnode.right = pnode;


        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.build(new Integer[] {1,2,3,4,5});
        Solution sol = new Solution();
        TreeNode ans = sol.upsideDownBinaryTree(tree);
        ans.print();


    }
}
