package binary_tree_level_order_traversal;

/**
 * Created by y1275963 on 1/17/17.
 */
import java.util.*;
import utility.TreeNode;

public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> container = new ArrayList<>();
        if(root == null)
            return container;

        Queue<TreeNode> current = new ArrayDeque<>();
        Queue<TreeNode> next = new ArrayDeque<>();
        ArrayList<Integer> progress = new ArrayList<>();
        current.add(root);

        while(!current.isEmpty()) {
            TreeNode temp = current.poll();
            progress.add(temp.val);

            if (temp.left != null)
                next.add(temp.left);
            if (temp.right != null)
                next.add(temp.right);

            if (current.isEmpty()) {
                container.add(new ArrayList<>(progress));
                progress.clear();
                current = next;
                next = new ArrayDeque<>();
            }
        }
        return container;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        List<List<Integer>> re = Solution.levelOrder(root);
        for (List<Integer> level : re) {
            for (Integer item: level)
                System.out.printf("%d ", item);

            System.out.println();
        }
    }

}