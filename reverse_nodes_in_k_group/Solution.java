package reverse_nodes_in_k_group;

import edu.princeton.cs.algs4.StdOut;


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode dummy = new ListNode(0);
        ListNode pnew = dummy;
        
        ListNode pold = head;
        
        // test for k
        while(i++ < (k - 1) && head.next != null) // head in the last section's tail, guaranteed section complete
            head = head.next;
        
        if(i == k)
            StdOut.println("Success");
        head.next = null; // cut the section
        
        while(pold != null) {
            pnew.next = pold;
            pold = pold.next;
        }
        
        return dummy.next;
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
        ListNode test = ListNode.randomeNode(5, 100);
        ListNode.printlist(test);

        Solution sol = new Solution();
        test = sol.reversetillnull(test);
        StdOut.println("Rervertillnull");
        ListNode.printlist(test);

    }
}
