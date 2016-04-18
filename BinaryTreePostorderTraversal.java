/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        Set<TreeNode> seen = new HashSet();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.empty()) {
            TreeNode now = stack.pop();
            if (now.right != null) {
                if (seen.add(now)) {
                    stack.push(now);
                    TreeNode cur = now.right;
                    while (cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    }
                } else {
                    ans.add(now.val);
                }
            } else {
                ans.add(now.val);
            }
        }
        return ans;
    }
}