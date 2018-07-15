package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 *  Given a binary tree, return the level order traversal of its nodes' values. 
     (ie, from left to right, level by level).
    
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
 * http://www.jiuzhang.com/solutions/binary-tree-level-order-traversal/
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-binary-tree-level-order.html
 *
 *
 * similar questions: 
 * 1. BinaryTreeSerialization.java
 * 2. BinaryTreeLevelOrderTraversalII.java   -- bottom-up level order traversal
 * 3. BinaryTreeRightSideView   --  Level Order Traversal (from root to leaf, right to left)
 * 
 */
public class BinaryTreeLevelOrderTraversal {
    // BFS solution is recommended.  (iterative)
    public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if(root == null)
    		return result;
    	
    	//Standard BFS algorithm template
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		ArrayList<Integer> level = new ArrayList<>();
    		//面试时有犯错，下面这行绝对不能省， 因为 queue 一直在变化，所以不能放进for loop 去判断 for(int i=0;i<queue.size();i++){
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
    	return result;
    	
    }
    
    
    // Solution# 2:  DFS  (recursion)
    public class DFSSolution {
        /**
         * @param root: The root of binary tree.
         * @return: Level order a list of lists of integer
         */
        public List<List<Integer>>  levelOrder(TreeNode root) {
        	List<List<Integer>>  results = new ArrayList<>();
            
            if (root == null) {
                return results;
            }
            
            int maxLevel = 0;
            while (true) {
                ArrayList<Integer> level = new ArrayList<Integer>();
                dfs(root, level, 0, maxLevel);
                if (level.size() == 0) {
                    break;
                }
                
                results.add(level);
                maxLevel++;
            }
            
            return results;
        }
        
        private void dfs(TreeNode root,
                         ArrayList<Integer> level,
                         int curtLevel,
                         int maxLevel) {
            if (root == null || curtLevel > maxLevel) {
                return;
            }
            
            if (curtLevel == maxLevel) {
                level.add(root.val);
                return;
            }
            
            dfs(root.left, level, curtLevel + 1, maxLevel);
            dfs(root.right, level, curtLevel + 1, maxLevel);
        }
    }


	
	
	public static void main(String[] args) {
		String s = "6";
		String[] arr = s.split(",");
		System.out.println(arr[0]);

	}

}
