package binary_search_tree_iterator;

/**
 * Created by y1275963 on 1/24/17.
 */
import utility.TreeNode;
import java.util.*;

public class BSTIterator {
    Stack<TreeNode> container;

    public BSTIterator(TreeNode root) {
        container = new Stack<>();
        this.bfs(root, container);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !container.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = container.pop();
        int re = current.val;

        bfs(current.right, container);
        return re;
    }

    private void bfs(TreeNode root, Stack<TreeNode> container) {
        if (root != null) {
            container.add(root);
            bfs(root.left, container);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{8});
        BSTIterator sol = new BSTIterator(root);
        while (sol.hasNext()) {
            System.out.println(sol.next());
        }

    }
}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
