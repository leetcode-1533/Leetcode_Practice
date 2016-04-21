package symmetric_tree;

import utility.TreeNode;
import java.util.Queue;
import java.util.ArrayDeque;
/**
 * Created by y1275963 on 4/21/16.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricTree2(root.left, root.right);
    }

    public boolean isSymmetricTree1(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        else {
            if (p == null || q == null) // either of which
                return false;
            else {
                return (p.val == q.val
                        && isSymmetricTree1(p.left, q.right)
                        && isSymmetricTree1(p.right, q.left));
            }
        }
    }

    public boolean isSymmetricTree2(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        if (p == null || q == null)
            return false;

        Queue<TreeNode> quel = new ArrayDeque<TreeNode>();
        Queue<TreeNode> quer = new ArrayDeque<TreeNode>();
        quel.add(p);
        quer.add(q);
        while (!quel.isEmpty()) {
            TreeNode le = quel.poll();
            TreeNode ri = quer.poll();
            if (le.val != ri.val)
                return false;
            else if ((enqueue(quel, le.left, quer, ri.right)
                    && enqueue(quel, le.right, quer, ri.left)) == false)
                return false;
        }
        return true;
    }

    private boolean enqueue(Queue<TreeNode> quel, TreeNode nl, Queue<TreeNode> quer, TreeNode nr) {
        if(nl == null && nr == null)
            return true;
        if(nl == null || nr == null)
            return false;
        quel.add(nl);
        quer.add(nr);
        return true;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.build(new Integer[] {1, 2, 2});
        Solution sol = new Solution();
        System.out.println(sol.isSymmetric(tree1));
    }
}
