package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	//BFS: Level Order Traversal (from root to leaf, right to left)
	//Time: O(n), Space: O(n)
	class Solution2 {
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> res = new ArrayList<>();
	        if(root == null) return res;
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);  
	        while(!queue.isEmpty()){
	            int size = queue.size();   
	            //Note: We only need the first node at each level which is the right most node.
	            res.add(queue.peek().val);
	            while(size-- > 0){
	                TreeNode t = queue.poll();
	                if(t.right !=null) queue.offer(t.right);                   
	                if(t.left !=null)  queue.offer(t.left);             
	            }
	                      
	        }
	        return res;
	    }
	}
	
}
