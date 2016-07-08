package linked_list_cycle_ii;

import utility.ListNode;

/**
 * Created by y1275963 on 7/8/16.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode haar = head;
        ListNode tortoise = head;
        while (haar != null) {
            if (haar.next == null)
                return null;
            else {
                haar = haar.next.next;
                tortoise = tortoise.next;
                if (haar == tortoise) {
                    while (head != tortoise) {
                        head = head.next;
                        tortoise = tortoise.next;
                    }
                    return head;
                }
            }
        }
        return null;
    }
}
