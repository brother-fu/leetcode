/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    /*
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode pre = null;
        while (!stack.empty()) {
            TreeNode now = stack.pop();
            if (pre != null && now.val <= pre.val)
                return false;
            pre = now;
            if (now.right != null) {
                now = now.right;
                while (now != null) {
                    stack.push(now);
                    now = now.left;
                }
            }
        }
        return true;
    }
    */
    
    
    /*用inorder 减少传入参数*/
    TreeNode invalidNode = new TreeNode(Integer.MAX_VALUE);
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null) != invalidNode;
    }
    public TreeNode isValidBST(TreeNode node, TreeNode prev) {
        if( node == null ) return prev;
        prev = isValidBST(node.left, prev);
        if( prev != null && node.val <= prev.val ) return invalidNode;
        return isValidBST(node.right, node);
    }
}