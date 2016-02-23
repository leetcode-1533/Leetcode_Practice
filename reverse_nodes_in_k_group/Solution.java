package reverse_nodes_in_k_group;

import edu.princeton.cs.algs4.StdOut;


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode rec = new ListNode(0);
        ListNode p = head;
        ListNode pold = head;
        ListNode temp = head;    
        
        ListNode tail = head;
        
        // test for k
        if(head != null) {
            pold = head;
            while(i++ < (k - 1) && head.next != null) // head in the last section's tail, guaranteed section complete
                head = head.next;
            tail = head;
                      
            if(i == k) { // contain k
                rec.next = tail;
                tail = tail.next; // the header of the next section
                reversetillnull(pold, k);
                pold.next = tail; // indent to the next section
                head = tail; // indent to the next section
                i = 0;
            } else {
                return pold;
            }           
        }
        
        while(head != null) {
            
            // test for k
            while(i++ < (k - 1) && head.next != null) // head in the last section's tail, guaranteed section complete
                head = head.next;
            tail = head;
                    
            if(i == k) {
                rec.next = tail;
                tail = tail.next;
                reversetillnull(pold, k);
                pold.next = tail; // indent to the next section
                head = tail; // indent to the next section
                i = 0;
            } else {
                
                head = null;              
            }
        }
        return rec.next;
            
    }
    public void reversetillnull(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while(k-- !=0) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;        
        }
    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(5, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        StdOut.println("reverseKGroup");
        test = sol.reverseKGroup(test, 3);
        StdOut.println(test);

    }
}
