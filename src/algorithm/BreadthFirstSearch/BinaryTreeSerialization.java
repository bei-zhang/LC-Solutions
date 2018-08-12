package algorithm.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 * http://www.lintcode.com/en/problem/binary-tree-serialization/
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 *
 *注意此题与 BinaryTreeLevelOrderTraversal 区别: 
 * When printing binary tree in BFS order, we don't need to mark the nodes level by level. so no int size = queue.size(); 
 * When printing binary tree in level by level, we need to print them level by level. 
 *
 Given the following tree :
         3
  4            5 
6  7        8 	 9

print in BFS order: 
3,4,5,6,7,8,9

print in level by level:  
3
4,5
6,7,8,9


 */
public class BinaryTreeSerialization{

	class Solution {
		// Serialize a tree into a single string.
	    public String serialize(TreeNode root) {
	        if(root ==null)  return "{}";
	        //BFS
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        StringBuilder sb = new StringBuilder();
	        sb.append("{" + root.val);
			while (!queue.isEmpty()) {
				TreeNode head = queue.poll();
				if (head.left != null) {
					queue.offer(head.left);
					sb.append("," + head.left.val);
				} else {
					sb.append(",#");
				}
				if (head.right != null) {
					queue.offer(head.right);
					sb.append("," + head.right.val);
				} else {
					sb.append(",#");
				}
			}
	        sb.append("}");
	        return sb.toString();
	    }
	    
	    // Deserialize your encoded string to a tree
	    public TreeNode deserialize(String data) {
	        if(data == null || "{}".equals(data) )  return null;
	        String[] values = data.substring(1,data.length()-1).split(",");
	        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
	        List<TreeNode> list = new ArrayList<>();
	        list.add(root);
	        
	        int index =0;
	        boolean isLeftChild = true;
	        for(int i=1; i<values.length; i++){
	            if(!"#".equals(values[i])){
	                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
	                if(isLeftChild){
	                    list.get(index).left = node;
	                }else{
	                     list.get(index).right = node;
	                }
	                list.add(node);
	            }
	            
	            if(!isLeftChild)  index++;
	            
	            isLeftChild =!isLeftChild;
	        }
	        
	        return root;
	    }
	}	
}
