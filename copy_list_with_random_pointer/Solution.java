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
        
        RandomListNode p = dummy;  
        
        htemp = head;
        while(htemp != null) {            
            if(htemp.random != null)
                htemp.next.random = htemp.random.next;
            htemp = htemp.next.next;
        }
        
        htemp = head;
        while(htemp != null) {
            RandomListNode temp = htemp.next.next;
            
            p.next = htemp.next;      
            htemp.next = temp;
            
            htemp = htemp.next;
            p = p.next;          
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
