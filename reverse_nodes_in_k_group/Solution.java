package reverse_nodes_in_k_group;

import edu.princeton.cs.algs4.StdOut;


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode rec = new ListNode(0);
        ListNode p = head;
        ListNode pold = head;
        ListNode temp = head;    
        
        // test for k
        if(head != null) {
            pold = head;

            while(i++ < (k - 1) && head.next != null) // head in the last section's tail, guaranteed section complete
                head = head.next;
            
            if(i == k) {
                temp = head.next;
                head.next = null; // cut the section
                p = reversetillnull(pold);
                pold.next = temp;
                head = temp;
                i = 0;
                rec.next = p;
            } else {
                return pold;
            }
            
        }
        
        while(head != null) {
            ListNode tk = temp;
            
            // test for k
            while(i++ < (k - 1) && head.next != null) // head in the last section's tail, guaranteed section complete
                head = head.next;
            
            
            if(i == k) {
                temp = head.next;
                head.next = null; // cut the section
                reversetillnull(tk);
                pold.next = head;
                head = temp;
                pold = tk;
                i = 0;
            } else {
                pold.next = tk;
            }
        }
        return rec.next;
            
    }
    public ListNode reversetillnull(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next;
  
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;        
        }
        return previous;
    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(4, 100);
        ListNode.printlist(test);

        Solution sol = new Solution();
        StdOut.println("reverseKGroup");
        test = sol.reverseKGroup(test, 4);
        ListNode.printlist(test);

    }
}
