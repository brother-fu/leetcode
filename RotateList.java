/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode pre = head, post = head;
        int count = 0;
        while (head.next != null) {
            head = head.next;
            count ++;
        }
        k = k % count; 
        for (int i = 1; i <= k; i++) {
            pre = pre.next;
        }
        while (pre != null && pre.next != null) {
            pre = pre.next;
            post = post.next;
        }
        pre.next = dummy.next;
        dummy.next = post.next;
        post.next = null;
        return dummy.next;
    }
}