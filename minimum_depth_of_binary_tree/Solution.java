package minimum_depth_of_binary_tree;

import utility.TreeNode;
import java.util.Queue;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ArrayDeque;
/**
 * Created by y1275963 on 4/25/16.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else
            return getMinDepth2(root);
//          return getMinDepth(root, 1);
    }

    private int getMinDepth(TreeNode node, int curDepth) {
        if(node.left == null && node.right == null)
            return curDepth;
        if(node.left == null || node.right == null) {
            if(node.left == null)
                return getMinDepth(node.right, curDepth + 1);
            else
                return getMinDepth(node.left, curDepth + 1);
        }
        return Math.min(getMinDepth(node.left, curDepth + 1), getMinDepth(node.right, curDepth + 1));
    }

    private int getMinDepth2(TreeNode root) {
        Queue<Entry> que = new ArrayDeque<Entry>();
        Entry<TreeNode, Integer> en_root = new SimpleEntry<>(root, 1);
        que.add(en_root);
        while(!que.isEmpty()) {
            Entry temp = que.poll();
            TreeNode tree_temp = (TreeNode) temp.getKey();
            if(tree_temp.left == null && tree_temp.right == null)
                return (Integer) temp.getValue();
            if(tree_temp.left != null)
                que.add(new SimpleEntry<>(tree_temp.left, ((Integer) temp.getValue()) + 1));
            if(tree_temp.right != null)
                que.add(new SimpleEntry<>(tree_temp.right, ((Integer) temp.getValue()) + 1));
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode tree1 = TreeNode.build(new Integer[] {1, 2});

        System.out.println(sol.minDepth(tree1));
    }
}
