package swap_nodes_in_pairs;

import edu.princeton.cs.algs4.StdOut; 
// https://leetcode.com/problems/swap-nodes-in-pairs/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        while(head != null) {
            if(head.next == null) {
                p.next = head;
                head = head.next;            
            } else {
                ListNode temp = head.next.next;
                p.next = head.next;
                p.next.next = head;
                head.next = temp;
                
                head = head.next;
                p = p.next.next;
            }            
        }
        return dummyhead.next;
    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(0, 100);
        ListNode.printlist(test);
        StdOut.println("After swap");
        Solution sol = new Solution();
        test = sol.swapPairs(test);
        ListNode.printlist(test);        
    }

}
