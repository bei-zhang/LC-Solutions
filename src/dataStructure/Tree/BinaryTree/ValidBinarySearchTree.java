package dataStructure.Tree.BinaryTree;

import common.TreeNode;

/**
 * 
 * 
 * http://www.lintcode.com/en/problem/validate-binary-search-tree/
 * https://www.jiuzhang.com/solutions/validate-binary-search-tree/
 * http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 * 
*/

public class ValidBinarySearchTree {
	
	/**
	 *http://www.cnblogs.com/yuzhangcmu/p/4177047.html
	 *我们可以设置上下bound，递归左右子树时，为它们设置最大值，最小值，并且不可以超过。
	     注意：下一层递归时，需要把本层的up 或是down继续传递下去。相当巧妙的算法。
	     
	 Time Complexity: O(n)
	 Auxiliary Space : O(1) if Function Call Stack size is not considered, otherwise O(n)
	 */
	class Solution1 {
		/**
		 * 
	     * @param root: The root of binary tree.
	     * @return: True if the binary tree is BST, or false
	     */
	    public boolean isValidBST(TreeNode root) {
	       if(root == null)  return false; //Ask interviewer: No need this line if we consider NULL is BST. 
	       return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
	    private boolean helper(TreeNode node , long low, long high){
	    	//递归退出条件不能少，必须return true, 这里不是指整个树的根节点是否为null
	    	//This means you reach the end of left subtree or right subtree
	        if(node == null){ 
	            return true;
	        }
	        
	        //false if this node violates the upper/lower limit constraints 
	        if(node.val<= low || node.val >= high){
	            return false;
	        }
	        //otherwise check the subtrees recursively and update upper/lower limit boundary
	        return helper(node.left,low,node.val) && helper(node.right, node.val, high);
	    }

	}

	
}
