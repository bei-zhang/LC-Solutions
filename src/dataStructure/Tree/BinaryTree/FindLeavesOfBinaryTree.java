package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 * http://blog.csdn.net/jmspan/article/details/51760985
 * http://www.programcreek.com/2014/07/leetcode-find-leaves-of-binary-tree-java/
 *
 */
public class FindLeavesOfBinaryTree {

	//DFS solution  思路：先检查最大深度，再根据节点所处的深度放进结果。
	//The key to solve this problem is
	// converting the problem to be finding the index of the element in the result list. 
	//Then this is a typical DFS problem on trees.
	public class Solution {
		public List<List<Integer>> findLeaves(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			helper(result, root);
			return result;
		}
		// traverse the tree bottom-up recursively
		private int helper(List<List<Integer>> list, TreeNode root) {
			if (root == null) return -1;
			int left = helper(list, root.left);
			int right = helper(list, root.right);
			int curr = Math.max(left, right) + 1;
			// the first time this code is reached is when curr==0,
			// since the tree is bottom-up processed.
			if (list.size() <= curr) {
				list.add(new ArrayList<Integer>());
			}
			list.get(curr).add(root.val);
			return curr;
		}
	}

	public static void main(String[] args) {

	}

}
