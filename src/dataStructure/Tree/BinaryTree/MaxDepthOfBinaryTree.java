package dataStructure.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 */
public class MaxDepthOfBinaryTree {

	//Recursive solution
	class Solution {
	    public int maxDepth(TreeNode root) {
	        if(root == null) return 0;
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        return Math.max(left, right) + 1;
	    }

	}
	
	
////////////////////////////////////
	//iterative solution with BFS
	class IterativeSolution{
		public int maxDepth(TreeNode root) {
		    if(root == null) {
		        return 0;
		    }
		    Queue<TreeNode> queue = new LinkedList<>();
		    queue.offer(root);
		    int count = 0;
		    while(!queue.isEmpty()) {
		        int size = queue.size();
		        while(size-- > 0) {
		            TreeNode node = queue.poll();
		            if(node.left != null) {
		                queue.offer(node.left);
		            }
		            if(node.right != null) {
		                queue.offer(node.right);
		            }
		        }
		        count++;
		    }
		    return count;
		}
	}
	
}
