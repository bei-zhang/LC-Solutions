package dataStructure.Linear.StackAndQueue;

import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/min-stack/
 * 
 * I got this question during WalmartLabs onsite on 8/28/2017
 * 
 * Similar problem: MaxStack
 * Follow-up: what if we need to implement popMin() method
 * 跟MaxStack那题一样，如果要支持popMin()， 普通的stack不同满足要求，需要用 PriorityQueue/Heap 来保存当前min value
 * 
 */
public class MinStack {

	private Stack<Integer> stack; //normal stack to store elements
	private Stack<Integer> minS;  //store min numbers at current steps.

	public MinStack() {
		// do initialize if necessary
		stack = new Stack<Integer>();
		minS = new Stack<Integer>();
	}

	public void push(int number) {
		stack.push(number);
		if(!minS.isEmpty() && minS.peek() < number){
			minS.push(minS.peek());
		}else{
			minS.push(number);
		}
	}

	public int pop() {
		minS.pop();
		return stack.pop();
	}

	public int min() {
		return minS.peek();
	}

}
