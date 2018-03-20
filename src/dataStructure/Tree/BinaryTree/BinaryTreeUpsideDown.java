package dataStructure.Tree.BinaryTree;

import java.util.Stack;

/**
 * Given a binary tree where all the right nodes are 
 * either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
 * Return the new root.
 * 
 * https://leetcode.com/problems/binary-tree-upside-down/
 * http://blog.csdn.net/whuwangyi/article/details/43186045
 * 
 *
 */
public class BinaryTreeUpsideDown {

	//Recommended solution
	//Optimized solution (iterative): only one while loop and no extra space
	//Time O(n), Space O(1)
	public class Solution2 {
	    public TreeNode upsideDownBinaryTree(TreeNode root) {
		    TreeNode node = root, parent = null, right = null;  
		    while (node != null) {//类似swap 
		        TreeNode left = node.left;  
		        node.left = right;  
		        right = node.right;  
		        node.right = parent;  
		        parent = node;  
		        node = left;  
		    }  
		    return parent; 
	    }
	}
	
///////////////////////////////////////////////////////////////////////////////////
	//自己独立思考的solution (iterative), 用了2次while loop和 extra O(n) space: Stack
	//Time O(n), Space O(n) 可以optimize, see optimized solution#2 below
	public class Solution1 {
	    public TreeNode upsideDownBinaryTree(TreeNode root) {
	        if(root == null)
	            return root;
	        Stack<TreeNode> stack = new Stack<>(); // save all left nodes
	        TreeNode p = root;
	        while(p != null){
	            stack.push(p);
	            p = p.left;
	        }
	        TreeNode newRoot = stack.pop();
	        TreeNode newP = newRoot;
	        while(!stack.isEmpty()){
	            TreeNode nextNode = stack.pop();
	            newP.left = nextNode.right;
	            newP.right = nextNode;
	            newP = nextNode;
	        }
	        newP.left = null;
	        newP.right = null;
	        
	        return newRoot;
	    }
	}


//////////////////////////////////////////////////////////////////////////////////////////////////////
	//recursive solution: Not recommended 效率没non-recursion 高， 可能StackOverflow  
	public class Solution3 {
	    public TreeNode upsideDownBinaryTree(TreeNode root) {
	        if (root == null)  
	            return null;  
	        TreeNode parent = root, left = root.left, right = root.right;  
	        if (left != null) {  
	            TreeNode ret = upsideDownBinaryTree(left);  
	            left.left = right;  
	            left.right = parent;  
	            return ret;  
	        }  
	        return root; 
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
