package count_univalue_subtrees;

/**
 * Created by y1275963 on 1/23/17.
 */
import utility.TreeNode;

public class Solution {
    class count {
        int c = 0;
    }

    public int countUnivalSubtrees(TreeNode root) {
        count c = new count();
        dfs(root, c);
        return c.c;
    }

    private boolean dfs(TreeNode root, count count) {
        if (root == null)
            return true;

        boolean lval = dfs(root.left, count);
        boolean rval = dfs(root.right, count);

        if (lval == true && rval == true) {
            if (root.left == null && root.right == null) {
                count.c++;
                return true;
            } else if (root.left == null) {
                if (root.val == root.right.val) {
                    count.c++;
                    return true;
                } else
                    return false;
            } else if (root.right == null) {
                if (root.val == root.left.val) {
                    count.c++;
                    return true;
                } else
                    return false;
            } else {
                if (root.val == root.left.val && root.val == root.right.val) {
                    count.c++;
                    return true;
                }
                else
                    return false;
            }
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, null, 2});
        int re = test.countUnivalSubtrees(root);
        System.out.println(re);
    }
}