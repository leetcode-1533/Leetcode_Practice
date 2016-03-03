package insertion_sort_list;

import java.util.Random;
import java.lang.StringBuilder;
import edu.princeton.cs.algs4.StdOut;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
     public int val;
     public ListNode next;
     
     public ListNode() {
         val = 0;
     }
     
     public ListNode(int x) {
         val = x; 
     }
     
     
     public static ListNode randomeNode(int len, int maxrange) {
         Random test = new Random();
         int max = test.nextInt(maxrange);
         ListNode root = new ListNode(max);
         
         ListNode current = root;
         for(int i = 0; i < len; i++) {
             current.next = new ListNode(max - 1 * i + test.nextInt(2));       
             current = current.next;
         }       
         return root.next;
     }
     
     public String toString() {
         StringBuilder s = new StringBuilder();

         ListNode current = this;
         while(current.next != null) {
             s.append(current.val +" -> ");
             current = current.next;         
         }
         s.append(current.val);
         return s.toString();       
     }
     
     public static void main(String[] args) {
         //       sol.mergeKLists(new ListNode[6]); 
//         StdOut.printf("Node Test %d\n next:", test.val);
//         StdOut.println(test.next);
         
         ListNode test = ListNode.randomeNode(5, 3);
         StdOut.println(test);
     }
}
