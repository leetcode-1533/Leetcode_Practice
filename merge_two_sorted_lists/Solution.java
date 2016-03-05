package merge_two_sorted_lists;
import edu.princeton.cs.algs4.StdOut;
import insertion_sort_list.ListNode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;               
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) p.next = l2;
        if(l2 == null) p.next = l1;
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = ListNode.randomeNode(10, 3);
        StdOut.println("l1: " + l1);
        
        ListNode l2 = ListNode.randomeNode(10, 8);
        StdOut.println("l2:" + l2);

        Solution sol = new Solution();
        StdOut.println(sol.mergeTwoLists(l1, l2));
        
    }

}
