package dataStructure.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 *  * Leetcode 226
 * "Google: 90% of our engineers use the software you wrote (Homebrew), but you cannot invert a binary tree on a whiteboard so fuck off."
 * Invert A Binary Tree  (i.e.  Reverse A Binary Tree (Left to Right))
 *
 * https://leetcode.com/problems/invert-binary-tree/
 * http://www.lintcode.com/en/problem/invert-binary-tree/
 * http://www.programcreek.com/2014/06/leetcode-invert-binary-tree-java/
 * 
 *
 */
public class InvertBinaryTree {

	//独立思考出的 Recursive solution (Recommended)
	public class Solution {
	    public TreeNode invertTree(TreeNode root) {
            if(root == null) return root;
            
            //recursive call to invert left/right subtrees
            invertTree(root.left);
            invertTree(root.right);
            
            //swap left and right children
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            
            return root;
	    }
	   
	}
	
/////////////////////////////////////////////////////////////////////////////
	//Iterative solution with BFS algorithm
	public class Solution2 {
		public TreeNode invertTree(TreeNode root) {
			Queue<TreeNode> queue = new LinkedList<>();
			if (root != null) 
				queue.add(root);

			TreeNode p = null;
			while (!queue.isEmpty()) {//BFS algorithm: level order traversal
				p = queue.poll();
				if (p.left != null)
					queue.add(p.left);
				if (p.right != null)
					queue.add(p.right);

				TreeNode temp = p.left;
				p.left = p.right;
				p.right = temp;
			}

			return root;
		}

	}
	
}
