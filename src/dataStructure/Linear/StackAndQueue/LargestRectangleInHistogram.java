package dataStructure.Linear.StackAndQueue;

import java.util.Stack;

/**
 * 
 * http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
 * http://www.jiuzhang.com/solution/largest-rectangle-in-histogram
 * 
 * 
 * 1) brute force:  O(n^2) time   two for loop and keep calculating and updating max value.
 * 
 * 2) stack:  O(n) time    单调栈
 *
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i); // 注意， 保存在stack里面的是数组下标
        }
        
        return max;
    }

    
	public static void main(String[] args) {

	}

}
