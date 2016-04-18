/**
 * Definition for singly-linked list with a random pointer.
 * class CopyListwithRandomPointer {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> map = new HashMap();
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            map.put(cur, copy);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            RandomListNode copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}