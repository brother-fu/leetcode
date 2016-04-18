/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode post = pre.next.next.next;
            ListNode tmp = pre.next;
            pre.next = tmp.next;
            tmp.next = post;
            pre.next.next = tmp;
            pre = tmp;
        }
        return dummy.next;
    }
}