package binary_tree_paths;

/**
 * Created by y1275963 on 1/16/17.
 */
import utility.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> re = new LinkedList<>();

        if (root == null)
            return re;

        if (root.left == null && root.right == null) {
            re.add(Integer.toString(root.val));
        } else {
            dfs(re, root.left, Integer.toString(root.val));
            dfs(re, root.right, Integer.toString(root.val));
        }

        return re;
    }

    private void dfs(LinkedList<String> container, TreeNode current, String current_path) {
        if (current != null) {
            if(current.left == null && current.right == null) {
                container.add(current_path + "->" + current.val);
            } else {
                dfs(container, current.left, current_path + "->" + current.val);
                dfs(container, current.right, current_path + "->" + current.val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.build(new Integer[] {1, 2, 3, null, 5});
        Solution sol = new Solution();
        List<String> re = sol.binaryTreePaths(tree);
        for (String item : re) {
            System.out.println(item);
        }
    }
}
