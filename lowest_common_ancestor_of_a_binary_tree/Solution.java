package lowest_common_ancestor_of_a_binary_tree;

/**
 * Created by y1275963 on 1/23/17.
 */
import utility.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ppath = new ArrayList<>();
        dfs(root, p, ppath);
        ArrayList<TreeNode> qpath = new ArrayList<>();
        dfs(root, q, qpath);
        HashSet<TreeNode> dedup = new HashSet<>();
        for (TreeNode item : ppath)
            dedup.add(item);
        for (TreeNode item : qpath) {
            if (dedup.contains(item))
                return item;
        }
        return null;
    }


    private boolean dfs(TreeNode root, TreeNode p, ArrayList<TreeNode> container) {
        if (root == null)
            return false;
        if (root == p || dfs(root.left, p, container) || dfs(root.right, p, container)) {
            container.add(root);
            return true;
        }
        return false; // not found
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.build(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = tree.left;
        TreeNode q = tree.left.right.right;

        ArrayList<TreeNode> re = new ArrayList<>();
        Solution sol = new Solution();
        TreeNode item = sol.lowestCommonAncestor(tree, p, q);
        System.out.println(item.val);

    }
}
