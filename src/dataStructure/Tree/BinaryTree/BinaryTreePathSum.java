package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 * A valid path is from root node to any of the leaf nodes.
 * 
 * http://www.lintcode.com/en/problem/binary-tree-path-sum/
 * 
 *
 */
public class BinaryTreePathSum {

    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null){
    		return result;
    	}
    	List<Integer> path = new ArrayList<>();
    	path.add(root.val);
    	helper(root, path, root.val, target, result);
    	return result;
    }
    

    private void helper(TreeNode root, List<Integer> path, int sum, int target, List<List<Integer>> result){
        
    	//leaf 
    	if(root.left == null && root.right == null){
    		if(sum == target){
    		    result.add(new ArrayList<Integer>(path));
    		}
    		return;
    	}
    	
    	// go left
    	if(root.left !=null){
    		path.add(root.left.val);
    		//sum += root.left.val;
    		helper(root.left, path, sum + root.left.val, target, result );
    		path.remove(path.size() - 1); // important step to go back to previous node
    	}
    	
    	//go right
    	if(root.right !=null){
    		path.add(root.right.val);
    	//	sum += root.right.val;
    		helper(root.right, path, sum + root.right.val, target, result);
    		path.remove(path.size() - 1);  
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
    
    
	public static void main(String[] args) {

	}

}
