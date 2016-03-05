package copy_list_with_random_pointer;

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

public class RandomListNode extends ListNode {
    public int label;
    public RandomListNode random;
    public RandomListNode next;

    public RandomListNode(int x) { this.label = x; }
    
    public String toString() {
        StringBuilder s = new StringBuilder();

        RandomListNode current = this;
        
        s.append("Curren: ");
        while(current.next != null) {
            s.append(current.label +" -> ");
            current = current.next;         
        }
        s.append(current.label);
        
        s.append("\nRandom: ");
        current = this;
        while(current.next != null) {
            s.append(current.random.label +" -> ");
            current = current.next;         
        }
        s.append(current.random.label);

        return s.toString();       
    }
    
    public static RandomListNode testcase() {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode p = dummy;
        
        RandomListNode[] tab = new RandomListNode[10];

        
        for(int i = 0; i < 10; i++) {          
            p.next = new RandomListNode(i);    
            p = p.next;
            tab[i] = p;
        }
        
        p = dummy.next;
        for(int i = 0; i < 10; i++) {
            int maximum = 9;
            int minimum = 0;
            Random rand = new Random();
            int randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
            
            p.random = tab[randomNum];   
            p = p.next;
        }
        

        return dummy.next;
    }



    public static void main(String[] args) {
        //       sol.mergeKLists(new ListNode[6]); 
        //         StdOut.printf("Node Test %d\n next:", test.val);
        //         StdOut.println(test.next);
        RandomListNode test = testcase();

        StdOut.println(test.next);
    }
}
