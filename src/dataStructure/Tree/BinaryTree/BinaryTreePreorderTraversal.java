package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 *
 */
public class BinaryTreePreorderTraversal {
	
    //------------below is Iterative solution-------------------------------------------------------	    
    // non-recursion solution- recommended.
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
        	result.add(node.val);
        	if(node.right!=null){
        		stack.push(node.right);
        	}
        	if(node.left !=null){
        		stack.push(node.left);
        	}
        }
        
        return result;
        
    }

	//------------below is recursion solution-------------------------------------------------------	    
	class RecursiveSolution {
	    public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> preOrder = new ArrayList<Integer>();
	        helper(root, preOrder);
	        return preOrder;
	    }
	    private void helper(TreeNode root, List<Integer> preOrder){
	        if (root == null) return;
	        preOrder.add(root.val);
			helper(root.left, preOrder);
			helper(root.right,preOrder);
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
