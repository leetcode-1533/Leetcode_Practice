package odd_even_linked_list;

import edu.princeton.cs.algs4.StdOut;

// https://leetcode.com/problems/odd-even-linked-list/
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddhead = head;
        ListNode op = oddhead;
        ListNode evenhead = head.next;
        ListNode ep = evenhead;
        
        head = head.next;
        
        while(head.next != null) {
            head = head.next;
            op.next = head;
            op = head;
            if(head.next != null) {
                head = head.next;
                ep.next = head;
                ep = head;
            } else {
                
            }
        }
        op.next = evenhead;
        return oddhead;      
    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(3, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.oddEvenList(test);
        StdOut.println(test);
    }
}