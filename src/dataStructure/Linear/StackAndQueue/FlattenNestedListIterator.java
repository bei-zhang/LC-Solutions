package dataStructure.Linear.StackAndQueue;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * 
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * 
 *
 */
public class FlattenNestedListIterator {

	public class NestedIterator implements Iterator<Integer> {
		private Stack<NestedInteger> stack;

	    public NestedIterator(List<NestedInteger> nestedList) {
	    	stack = new Stack<>();
	    	pushListToStack(nestedList);
	    }

	    @Override
	    public Integer next() {
	        if (hasNext()) {
	        	return stack.pop().getInteger();
	        }
	        return null;
	    }

	    @Override
	    public boolean hasNext() {
	        while (!stack.isEmpty() && !stack.peek().isInteger()) {
	            pushListToStack(stack.pop().getList());
	        }
	        return !stack.isEmpty();
	    }
	    
	    private void pushListToStack(List<NestedInteger> nestedList){
	        Stack<NestedInteger> temp = new Stack<>();
	        for (NestedInteger nested : nestedList) {
	            temp.push(nested);
	        }
	        
	        while (!temp.isEmpty()) {
	            stack.push(temp.pop());
	        }
	    }
	}
	
}





/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 *  */
interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

