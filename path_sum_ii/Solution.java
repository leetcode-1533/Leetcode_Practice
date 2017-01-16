package path_sum_ii;

/**
 * Created by y1275963 on 1/16/17.
 */

import java.util.*;
import utility.TreeNode;

public class Solution {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> container = new ArrayList<>();
        dfs(root, sum, new ArrayList<Integer>(), container);
        return container;
    }

    private static void dfs(TreeNode current, int sum, List<Integer> progress, ArrayList<List<Integer>> container) {
        if (current != null) {
            progress.add(current.val);

            if (current.left == null && current.right == null && sum - current.val == 0) {
                container.add(progress);
            } else if (current.left == null && current.right == null) {
                // do nothing
            } else {
                dfs(current.left, sum - current.val, new ArrayList<Integer>(progress), container);
                dfs(current.right, sum - current.val, new ArrayList<Integer>(progress), container);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        List<List<Integer>> re = Solution.pathSum(root, 22);
        for (List<Integer> listitem : re) {
            for(int item : listitem) {
                System.out.printf("%d ", item);
            }
            System.out.printf("\n");
        }
    }
}