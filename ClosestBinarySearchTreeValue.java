/*
问题描述
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int ret = 0; 
        double dist = Double.MAX_VALUE;
        while (root != null) {
            if (root.val < target) {
                if (target - root.val < dist) {
                    dist = target - root.val;
                    ret = root.val;
                }
                root = root.right;
            } else if (root.val > target) {
                if (root.val - target < dist) {
                    dist = root.val - target;
                    ret = root.val;
                }
                root = root.left;
            } else {
                ret = root.val;
                break;
            }
        }
        return ret;
    }
}