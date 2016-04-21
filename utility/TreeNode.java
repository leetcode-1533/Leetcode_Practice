package utility;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Common Tree node
 * Created by xiezefan on 15/9/5.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode build(Integer[] data) {
        return build(1, data);
    }

    public void print() {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.print(node.val + " ");
        }
    }

    private static TreeNode build(int index, Integer[] data) {
        if (index > data.length) {
            return null;
        }

        if (data[index - 1] == null) {
            return null;
        }

        TreeNode result = new TreeNode(data[index - 1]);
        result.left = build(index * 2, data);
        result.right = build(index * 2 + 1, data);

        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.build(new Integer[] {1,2,3,4,null,null,5});
        tree.print();
    }
}
