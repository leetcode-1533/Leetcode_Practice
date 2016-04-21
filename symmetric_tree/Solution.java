package symmetric_tree;

import utility.TreeNode;

/**
 * Created by y1275963 on 4/21/16.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        else {
            if (p == null || q == null) // either of which
                return false;
            else {
                return (p.val == q.val
                        && isSymmetricTree(p.left, q.right)
                        && isSymmetricTree(p.right, q.left));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {1,2,2,4,null,null,4});
        Solution sol = new Solution();
        System.out.println(sol.isSymmetric(tree1));
    }
}
