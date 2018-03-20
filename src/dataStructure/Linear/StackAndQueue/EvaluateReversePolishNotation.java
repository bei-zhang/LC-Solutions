package dataStructure.Linear.StackAndQueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 */
public class EvaluateReversePolishNotation {

	//My own solution  (recommended)
	//Time: O(n), Space O(n)
	//解题思路: Use stack to save integers. 
	//When it's a operator, pop two integers from stack and calculate the result and then save the result back to stack.
	class Solution {
		public int evalRPN(String[] tokens) {
			if (tokens == null || tokens.length == 0) {
				return 0;
			}
			String validOperators = "+-*/";
			Stack<Integer> stack = new Stack<>();
			int a, b;
			for (String token : tokens) {
				if (validOperators.indexOf(token) < 0) {
					stack.push(Integer.parseInt(token));
				} else {
					b = stack.pop();
					a = stack.pop();
					stack.push(calculate(a, b, token)); // save the result back to stack after calculating
				}
			}
			return stack.pop();
		}

		private int calculate(int first, int second, String operator) {
			int res = 0;
			switch (operator) {
				case "+":
					res = first + second;
					break;
				case "-":
					res = first - second;
					break;
				case "*":
					res = first * second;
					break;
				case "/":
					res = first / second;
					break;
				default:
					break;
			}
			return res;
		}
	}

	public static void main(String[] args) {

	}

}
