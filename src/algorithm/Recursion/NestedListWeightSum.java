package algorithm.Recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/nested-list-weight-sum/description/
 * http://www.lintcode.com/en/problem/nested-list-weight-sum/
 *http://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
 *
 * Follow up problem: NestedListWeightSumII
 * 
 */
public class NestedListWeightSum {

	//Solution 1 - Recursive        (preferred solution. easy to understand)
	//Time complexity: O(n) --- n is the total number of integers in the list.
	//Space Complexity: O(1)
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    private int helper(List<NestedInteger> nestedList, int depth){     
        int sum =0;
        for(NestedInteger nestedInt: nestedList){
            if(nestedInt.isInteger()){
                sum+= depth * nestedInt.getInteger();
            }else{
                sum+= helper(nestedInt.getList(), depth+1);
            }
         
        }
        return sum;
    }
 
 ///////////////////////////////////////////////////////////////////////////   
    //Solution 2 - Iterative
    public int depthSum2(List<NestedInteger> nestedList) {
        int sum=0;
        LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
        LinkedList<Integer> depth = new LinkedList<Integer>();
     
        for(NestedInteger ni: nestedList){
            queue.offer(ni);
            depth.offer(1);
        }
     
        while(!queue.isEmpty()){
            NestedInteger top = queue.poll();
            int dep = depth.poll();
     
            if(top.isInteger()){
                sum += dep*top.getInteger();
            }else{
                for(NestedInteger ni: top.getList()){
                    queue.offer(ni);
                    depth.offer(dep+1);
                }
            }
        }
     
        return sum;
    }
    
    
    
}

//------------Assumption code----------------------
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
*/
 /*interface NestedInteger {
 
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
 
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
 
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}*/


