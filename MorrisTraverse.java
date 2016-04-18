import java.io.*;
import java.util.*;
//http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
/*
*  基本思路是: 
*  1. 如果左子树为null,直接打印出来, move to cur -> right
*  2. 如果左子数不为null, 把cur点连接为左子树最大值的right node;
*  3. MorrisTravese的优点是你traverse 之后竟然还能够把树还原
*        还原的关键是判断什么时候是把rightmost -> current, 把链接修复回去！
*  4. 实现关键： 一个pre指针，一个current指针；
*/
public class MorrisTraverse {
	private static class Node {
		int val;
		Node left, right;
		public Node (int val) {
			this.val = val;
		}
	}
	public void morristraverse(Node root) {
        Node cur = root;
        Node pre = null;
        while (cur != null) { // 循环；
        	if (cur.left == null) {
        		System.out.println(cur.val);
        		cur = cur.right;
        	} else { /*find the right most and link it */
        		pre = cur.left;
        		while (pre.right != null && pre.right != cur) /*pre.right != cur 是关键！！！！！！， 这里用于修复*/
                     pre = pre.right;
                if (pre.right == null) {
                	// not linking yet, link it;
                	pre.right = cur;
                	cur = cur.left;
                } else {
                	// restore the tree;
                	System.out.println(cur.val); //------>这里也有print;
                	pre.right = null; // restore
                	cur = cur.right;
                }
        	}
        }
	}

	public static void main(String[] args) {
		MorrisTraverse test = new MorrisTraverse();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		test.morristraverse(root);
	}
}