package copy_list_with_random_pointer;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashMap;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode htemp = head;
        while(htemp != null) {
            RandomListNode ntemp = htemp.next;
            htemp.next = new RandomListNode(htemp.label);
            htemp.next.next = ntemp;
            
            htemp = ntemp;           
        } 
        
//        RandomListNode tk = head;
//        while(tk != null) {
//            StdOut.printf("current %d, random %d\n", tk.label, 0);
//            tk = tk.next;
//        }
                  
        if(head != null)
            dummy.next = head.next;
        
        htemp = head;
        while(htemp != null) {
            RandomListNode h1 = htemp.next;
            StdOut.printf("htemp.random: %d htemp.random.next: %d \n", htemp.random.label, htemp.random.next.label);

            
            
            if(htemp.random != null)
                htemp.next.random = htemp.random.next;
                       
            

            
            htemp.next = htemp.next.next;
            htemp = htemp.next;

            
            if(htemp != null)
                h1.next = htemp.next;  
            else 
                h1.next = null;
            

        }

        return dummy.next;
    }
    public static void main(String[] args) {
        RandomListNode test = RandomListNode.testcase();
        StdOut.println(test);
        Solution sol = new Solution();
        RandomListNode dclone = sol.copyRandomList(test);
        StdOut.println(dclone);
    }
}
