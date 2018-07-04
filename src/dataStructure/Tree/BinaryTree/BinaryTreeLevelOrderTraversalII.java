package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * 			(ie, from left to right, level by level from leaf to root)
 * 
 * 
 * 此题就是 BinaryTreeLevelOrderTraversal一样，唯一不同是level order traverse完后 reverse List即可
 * 
 * (my own interview question with eBay in Aug, 2017), 
 * If we are asked to print the result, we may use Stack to save the result to avoid reverse afterwards. 
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	//If we just need to print out results, we can use Stack or just print result from end of the list.
    	Stack<List<Integer>> stack = new Stack<>();
    	if(root == null){
    		return result;
    	}
    	
    	//Standard BFS algorithm template
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		ArrayList<Integer> level = new ArrayList<>();
    		int size = queue.size();
    		for(int i=0;i<size;i++){
    			TreeNode head = queue.poll();
    			level.add(head.val);
    			if(head.left!=null){
    				queue.offer(head.left);
    			}
    			if(head.right!=null){
    				queue.offer(head.right);
    			}
    		}
    		
    		result.add(level);
    	}
    	
    	
    	
    	//Collections.reverse(result); //Use this method to reverse List if allowed
    	//return result;
    	

    	//Create a new list and add items in if Collections.reverse() method cannot be used.
    	List<List<Integer>> reversedResult = new  ArrayList<>();
        for(int i=result.size()-1; i>=0; i--){
            reversedResult.add(result.get(i));
        }    	
    	return reversedResult;        
    }
    
    //
    class solution2{
    	
    }
    
}
