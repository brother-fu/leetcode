public class ZigzagIterator {
    LinkedList<Iterator<Integer>> lists;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new LinkedList();
        if (v1.size() > 0)
            lists.offer(v1.iterator());
        if (v2.size() > 0)
        lists.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> it = lists.poll();
        int ret = it.next();
        if (it.hasNext())
            lists.offer(it);
        return ret;
    }

    public boolean hasNext() {
        return lists.size() != 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */