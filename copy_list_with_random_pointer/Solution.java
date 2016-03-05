package copy_list_with_random_pointer;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdOut;

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
        ArrayList<Integer> litable = new ArrayList<Integer>();
        ArrayList<RandomListNode> objtable = new ArrayList<RandomListNode>();
        RandomListNode htemp = head;
        while(head != null) {
            p.next = new RandomListNode(head.label);           
            litable.add(head.random.label);
            objtable.add(p.next);
            
            head = head.next;
            p = p.next;           
        }
        p = dummy.next;
        while(p != null) {
            int index = litable.indexOf(htemp.random.label);
//            StdOut.printf("Label: %d, Index: %d\n", htemp.random.label, index);
            p.random = objtable.get(htemp.random.label);
            p = p.next;
            htemp = htemp.next;
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
