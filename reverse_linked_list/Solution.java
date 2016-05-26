package reverse_linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import utility.ListNode;

public class Solution {
    private void reverse(ListNode p1, ListNode p2) {
        // from p1 -> p2 into p2 -> p1
        p1.next = null; // avoid self chain
        p2.next = p1;
    }

    private ListNode recursive(ListNode p) {
        ListNode root;
        if (p.next.next != null)
            root = recursive(p.next);
        else 
            root = p.next;

        reverse(p, p.next);
        return root;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else
            return recursive(head);

    }



    public static void main(String[] args) {
        ListNode test = ListNode.getList3();
        System.out.println(test);

        Solution sol = new Solution();
        System.out.println(sol.reverseList(test));

    }
}
