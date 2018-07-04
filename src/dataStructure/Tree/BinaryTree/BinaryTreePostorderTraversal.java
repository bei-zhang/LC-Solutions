package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Post-Order: Left Child, Right child, Root
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * https://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
 * http://www.jiuzhang.com/solutions/binary-tree-postorder-traversal/
 * Difficulty:Hard  (LeetCode)
 * 
 */
public class BinaryTreePostorderTraversal {
	
// ------------below is recursion solution-------------------------------------------------------
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<Integer>();
        helper(root, postorder);
        return postorder;
    }
    private void helper(TreeNode root, List<Integer> postorder){
        if (root == null) return;
		helper(root.left, postorder);
		helper(root.right,postorder);
		postorder.add(root.val);
    }

/////////////Iterative solution from program creek   ////////////////
	//Best solution so far
	class IterativeSolution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> res = new ArrayList<Integer>();
			if (root == null) {
				return res;
			}

			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode temp = stack.peek();
				if (temp.left == null && temp.right == null) {
					TreeNode pop = stack.pop();
					res.add(pop.val);
				} else {
					if (temp.right != null) {
						stack.push(temp.right);
						temp.right = null;
					}

					if (temp.left != null) {
						stack.push(temp.left);
						temp.left = null;
					}
				}
			}

			return res;
		}
	}

//------------below is second Iterative solution from jiuzhang-------------------------------------------------------	    
	    
//	Any recursive algorithm can be replaced with a non-recursive algorithm by using a Stack.   
	// Iterative  solution 
	public ArrayList<Integer> postorderTraversalWithIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null; // previously traversed node
		TreeNode curr = root;
		if(root == null){
			return result;
		}
		
		stack.push(root);
		while(!stack.isEmpty()){
			curr = stack.peek();
			if(prev ==null || prev.left == curr || prev.right == curr ){// traverse down the tree
				if(curr.left != null){
					stack.push(curr.left);
				}else if (curr.right !=null){
					stack.push(curr.right);
				}
			}else if (curr.left == prev){ // traverse up the tree from the left
				if(curr.right!=null){
					stack.push(curr.right);
				}
			}else{ // traverse up the tree from the right
				result.add(curr.val);
				stack.pop();
			}
			
			prev = curr;
			
		}

		return result;
	}
	    
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			BinaryTreePostorderTraversal postOrderTraversal=new BinaryTreePostorderTraversal();
			TreeNode root=new TreeNode(8);
			TreeNode node1=new TreeNode(3);
			TreeNode node2=new TreeNode(12);
			TreeNode node3=new TreeNode(1);
			TreeNode node4=new TreeNode(7);
			TreeNode node5=new TreeNode(10);
			root.left=node1; root.right=node2;
			node1.left=node3; node1.right=node4;
			node2.left=node5;
			
			List<Integer> result=postOrderTraversal.postorderTraversalWithIterative(root);
			System.out.println(result.toString());
			

		}
		


}
