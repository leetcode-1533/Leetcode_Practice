package merge_k_sorted_lists;
import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length == 0) {
           return null;
       }
       
       while(lists.length != 1) {
           ListNode[] temp;
           
           if((lists.length % 2) == 0) 
               temp = new ListNode[lists.length / 2];
           else 
               temp = new ListNode[lists.length / 2 + 1];
           
           for(int i = 0; i * 2 < lists.length; i++) {
//               StdOut.println("I * 2: " + i * 2 + " next: " + (i * 2 + 1));  
               temp[i] = merge(lists, i * 2, i * 2 + 1);
           }
           lists = temp;
       }    
       return lists[0];
   }
   
   private static ListNode merge(ListNode[] lists, int start, int end) {
       ListNode listart = lists[start];
       ListNode liend;

       if(end == lists.length) {
           return listart;
       } else {
           liend = lists[end];      
       }
       
       if(listart == null) {
           return liend;
       } else if (liend == null) {
           return listart;
       } 
       
       if(listart.val < liend.val) { 
           // listart should be the larger one
           ListNode temp = listart;
           listart = liend;
           liend = temp;
       }
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
   

//   
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

   private static void printlist(ListNode pri) {
       while(pri != null) {
           StdOut.printf("val %d \n", pri.val);
           pri = pri.next;        
       }
   }

   public static void main(String[] args) {
       //       sol.mergeKLists(new ListNode[6]); 
//       StdOut.printf("Node Test %d\n next:", test.val);
//       StdOut.println(test.next);
       
       Solution sol = new Solution();
       Random test = new Random();

//       ListNode[] testlist = new ListNode[3];
//       for(int i = 0; i < 3; i++) {
//           testlist[i] = randomeNode(test.nextInt(2) + 1, test.nextInt(100) + 1);
//           StdOut.println("Test " + i);
//           printlist(testlist[i]);
//       }
//       StdOut.println("Merge Result");
//       ListNode tk = sol.mergeKLists(testlist);
//       printlist(tk);
   }
}
