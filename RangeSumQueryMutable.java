/*45 - 10基本没错，一次搞定！*/ 
public class RangeSumQueryMutable {
    /*用segment tree 实现*/
    private class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private class SegmentTree {
        private SegmentTreeNode root;
        public SegmentTree (int[] nums) {
            if (nums == null || nums.length == 0)
                return;
            root = build(nums, 0, nums.length - 1);
        }
        private SegmentTreeNode build(int[] nums, int start, int end) {
            SegmentTreeNode x = new SegmentTreeNode(start, end);
            if (start == end) {
                x.sum = nums[start];
                return x;
            }
            int mid = start + (end - start) / 2;
            x.left = build(nums, start, mid);
            x.right = build(nums, mid + 1, end);
            x.sum = x.left.sum + x.right.sum;
            return x;
        }
        public void update (int i, int val) {
            update (root, i, val);
        }
        private void update (SegmentTreeNode x, int idx, int val) {
            if (x.start == idx && x.end == idx) {
                x.sum = val;
                return;
            }
            int mid = x.start + (x.end - x.start) / 2;
            if (idx <= mid) update(x.left, idx, val);
            else update (x.right, idx, val);
            x.sum = x.left.sum + x.right.sum;
        }
        public int query(int qstart, int qend) {
            return query(root, qstart, qend);
        }
        private int query(SegmentTreeNode x, int qstart, int qend) {
            if (qstart <= x.start && qend >= x.end) 
                return x.sum;
            if (qstart > x.end || qend < x.start)
                return 0;
            return query(x.left, qstart, qend) + query(x.right, qstart, qend);
        }
    }
    private SegmentTree tree = null;
    public NumArray(int[] nums) {
        tree = new SegmentTree(nums);
    }

    void update(int i, int val) {
        tree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return tree.query(i, j);
    }
}
