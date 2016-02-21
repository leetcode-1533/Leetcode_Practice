package merge_k_sorted_lists;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
       while(lists.length != 1) {
           ListNode[] temp = new ListNode[lists.length / 2];
           for(int i = 0; i * 2 < lists.length; i++) {
//               StdOut.println("I * 2: " + i * 2 + " next: " + (i * 2 + 1));  
               temp[i] = merge(lists, i * 2, i * 2 + 1);
           }
           lists = temp;
       }    
       return lists[0];
   }
   
   private ListNode merge(ListNode[] lists, int start, int end) {
       ListNode listart = lists[start];
       ListNode liend = lists[end];
       ListNode root = listart;
       
       while(liend != null) {
           if(listart.next == null) {
               listart.next = liend;
               return root;
           }          
           if(listart.next.val <= liend.val) {
               ListNode liendnext = liend.next;
               insert(listart, liend);
               liend = liendnext;             
           } else {
               listart = listart.next;
           }
       }     
       return root;       
   }
   
   private void insert(ListNode hold, ListNode join) {
       ListNode temp = hold.next;
       hold.next = join;
       join.next = temp;
   }
   
   public static void main(String[] args) {
//       sol.mergeKLists(new ListNode[6]); 
//       StdOut.printf("Node Test %d\n next:", test.val);
//       StdOut.println(test.next);
       ListNode root = new ListNode(20);
       ListNode current = root;
       for(int i = 4; i >= 0; i--) {
           current.next = new ListNode(i * 2 + 3);
           current = current.next;
       }
       Solution sol = new Solution();
   }
}
