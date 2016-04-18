/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    //try with both bfs and divide and conquer;
    
    /*bfs*/
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (queue.size() != 0) {
            List<TreeNode> list = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                if (now != null) {
                    list.add(now.left);
                    list.add(now.right);
                }
            }
            if (isLevelSymmetric(list))
                queue.addAll(list);
            else return false;
        }
        return true;
    }
    private boolean isLevelSymmetric(List<TreeNode> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            TreeNode pre = list.get(i);
            TreeNode post = list.get(j);
            if ((pre == null && post == null) || (pre != null && post != null && pre.val == post.val)) {
                i++; j--;
            } 
            else break;
        }
        return i >= j;
    }
    
    
    /*dfs  divide and conquer*/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
        
    }
}