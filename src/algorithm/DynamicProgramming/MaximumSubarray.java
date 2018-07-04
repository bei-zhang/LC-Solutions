package algorithm.DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given an array of integers, find a contiguous subarray which has the largest
 * sum. Example
 * 
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1]
 * has the largest sum = 6.
 * 
 * http://www.lintcode.com/en/problem/maximum-subarray/
 * http://www.jiuzhang.com/solutions/maximum-subarray/
 * 
 * #1. Brute force solution:  O(n^2) - Two for-loop to calculate all sub-array sum
 * #2. DP solution: O(n) - keep track of the current minimum sub-array while looping the array
 * #3. Divide and Conquer--max(max left subarray, max right subarray, max subarray crossing midpoint)
 * 
 * Similar problem: BestTimeToBuyAndSellStock
 */
public class MaximumSubarray {
	//Time complexity: O(n).  Space complexity: O(1)
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxSum = Integer.MIN_VALUE;
		int minSum = 0, sum = 0;
        for(int num: nums){
            sum+=num;
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);//对于前面的数，只关心和保存最小sum.            
        }
		return maxSum;
	}

	
	
	public static void main(String[] args) {

		Map<Integer,Integer> sumMap = new HashMap<>();
		sumMap.containsKey("key");
		Set<Integer> set = new HashSet<>();
		set.contains("k");
		
		
		
	}

}
