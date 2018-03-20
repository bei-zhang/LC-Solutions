package dataStructure.Tree.BinaryTree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * https://leetcode.com/problems/same-tree
 * http://www.lintcode.com/en/problem/identical-binary-tree/
 * http://www.cnblogs.com/grandyang/p/4053384.html
 * 
 * Similar question: Subtree
 */
public class SameTree {

	// 判断两棵树是否相同和之前的判断两棵树是否对称都是一样的原理，利用深度优先搜索DFS来递归,代码如下：
	// recursion solution (pre-order traverse both tree)
	public class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if (p == null && q == null)
				return true;
			if ((p == null && q != null) || (p != null && q == null))
				return false;
			if (p.val != q.val)
				return false;
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

	// 这道题还有非递归的解法，因为二叉树的四种遍历(层序，先序，中序，后序)均有各自的迭代和递归的写法，这里我们先来看先序的迭代写法，
	//相当于同时遍历两个数，然后每个节点都进行比较，参见代码如下：
	

	public static void main(String[] args) {

	}

}
