package insertion_sort_list;
import delete_node_in_a_linked_list.ListNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        if(head.next != null && head.val > head.next.val) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head; 
            head = temp;
        }
        ListNode tail = head;
      
        ListNode temp = tail;
        ListNode iter = temp.next;
        
        while(iter.next != null) {
            if(iter.next.val < iter.val) {
                temp = exch(temp, iter, iter.next);            
            }
        }

        
        return tail;    
    }
    
    private ListNode exch(ListNode before, ListNode middle, ListNode after) {
        ListNode fourth = after.next;
        
        before.next = after;
        after.next = middle;
        middle.next = fourth;
        
        return after;  
    }

    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(10, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.insertionSortList(test);
        StdOut.println(test);
    }

}
