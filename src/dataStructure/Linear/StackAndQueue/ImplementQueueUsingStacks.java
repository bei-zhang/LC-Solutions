package dataStructure.Linear.StackAndQueue;

import java.util.Stack;

/**
 * 
 * 
 * Leetcode#232	Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/
 * http://www.geeksforgeeks.org/queue-using-stacks/
 * 
 * 
 * Solution 1 (By making deQueue operation costly)
In this method, in en-queue operation, the new element is entered at the top of stack1. In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.

enQueue(q,  x)
  1) Push x to stack1 (assuming size of stacks is unlimited).

deQueue(q)
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from satck1 to stack2.
  3) Pop the element from stack2 and return it.

  
  
  两种实现方法的共同特点是  一个stack专门 存储push的 element, 另一个stack专门负责 pop()
 *
 */
public class ImplementQueueUsingStacks {
	
	//Solution#1 (By making deQueue operation costly)  better solution (recommended)
	class MyQueue {
	    private Stack<Integer> inStack;
	    private Stack<Integer> outStack;

	    /** Initialize your data structure here. */
	    public MyQueue() {
	        inStack = new Stack<>();
	        outStack = new Stack<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        inStack.push(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if(outStack.isEmpty()){
	            moveStack();
	        }
	        return outStack.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        if(outStack.isEmpty()){
	            moveStack();
	        }
	        return outStack.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        if(outStack.isEmpty()){
	            moveStack();
	        }
	        return outStack.isEmpty();
	    }
	    
	    private void moveStack(){
	        while(!inStack.isEmpty()){
	            outStack.push(inStack.pop());
	        }
	    }
	}
	

}
