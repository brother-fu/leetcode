/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountUnivalueSubtrees {
    private class ReturnType{
        boolean isUnique;
        int val;
        int count;
        public ReturnType(boolean isUnique, int val, int count) {
            this.isUnique = isUnique;
            this.val = val;
            this.count = count;
        }
    }
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        return helper(root).count;
    }
    
    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return null;
        }    
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        if (left == null && right == null) 
            return new ReturnType(true, root.val, 1);
        else if (left == null) {
            if (!right.isUnique)  /*这里别忘记了*/
               return right;
            if (right.val == root.val){
                return new ReturnType(true, root.val, right.count + 1);
            } else {
                return new ReturnType(false, root.val, right.count);
            }
        } else if (right == null) {
            if (!left.isUnique)
                return left;
            if (left.val == root.val){
                return new ReturnType(true, root.val, left.count + 1);
            }  else {
                return new ReturnType(false, root.val, left.count);
            }
        } else {
            if (left.isUnique && right.isUnique && left.val == root.val && right.val == root.val) {
                return new ReturnType(true, root.val, left.count + right.count + 1);
            }
            return new ReturnType(false, root.val, left.count + right.count);
        }
    }
}