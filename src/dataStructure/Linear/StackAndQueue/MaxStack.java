package dataStructure.Linear.StackAndQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 
 * I got this question during LinkedIn On-site interview on 9/11/2017
 * 
 * 
 * Similar problem: MinStack
 * 此题如果没有 popMax() method, 实际上跟MinStack一样可以再用一个stack记录每一步相对应的max value
 * 但是要实现popMax()， 普通的stack不同满足，所以要用 PriorityQueue/Heap 来保存当前max value
 * 
 */
public class MaxStack {

	private Stack<Integer> stack; //normal stack to store elements
	//use stack to store max numbers at current steps if we do not need popMax().
	//private Stack<Integer> maxStack;  
	private PriorityQueue<Integer> maxHeap;//use PriorityQueue in order to support popMax()

	public MaxStack() {
		stack = new Stack<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	//Retrieve and remove the max value from the stack
	public int popMax(){
		int max = maxHeap.poll();
		Stack<Integer> temp = new Stack<>();
		boolean removed = false;
		while(!stack.isEmpty()){
			if(!removed && max == stack.peek()){
				stack.pop();
				removed = true;
			}else{
				temp.push(stack.pop());
			}
			
		}
		while(!temp.isEmpty()){
			stack.push(temp.pop());
		}
		return max;
	}
	
	//peek the max value in the stack
	public int peekMax() {
		return maxHeap.peek();
	}
	
	//normal push() method
	public void push(int number) {
		stack.push(number);
		maxHeap.offer(number);
	}

	//normal pop() method
	public int pop() {
		int res = stack.pop();
		maxHeap.remove(res);
		return res;
	}



	public static void main(String[] args){
		MaxStack maxStack = new MaxStack();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		maxHeap.offer(8);
		maxHeap.offer(6);
		maxHeap.offer(6);
		maxHeap.offer(8);
		
		maxHeap.remove(6);
		System.out.println(maxHeap);
	}
}
