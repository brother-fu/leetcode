/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int l = getDepth(root, true);
        int r = getDepth(root, false);
        if (l == r) 
            return (1 << l) - 1; /*是左移不是右移*/
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
        
    }
    private int getDepth(TreeNode x, boolean isLeft) {
        int depth = 0;
        if (isLeft) {
            while (x != null) {
                x = x.left;
                depth++;
            } 
        } else {
            while (x != null) {
                x = x.right;
                depth++;
            }
        }
        return depth;
    }
}