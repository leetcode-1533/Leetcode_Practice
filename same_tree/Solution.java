package same_tree;

import utility.TreeNode;
import java.util.Stack;
/**
 * Created by y1275963 on 4/21/16.
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        else {
            if (p == null || q == null) // either of which
                return false;
            else {
                return (p.val == q.val
                        && isSameTree(p.left, q.left)
                        && isSameTree(p.right, q.right));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {1,2,3,4,null,null,5});
        TreeNode tree2 = TreeNode.build(new Integer[] {1,2,3,4,null,null,4});


        Solution sol = new Solution();
        System.out.println(sol.isSameTree(tree1, tree2));

    }
}
