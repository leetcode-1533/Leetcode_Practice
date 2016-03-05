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
        RandomListNode p = dummy;
        
        RandomListNode thead = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(head != null) {
            p.next = new RandomListNode(head.label);
            map.put(head, p.next);
            p = p.next;
            head = head.next;
        }
        
        head = thead;
        p = dummy.next;
        while(head != null) {
            p.random = map.get(head.random);
            head = head.next;
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
