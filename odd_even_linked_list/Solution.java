package odd_even_linked_list;

import edu.princeton.cs.algs4.StdOut;

// https://leetcode.com/problems/odd-even-linked-list/
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddhead = head;
        ListNode op = oddhead;
        
        ListNode evenhead;
        ListNode ep;
        if(head != null) {         
            evenhead = head.next;
            ep = evenhead;
        } else {
            return null;
        }
        
        
        while(head != null) {
            head = head.next;
            if(head != null) {
                head = head.next;  // increment by 2
                op.next = head;
                if(head != null) {
                    op = head; // in case op == null such that op.next doesn't stand
                    ep.next = head.next;
                    ep = head.next;                 
                }         
            }
        }       
        op.next = evenhead;
        return oddhead;      
    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(0, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.oddEvenList(test);
        StdOut.println(test);
    }
}