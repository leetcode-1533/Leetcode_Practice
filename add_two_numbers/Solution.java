package add_two_numbers;

import edu.princeton.cs.algs4.StdOut;
import insertion_sort_list.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;
            
            int l1val;
            int l2val;
            if(l1 == null)
                l1val = 0;
            else 
                l1val = l1.val;
            
            if(l2 == null)
                l2val = 0;
            else
                l2val = l2.val;
            
            sum = carry + l1val + l2val;
            
            p.next = new ListNode(sum % 10);
            p = p.next;
            if(l1 != null)  l1 = l1.next;
            if(l2 != null)  l2 = l2.next;
            
            carry = sum / 10;         
        }
        if(carry == 1)
            p.next = new ListNode(1);
        
        return dummy.next;       
    }
    
    
    public static void main(String[] args) {
        ListNode l1 = ListNode.fromlist(new int [] {5, 3, 3, 2, 5, 5});
        StdOut.println("l1: " + l1);

        Solution sol = new Solution();
        StdOut.println("Sum " + sol.addTwoNumbers(l1, l1));
    }
}
