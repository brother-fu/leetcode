/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/


public class PopulatingNextRightPointersinEachNodeII {
    public void connect1(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.left != null) {
            root.left.next = root.right != null 
                             ? root.right 
                             : getNext(root);
        }
        if (root.right != null)
            root.right.next = getNext(root);
        connect(root.right);
        connect(root.left);
    }
    private TreeLinkNode getNext(TreeLinkNode root) {
        root = root.next;
        while (root != null && root.left == null && root.right == null)  {
            root = root.next;
        }
        if (root == null) return null;
        if (root.left != null) return root.left;
        return root.right;
    }
}