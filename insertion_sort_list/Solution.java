package insertion_sort_list;
import delete_node_in_a_linked_list.ListNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode tail = head;
        if(head.val > head.next.val) {
            tail = head.next;
        }

        ListNode st = head;       
        if(st.next != null) {
            if(st.next.val < st.val)
                exch(st, st.next);    
            else if(st.next != null)
                st = st.next;
        }
        
        return tail;    
    }
    
    private void exch(ListNode fir, ListNode sec) {
        ListNode temp = sec.next;
        sec.next = fir;
        fir.next = temp;     
    }

    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(10, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.insertionSortList(test);
        StdOut.println(test);
    }

}
