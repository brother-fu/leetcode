public class LRUCache {
    private class ListNode {
        int key, val;  //还是需要key的！
        ListNode pre, next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, ListNode> map;
    ListNode head, tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail; tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else {
            ListNode t = map.get(key);
            t.pre.next = t.next;
            t.next.pre = t.pre;
            moveToTail(t);
            return t.val;
        }
    }
    
    public void set(int key, int value) {
        if (get(key) != -1)
            map.get(key).val = value;
        else {
            ListNode add = new ListNode(key, value);
            map.put(key, add);
            moveToTail(add);
            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }
    }
    
    private void moveToTail(ListNode t) {
        tail.pre.next = t;
        t.pre = tail.pre;
        t.next = tail;
        tail.pre = t;
    }
}