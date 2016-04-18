/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        head = pre;
        for (int i = 0; i < n + 1; i++)
            head = head.next;
        while (head != null) {
            pre = pre.next;
            head = head.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}