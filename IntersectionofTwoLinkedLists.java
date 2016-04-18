/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cur = headA;
        while (cur.next != null)
           cur = cur.next;
        cur.next = headA;
        //find intersection in a link;
        ListNode slow = headB;
        ListNode fast = slow.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
               break;
        }
        if (fast == null || fast.next == null) {
            cur.next = null; 
            return null;
        }
        while(slow.next != headB) {
            slow = slow.next;
            headB = headB.next;
        }
        
        cur.next = null; //改变的结构改回去！
        return headB;
        
        
    }
}