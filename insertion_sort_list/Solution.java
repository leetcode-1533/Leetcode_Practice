package insertion_sort_list;
import delete_node_in_a_linked_list.ListNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }

    }
        

    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(10, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.insertionSortList(test);
        StdOut.println(test);
    }

}
