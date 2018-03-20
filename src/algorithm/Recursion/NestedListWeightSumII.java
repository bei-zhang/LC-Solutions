package algorithm.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Different from the previous question where weight is increasing from root to leaf, 
 * now the weight is defined from bottom up. 
 * i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 * 
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 * http://blog.csdn.net/qq508618087/article/details/51743408
 * 
 * 
 * Related problems: NestedListWeightSum
 *
 */
public class NestedListWeightSumII {
	
	//自己独立思考出来的solution - space complexity can be optimized. see optimized solution#2 below
	//Time complexity: O(n)  - n is the number of nodes in the tree if we represent it as a tree.
	//Space complexity: O(m) - m is the depth 
	public class Solution1 {
		public int depthSumInverse(List<NestedInteger> nestedList) {
			Stack<Integer> levels = new Stack<>();// Use Stack to track levels. e.g. 1, 2, 3, ...
			List<Integer> levelSumList = new ArrayList<>();//Calculate the sum of integers at each level and add the sum to the list
			helper(nestedList, levels, levelSumList); // call recursive method
			int weightedSum =0;
			for(int levelSum : levelSumList){
				weightedSum+= levels.pop() * levelSum;
			}
			return weightedSum;
		}
		
		// helper method with recursion
		private void helper(List<NestedInteger> nestedList, Stack<Integer> levels, List<Integer> levelSumList){
			if(nestedList.isEmpty()){
				return;
			}
			levels.push(levels.isEmpty() ? 1 : (levels.peek() + 1));
			
			int currLevelSum = 0;
			List<NestedInteger> nextLevel = new ArrayList<>();
			for(NestedInteger nestedInteger : nestedList){
				if(nestedInteger.isInteger()){
					currLevelSum+= nestedInteger.getInteger();
				}else{
					nextLevel.addAll(nestedInteger.getList());
				}
				
			}
			levelSumList.add(currLevelSum);
			helper(nextLevel, levels, levelSumList);
		}
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//#2 - Optimized solution: Instead of multiplying by depth, add integers multiple times
	//Time complexity: O(n)  - n is the number of nodes in the tree if we represent it as a tree.  
	//						  n is bigger than the number of integers in the list. integers are the leaves in the tree.
	//Space complexity: O(1)
	public class Solution2 {
	    public int depthSumInverse(List<NestedInteger> nestedList) {
	        int weightedSum =0, levelSum =0;
	        while(!nestedList.isEmpty()){
	            List<NestedInteger> nextLevel = new ArrayList<>();
	            for(NestedInteger nestedInt : nestedList){
	                if(nestedInt.isInteger()){
	                    levelSum+= nestedInt.getInteger();
	                }else{
	                    nextLevel.addAll(nestedInt.getList());
	                }
	            }
	            weightedSum+= levelSum;
	            nestedList = nextLevel;
	        }
	        
	         return weightedSum;
	        
	    }
	}	

}


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * */
interface NestedInteger {
     // Constructor initializes an empty nested list.
    // public NestedInteger();

     // Constructor initializes a single integer.
    // public NestedInteger(int value);

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
