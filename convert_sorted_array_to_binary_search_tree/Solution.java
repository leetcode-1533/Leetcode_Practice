package convert_sorted_array_to_binary_search_tree;

/**
 * Created by y1275963 on 5/24/16.
 */
import utility.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        else
            return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo == hi)
            return new TreeNode(nums[lo]);
        else if (hi - lo == 1) {
            TreeNode root = new TreeNode(nums[hi]);
            root.left = new TreeNode(nums[lo]);
            return root;
        }
        else {
            int root_loc = (int) Math.ceil((hi + lo) / 2.0);
            TreeNode root = new TreeNode(nums[root_loc]);
            root.left = dfs(nums, lo, root_loc - 1);
            root.right = dfs(nums, root_loc + 1, hi);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.build(new Integer[] {1,2,3,4,null,null,5});
        tree.print();

        System.out.println();

        Solution test = new Solution();
        TreeNode re = test.sortedArrayToBST(new int[] {1, 3, 4, 5, 12, 15});
        re.print();
    }
}
