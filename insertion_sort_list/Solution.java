package insertion_sort_list;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
//        ListNode pointer = head;
        ListNode in;
        ListNode jn;
        ListNode inn;
        ListNode temp = new ListNode(0);
//        ListNode jnn = jn.next;
        for(ListNode i = head; i.next != null; ) {
//            StdOut.println();
            boolean inserted = false;
            for(ListNode j = dummy; j.next != i.next; j = j.next) {
                if(i.next.val < j.next.val) {
                     in = i.next;
                     jn = j.next;
                     inn = in.next;
//                     jnn = jn.next;
                        j.next = in;
                        in.next = jn;
                        i.next = inn; 
                        
                        inserted = true;
                        
                        break;
                    }
                }
//                    StdOut.println("Dummy" + dummy);
                if(!inserted)
                    i = i.next;
            }
        
            
        
        return dummy.next;
    }
        

    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(10, 3);
        StdOut.println(test);

        Solution sol = new Solution();
        test = sol.insertionSortList(test);
        StdOut.println(test);
    }

}
