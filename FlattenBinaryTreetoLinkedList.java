/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreetoLinkedList  {
    /*尝试下三种方法来解题,给出preorder的效果*/
    /*
    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) { return; }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
    */
    
    /*Morris Traversal*/
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                TreeNode tmp = root.right;
                root.right = pre;
                root.left = null;
                while (pre.right != null)
                    pre = pre.right;
                pre.right = tmp;
            }
            root = root.right;
        }
    }
    
}