package lowest_common_ancestor_of_a_binary_search_tree;

/**
 * Created by y1275963 on 1/23/17.
 */
import utility.TreeNode;
import java.util.*;

public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == q.val)
            return q;
        if (root.val == p.val)
            return p;
        if (root.val > p.val && root.val > q.val)
            return Solution.lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return Solution.lowestCommonAncestor(root.right, p, q);
        return root;
    }
}