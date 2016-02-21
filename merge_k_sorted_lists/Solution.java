package merge_k_sorted_lists;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
       while(lists.length != 1) {
           for(int i = 0; i * 2 < lists.length; i++) {
               StdOut.println("I * 2: " + i * 2 + " next: " + (i * 2 + 1));              
           }
       }    
       return new ListNode();
   }
   
   public static void main(String[] args) {
       Solution sol = new Solution();
       sol.mergeKLists(new ListNode[5]); 
   }
}
