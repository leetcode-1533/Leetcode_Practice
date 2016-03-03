package insertion_sort_list;
import delete_node_in_a_linked_list.ListNode;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = head;
        
        for(ListNode i = head; i.next != null; i = i.next) {
            StdOut.println();
            StdOut.println("i: " + i.next);
            for(ListNode j = dummy; j != i.next; j = j.next) {
                if(j.next.val > i.next.val) {
                    StdOut.println("EXCH: j: " + j.next);
                }
            }
        }
            
        
        return dummy.next;
    }
        

    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(5, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        sol.insertionSortList(test);
    }

}
