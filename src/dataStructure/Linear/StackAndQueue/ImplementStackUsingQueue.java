package dataStructure.Linear.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * LeetCode #225: Implement Stack using Queues 
 * https://leetcode.com/problems/implement-stack-using-queues/
 * http://www.geeksforgeeks.org/implement-stack-using-queue/

Method  (By making pop operation costly)
push(s,  x)
  1) Enqueue x to q1 (assuming size of q1 is unlimited).

pop(s)  
  1) One by one dequeue everything except the last element from q1 and enqueue to q2.
  2) Dequeue the last item of q1, the dequeued item is result, store it.
  3) Swap the names of q1 and q2
  4) Return the item stored in step 2.
// Swapping of names is done to avoid one more movement of all elements 
// from q2 to q1.
 * 
 * 
 *
 */
public class ImplementStackUsingQueue {

	/**
	 * 思路：一直往 queue1 里 push elements, 
	 * 需要pop的时候把queue1 的所有elements (只保留一个元素在queue1) 全部move到 queue2, 然后pop queue1, 最后swap two queues
	 *
	 */
	class MyStack {
	    private Queue<Integer> queue1;
	    private Queue<Integer> queue2;

	    /** Initialize your data structure here. */
	    public MyStack() {
	        queue1 = new LinkedList<>();
	        queue2 = new LinkedList<>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue1.offer(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        moveElements();
	        int element = queue1.poll();
	        swapQueues();
	        return element;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        moveElements();	           
	        return queue1.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue1.isEmpty();
	    }
	    
	    private void moveElements(){
	        while(queue1.size() !=1){
	            queue2.offer(queue1.poll());
	        }
	    }
	    
	    private void swapQueues(){
	        Queue<Integer> temp = queue1;
	        queue1 = queue2;
	        queue2 = temp;
	    }
	}

	
}
