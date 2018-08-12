package algorithm.quicksort;

import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/kth-largest-element-ii/
 * http://www.jiuzhang.com/solutions/kth-largest-element-ii/
 * 
 * 
 * 两种解法都可以，对比如下：
 *  1) Quick select:  O(n) Time,  in-place  更适合这道题， 死数据
 *  
 *  2)PriorityQueue (heap):   O(nlogk) time,      适合于 TopKLargestNumbersII 这样的活数据
 *     
 *
 */
public class KthLargestElementII {

	//PriorityQueue
	class Solution {
	    public int kthLargestElement2(int[] nums, int k) {
	        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	        for (int num : nums) {
	            q.offer(num);
	            if (q.size() > k) {
	                q.poll();
	            }
	        }
	        return q.peek();
	        
	    }
	};
	
	
	public static void main(String[] args) {

	}

}
