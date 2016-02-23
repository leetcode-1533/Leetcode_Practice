
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class ListNode {
     int val;
     ListNode next;
     
     ListNode(int x) {
         val = x; 
     }
     
     public static void printlist(ListNode pri) {
         while(pri != null) {
             StdOut.printf("val %d \n", pri.val);
             pri = pri.next;        
         }
     }
     
     public static ListNode randomeNode(int len, int maxrange) {
         Random test = new Random();
         int max = test.nextInt(maxrange);
         ListNode root = new ListNode(max);
         ListNode current = root;
         for(int i = 1; i <= len; i++) {
             current.next = new ListNode(max + 5 * i + test.nextInt(6));       
             current = current.next;
         }       
         return root;
     }
     
     public static void main(String[] args) {
         //       sol.mergeKLists(new ListNode[6]); 
//         StdOut.printf("Node Test %d\n next:", test.val);
//         StdOut.println(test.next);
         
         Random test = new Random();

         ListNode[] testlist = new ListNode[3];
         for(int i = 0; i < 3; i++) {
             testlist[i] = randomeNode(test.nextInt(2) + 1, test.nextInt(100) + 1);
             StdOut.println("Test " + i);
             printlist(testlist[i]);
         }
     }
}
