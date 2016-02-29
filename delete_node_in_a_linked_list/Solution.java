package delete_node_in_a_linked_list;

import edu.princeton.cs.algs4.StdOut;


// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;    
    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(10, 100);
        StdOut.println(test);

        ListNode testnext = test.next;
        Solution sol = new Solution();
        sol.deleteNode(test);
        StdOut.println(test);
    }

}
