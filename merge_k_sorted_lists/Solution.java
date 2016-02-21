package merge_k_sorted_lists;
import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
       ListNode test = merge(lists, 0, 1);
       StdOut.println("Test merge");
//       while(lists.length != 1) {
//           ListNode[] temp = new ListNode[lists.length / 2];
//           for(int i = 0; i * 2 < lists.length; i++) {
////               StdOut.println("I * 2: " + i * 2 + " next: " + (i * 2 + 1));  
//               temp[i] = merge(lists, i * 2, i * 2 + 1);
//           }
//           lists = temp;
//       }    
       return test;
   }
   
   private static ListNode merge(ListNode[] lists, int start, int end) {
       ListNode listart = lists[start];
       ListNode liend = lists[end];
       
       if(listart.val < liend.val) { 
           // listart should be the larger one
           ListNode temp = listart;
           listart = liend;
           liend = temp;
       }
       ListNode root = listart;
       
       int i = 0;
       while(liend != null) {
           i++;
           StdOut.printf("ROOT Step %dth: \n", i);
           printlist(root);
           
           StdOut.printf("listart Step %dth: \n", i);
           printlist(listart);
           
           StdOut.printf("liend Step %dth: \n", i);
           printlist(liend);
           
           if(listart.next == null) {
               listart.next = liend;
               return root;
           }          
           
           if(listart.next.val <= liend.val) {
               ListNode liendnext = liend.next;
               insert(listart, liend);
               liend = liendnext;       
               listart = listart.next;
           } else {
               listart = listart.next;
           }
       }     
       return root;       
   }
   
   private static void insert(ListNode hold, ListNode join) {
       ListNode temp = hold.next;
       hold.next = join;
       join.next = temp;
   }
   
   private static void printlist(ListNode pri) {
       while(pri != null) {
           StdOut.printf("val %d \n", pri.val);
           pri = pri.next;        
       }
   }
   
   private static ListNode randomeNode(int len, int maxrange) {
       Random test = new Random();
       int max = test.nextInt(maxrange);
       ListNode root = new ListNode(max);
       ListNode current = root;
       for(int i = 1; i <= len; i++) {
           current.next = new ListNode(max - 5 * i + test.nextInt(6));       
           current = current.next;
       }       
       return root;
   }
   
   public static void main(String[] args) {
//       sol.mergeKLists(new ListNode[6]); 
//       StdOut.printf("Node Test %d\n next:", test.val);
//       StdOut.println(test.next);
       
       Solution sol = new Solution();
       Random test = new Random();

       ListNode[] testlist = new ListNode[5];
       for(int i = 0; i < 5; i++) {
           testlist[i] = randomeNode(test.nextInt(4) + 1, test.nextInt(100) + 1);
       }
       ListNode iter = testlist[0];
       while(iter != null) {
           StdOut.printf("val %d \n", iter.val);
           iter = iter.next;
       }
       StdOut.println("List 1");
       iter = testlist[1];
       while(iter != null) {
           StdOut.printf("val %d \n", iter.val);
           iter = iter.next;
       }
       iter = sol.mergeKLists(testlist);
       StdOut.println("linked");
       while(iter != null) {
           StdOut.printf("val %d \n", iter.val);
           iter = iter.next;
       }
   }
}
