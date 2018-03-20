package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 *
 */
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
        	return result;
        
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
    
    
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.val = data;
		}

	}

	public static void main(String[] args) {

	}

}
