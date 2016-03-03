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
//        ListNode pointer = head;
        
        for(ListNode i = head; i.next != null; i = i.next) {
//            StdOut.println();
//            StdOut.println("i: " + i.next);
            for(ListNode j = dummy; j.next != i.next; j = j.next) {
                if(i.next.val < j.next.val) {
                    ListNode in = i.next;
                    ListNode jn = j.next;
                    ListNode inn = in.next;
                    ListNode jnn = jn.next;
                    if(j.next == i) {
                        j.next = in;
                        in.next = jn;
                        jn.next = inn;    
                        i = in;
                    } else {
                        j.next = in;
                        in.next = jn;

                        i.next = inn;
                        i = jn;
                    }
                    StdOut.println("Dummy" + dummy);

                    break;
                }
            }
        }
            
        
        return dummy.next;
    }
        

    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(5, 100);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.insertionSortList(test);
        StdOut.println(test);
    }

}
