/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class  LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != slow) 
            return null;
        ListNode cur = head;
        while (slow.next != cur) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}


/*5*/