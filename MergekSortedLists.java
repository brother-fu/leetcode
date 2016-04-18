/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)   
            return null;
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) 
            return lists[begin];
        int mid = begin + (end - begin) / 2;
        return merge(helper(lists, begin, mid), helper(lists, mid + 1, end));
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
               pre.next = l1;
               l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}