package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 * Given a Binary Search Tree and a target number, 
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 * 
 * 类似题目: TwoSum
 */
public class TwoSumIVOnBST {

	//DFS + HashSet  (simple solution recommended)
	//Time: O(n) - The entire tree is traversed only once in the worst case.   
	//Space: O(n) - The size of the HashSet can grow up to n in the worst case.
	class Solution {
	    public boolean findTarget(TreeNode root, int k) {
	       return dfsHelper(root, k, new HashSet<>());
	    }
	    
	    private boolean dfsHelper(TreeNode root, int k, Set<Integer> set){
	        if(root == null) return false;
	        if(set.contains(k - root.val)) return true;
	        set.add(root.val);
	        return dfsHelper(root.left, k, set) || dfsHelper(root.right, k, set);
	    }
	}

//////////////////////////////////
	//Solution2: BFS and HashSet.  Similar to the above, but we traverse the tree via BFS
	//Time: O(n) - The entire tree is traversed only once in the worst case.   
	//Space: O(n) - The size of the HashSet can grow up to n in the worst case.
	public class Solution2 {
	    public boolean findTarget(TreeNode root, int k) {
	        Set < Integer > set = new HashSet();
	        Queue < TreeNode > queue = new LinkedList();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            if (queue.peek() != null) {
	                TreeNode node = queue.remove();
	                if (set.contains(k - node.val))
	                    return true;
	                set.add(node.val);
	                queue.add(node.right);
	                queue.add(node.left);
	            } else
	                queue.remove();
	        }
	        return false;
	    }
	}
	
/////////////////////
	//Solution3: 利用 BST的特性, inorder traverse the tree and put the values in List which should be sorted.
	public class Solution3 {
	    public boolean findTarget(TreeNode root, int k) {
	        List < Integer > list = new ArrayList();
	        inorder(root, list);
	        //下面就是Two pointers to find target in sorted array.
	        int l = 0, r = list.size() - 1;
	        while (l < r) {
	            int sum = list.get(l) + list.get(r);
	            if (sum == k)
	                return true;
	            if (sum < k)
	                l++;
	            else
	                r--;
	        }
	        return false;
	    }
	    public void inorder(TreeNode root, List < Integer > list) {
	        if (root == null)
	            return;
	        inorder(root.left, list);
	        list.add(root.val);
	        inorder(root.right, list);
	    }
	}
	
}
