package dataStructure.Linear.Deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 * You need to find the maximum for each window. 
 * 
 * https://leetcode.com/problems/sliding-window-maximum/
 * http://www.lintcode.com/en/problem/sliding-window-maximum/
 * 
 * 							Time					Space
 * 1)brute force			O(n^2)					O(1)
 * 2)Heap					O(nlog)					O(k)
 * 3)Deque 					O(n)					O(k)
 * 
 * 
 * With Heap solution, we need to use TreeMap/TreeSet to support O(logn) time for remove operation. 
 * 
 * Deque (Double Ended Queue): support enqueue and dequeue at both ends (head, tail)
 * 
 * 
 */
public class SlidingWindowMaximum {
	//Deque Solution
	class Solution {
	    public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums == null || nums.length ==0 || k<1){
	            return new int[0];
	        }
	        int n = nums.length;
	        int[] result = new int[n-k+1];
	        Deque<Integer> deque = new ArrayDeque<Integer>();
	        for(int i=0;i<k;i++){
	            enqueue(deque, nums[i]);
	        }
	        result[0] = deque.peek();
	        for(int i=k; i<n; i++){
	        	//Step1: remove the previous element if it still exists in the head of deque.
	            if(deque.peek() == nums[i-k]){
	                deque.poll();
	            }
	            //Step2: add
	            enqueue(deque,nums[i]);
	            result[i-k+1] = deque.peek();
	        }
	        return result;
	    }
	    
	    private void enqueue(Deque<Integer> deque, int num){
	        //注意是与last element 比较， 而不是head element, 这样确保deque里面的数都 >= 当前要加的数
	    	//删除前面小的数，是因为他们不可能成为最大值
	        while(!deque.isEmpty() && deque.peekLast() < num){
	            deque.pollLast();
	        }
	        deque.offer(num);
	    }
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
