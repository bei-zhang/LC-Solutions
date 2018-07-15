package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 545. Boundary of Binary Tree
 *
 * Solution1: One simple approach is to divide this problem into 
 *             three subproblems- left boundary, leaves and right boundary.
 *             
 */
public class BoundaryOfBinaryTree {
	//simple solution(recommended)  Time: O(n), Space: O(n)
	class Solution1 {
		public List<Integer> boundaryOfBinaryTree(TreeNode root) {
			List<Integer> res = new ArrayList<>();
			if (root == null)  return res;
			if (!isLeaf(root)) res.add(root.val);
			//1. Add Left Boundary
			TreeNode t = root.left;
			while (t != null) {
				if (!isLeaf(t)) res.add(t.val);
				t = t.left != null ? t.left : t.right;
			}
			//2. Add Leaves recursively
			addLeaves(res, root);
			
			//3. Add Right Boundary
			Stack<Integer> stack = new Stack<>();
			t = root.right;
			while (t != null) {
				if (!isLeaf(t)) stack.push(t.val);
				t = t.right != null ? t.right : t.left;
			}
			while (!stack.empty()) {
				res.add(stack.pop());
			}
			return res;
		}

		private boolean isLeaf(TreeNode t) {
			return t.left == null && t.right == null;
		}

		private void addLeaves(List<Integer> res, TreeNode root) {
			if (isLeaf(root)) {
				res.add(root.val);
			} else {
				if (root.left != null) 
					addLeaves(res, root.left);
				if (root.right != null) 
					addLeaves(res, root.right);
			}
		}
		
	}

}
