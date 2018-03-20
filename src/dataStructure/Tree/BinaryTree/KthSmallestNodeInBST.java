package dataStructure.Tree.BinaryTree;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?

 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 *
 */
public class KthSmallestNodeInBST {
	//In-order traversal - iterative solution
	class Solution1 {
		public int kthSmallest(TreeNode root, int k) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode p = root;
			//1. add left node to stack until reaching the leftmost node 
			while(p!=null){
				stack.push(p);
				p = p.left; 
			}
			
			//2. pop up a node from stack and then checking its right node.
			while(!stack.isEmpty()){
				TreeNode t = stack.pop();
				k--;
				if(k == 0) return t.val;
				
				TreeNode right = t.right;
				while(right!=null){
					stack.push(right);
					right = right.left;
				}
			}
			
			return -1;
		}
	}
	
	//Binary Search (DFS)
	class Solution2 {
		public int kthSmallest(TreeNode root, int k) {
			int count = countNodes(root.left);
			if (k <= count) {
				return kthSmallest(root.left, k);
			} else if (k > count + 1) {
				return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
			}

			return root.val;
		}

		public int countNodes(TreeNode n) {
			if (n == null) return 0;
			return 1 + countNodes(n.left) + countNodes(n.right);
		}
	}
	

	    
	
}
