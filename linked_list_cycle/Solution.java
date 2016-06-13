package linked_list_cycle;

/**
 * Created by y1275963 on 6/13/16.
 */
import utility.ListNode;
import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> dir = new HashSet<>();
        while (head != null) {
            if (dir.contains(head))
                return true;
            else
                dir.add(head);

            head = head.next;
        }
        return false;
    }
}