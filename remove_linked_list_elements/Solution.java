package remove_linked_list_elements;
import edu.princeton.cs.algs4.StdOut;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head !=null && head.val == val) 
            head = head.next;
        
        ListNode root = head;
        
        while(  root != null) {
        if(root.next != null && root.next.val == val) {
            root.next = root.next.next;                  
        } else {
            root = root.next;
        }
        }
        return head;       
    }
//    ListNode temp = node.next;
//    node.val = temp.val;
//    node.next = temp.next;    
    public void iterdel(ListNode root, int val) {

    }
    
    public static void main(String[] args) {
        ListNode test = ListNode.randomeNode(10, 4 );
        StdOut.println(test);
        Solution sol = new Solution();
        test = sol.removeElements(test, 1);
        StdOut.println(test);

    }

}
