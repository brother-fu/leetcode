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
public class AddTwoNumbers {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        int bit = 0;
        ListNode dummy = new ListNode(-1); 
        ListNode pre = dummy; //一直记录新创建的点点前面一个点
        
        while (l1 != null && l2 != null){
            bit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) /10;
            pre.next = new ListNode(bit);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) 
            l1 = l2;
        while (l1 != null){
            bit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            pre.next = new ListNode(bit);
            pre = pre.next;
            l1 = l1.next;
        }
        if (carry == 1)
            pre.next = new ListNode(1);
        return dummy.next;
    }
}
