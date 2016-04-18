//尝试用BST, Merge Sort 处理，segment tree留到range query sum那里好了！
public class CountofSmallerNumbersAfterSelf  {
    private class Node {
        int val, dup, less;
        Node left, right;
        public Node(int val, int dup, int less){
            this.val = val;
            this.dup = dup;
            this.less = less;
        }
    }   
    private class ReturnType{
        private Node node;
        private int less;
        public ReturnType(Node node, int less) {
            this.node = node;
            this.less = less;
        }
    }
    private class BST{
        private Node root;
        public int put (int val) {
            ReturnType rt = put(root, val, 0);
            root = rt.node;
            return rt.less;
        }
        private ReturnType put (Node x, int val, int less) {
            if (x == null) {
                x = new Node(val, 1, 0);
                return new ReturnType(x, less);
            }
            if (x.val < val) {
                ReturnType rt = put(x.right, val, less + x.dup + x.less);
                x.right = rt.node;
                return new ReturnType(x, rt.less);  //这里的less也要从底下返回上来！！
            } else if (x.val == val) {
                x.dup++;
                return new ReturnType(x, less + x.less);
            } else {
                x.less++;
                ReturnType rt = put(x.left, val, less);
                x.left = rt.node;
                return new ReturnType(x, rt.less);
            }
        }
    }
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> ans = new ArrayList();
        BST bst = new BST();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(0, bst.put(nums[i]));
        }
        return ans;
    }
    
    
    
    //Merge Sort的思路尝试下
    private class Point {
        int num, idx;
        public Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList();
        Map<Integer, Integer> map = new HashMap();
        int len = nums.length;
        Point[] points = new Point[len];
        for (int i = 0; i < len; i++) {
            points[i] = new Point(nums[i], i);
            map.put(i, 0);
        }
        sort (points, map, 0, len - 1);
        for (int i = 0; i < len; i++)
            ans.add(map.get(i));
        return ans;
    }
    private void sort(Point[] points, Map<Integer, Integer> map, int s, int f) {
        if (s >= f) return;
        int mid = s + (f - s) / 2;
        sort(points, map, s, mid);
        sort(points, map, mid + 1, f);
        merge(points, map, s, mid, f);
    }
    private void merge(Point[] points, Map<Integer, Integer> map, int s, int mid, int f) {
        Point[] aux = new Point[points.length];
        for (int i = s; i <= f; i++) {
            aux[i] = points[i];
            //System.out.println("i: " + i + "  aux[i]: " + aux[i].num);
        }
        int t = s, k = mid + 1;
        for (int i = s; i <= f; i++) {
            if (t > mid) {points[i] = aux[k++]; }
            else if (k > f)  { points[i] = aux[t++]; map.put(aux[t - 1].idx, map.get(aux[t - 1].idx) + i - t + 1);}
            else if (aux[t].num <= aux[k].num) {points[i] = aux[t++]; map.put(aux[t - 1].idx, map.get(aux[t - 1].idx) + i - t + 1);}
            else {points[i] = aux[k++]; }
        }
    }

}