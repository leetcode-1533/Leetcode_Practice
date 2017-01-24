package binary_tree_preorder_traversal;

/**
 * Created by y1275963 on 1/19/17.
 */
import utility.TreeNode;
import java.util.*;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<>();
        dfs(root, re);
        return re;
    }

    private void dfs(TreeNode current, List<Integer> container) {
        if (current != null) {
            container.add(current.val);

            if (current.left != null)
                dfs(current.left, container);
            if (current.right != null)
                dfs(current.right, container);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode test = TreeNode.build(new Integer[] {1, null, 2, null, null, 3});
        List<Integer> re = sol.preorderTraversal(test);
        for (int item : re)
            System.out.printf("%d ", item);
    }
}
