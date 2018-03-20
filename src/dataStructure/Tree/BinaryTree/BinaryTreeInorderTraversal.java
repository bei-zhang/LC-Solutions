package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * http://www.jiuzhang.com/solutions/binary-tree-inorder-traversal/
 * 
 * in-order traversal:  Left child, root, Right child.
 *
 */

public class BinaryTreeInorderTraversal {
	
    //------------below is Iterative solution-------------------------------------------------------	    
    // non-recursion solution- recommended.
	public ArrayList<Integer> iterativeInorder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode curr = root;
		while (!stack.empty() || curr != null) {
			//1. add left node to stack until reaching the leftmost node
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			//2.pop up a node from stack and then checking its right node.
			curr = stack.pop();
			result.add(curr.val);
			curr = curr.right;
		}

		return result;
	}
	
	 
	 //------------below is recursion solution-------------------------------------------------------	    
	class RecursiveSolution {
	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> inOrder = new ArrayList<Integer>();
	        helper(root, inOrder);
	        return inOrder;
	    }
	    private void helper(TreeNode root, List<Integer> inOrder){
	        if (root == null)
				return;
			helper(root.left, inOrder);
			inOrder.add(root.val);
			helper(root.right,inOrder);
	    }
	}
	
	//------------ second recursion solution using Divide & Conquer ---------
	public ArrayList<Integer> recursiveInorder2(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<> ();
		if(root == null){
			return result;
		}
		//Divide & Conquer
		ArrayList<Integer> left = recursiveInorder2(root.left);
		ArrayList<Integer> right = recursiveInorder2(root.right);
		
		//Combine left and right sub-results.
		result.addAll(left);
		result.add(root.val);
		result.addAll(right);
		
		return result;
	}
	
	
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeInorderTraversal inOrderTraversal=new BinaryTreeInorderTraversal();
		TreeNode root=new TreeNode(8);
		TreeNode node1=new TreeNode(3);
		TreeNode node2=new TreeNode(12);
		TreeNode node3=new TreeNode(1);
		TreeNode node4=new TreeNode(7);
		TreeNode node5=new TreeNode(10);
		root.left=node1; root.right=node2;
		node1.left=node3; node1.right=node4;
		node2.left=node5;
		
		List<Integer> result=inOrderTraversal.iterativeInorder(root);
		System.out.println("Iterative Result:"+result.toString());
		
		

	}
	


}


class TreeNode {
	 int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.val = data;
	}

}
