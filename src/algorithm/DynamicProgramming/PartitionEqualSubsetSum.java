package algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * Given a non-empty array containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * http://www.jiuzhang.com/solution/partition-equal-subset-sum/
 *
 * 解题思路：  此题不能用subarray sum的思想来做，因为这里的subarry 可以是不连续的
 * 这种非连续的题目，求是否能 partition,一般都是DP 来解
 * 
 *
 */
public class PartitionEqualSubsetSum {
	//DP solution with optimized space   (best solution, recommended)
	public class Solution {
	    public boolean canPartition(int[] nums) {
	        int sum = 0;
	        //1. 先求sum
	        for (int num : nums) {
	            sum += num;
	        }
	        //2. return false if sum is not even number
	        if (sum % 2 == 1) {
	            return false;
	        }
	        sum /= 2;
	        boolean[] dp = new boolean[sum+1];
	        Arrays.fill(dp, false);
	        dp[0] = true;
	        for (int num : nums) {
	            for (int i = sum; i >= num; i--) {	               
	                    dp[i] = dp[i] || dp[i-num];	               
	            }
	        }
	        return dp[sum];
	    }
	}
	
}
