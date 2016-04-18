/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)   
            return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode tail = getKth(pre, k);
        while (tail != null) {
            ListNode prex = pre.next;
            ListNode cache = prex;
            ListNode x = prex.next;
            pre.next = tail.next;
            for (int i = 1; i < k; i++) {
                ListNode tmp = x.next;
                x.next = prex;
                prex = x;
                x = tmp;
            }
            cache.next = pre.next;
            pre.next = prex;
            pre = cache;
            tail = getKth(pre, k);
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode p, int k) {
        while (p != null && k > 0){
            p = p.next;
            k--;
        }
        return p;
    }
}