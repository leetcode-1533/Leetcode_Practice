package binary_tree_level_order_traversal_ii;

/**
 * Created by y1275963 on 1/23/17.
 */
import java.util.*;
import utility.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();
        if (root == null)
            return re;
        List<TreeNode> starter = new ArrayList<>();
        starter.add(root);
        bfs(starter, re);
        return re;
    }

    public void bfs(List<TreeNode> level, List<List<Integer>> container) {
        if (level.size() == 0)
            return;

        List<TreeNode> next = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (TreeNode item : level) {
            temp.add(item.val);
            if (item.left != null)
                next.add(item.left);
            if (item.right != null)
                next.add(item.right);
        }
        bfs(next, container);
        container.add(temp);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3,9,20,null,null,15,7});
        Solution sol = new Solution();
        List<List<Integer>> re = sol.levelOrderBottom(root);
        for (List<Integer> level : re) {
            for (Integer item: level)
                System.out.printf("%d ", item);

            System.out.println();
        }
    }
}
