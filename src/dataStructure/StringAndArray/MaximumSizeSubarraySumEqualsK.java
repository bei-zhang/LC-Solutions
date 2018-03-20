package dataStructure.StringAndArray;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 *
 ********In June, 2017, I got this question during first round of on-site interview at Amazon.*****
Given an array nums and a target value k, 
	find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Int [] nums = {3, 5, 8, -2, 6, 1, 10, -3, 2, 3, 12, 16, -5 }
k = 13
E.g. return 5, as the subarray is {1,10,-3,2,3} 

LC#325 原题
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k
http://www.programcreek.com/2014/10/leetcode-maximum-size-subarray-sum-equals-k-java/


 *
 */
public class MaximumSizeSubarraySumEqualsK {

	//best solution: use HashMap to save (prefixSum, index)
	//Time complexity: O(n)
	class Solution1{
		public int maxSubArrayLen(int[] nums, int k) {
        	if(nums == null || nums.length ==0){
				return 0;
			}
			
			Map<Integer, Integer> prefixSumMap = new HashMap<>();
			int maxLen =0 , sum =0;
			for(int i =0; i<nums.length;i++){
				sum += nums[i];
				if(sum == k){
					maxLen = Math.max(maxLen, i+1);
				}
                //如果有相同prefixSum出现，我们只保存第一次出现的index,这样才能保证 maximum length of subarray sum.
				if(!prefixSumMap.containsKey(sum)){
					prefixSumMap.put(sum, i);
				}
                
				int diff = sum - k;
				if(prefixSumMap.containsKey(diff)){
					maxLen = Math.max(maxLen, i - prefixSumMap.get(diff));
				}			
				
			}
			
			
			return maxLen;
    }
	}
	
	//Easiest solution, Time complexity: O(n^2)
	class Solution2{
		
		public int maxSubarrayLen(int[] nums, int targetSum){
			if(nums == null || nums.length ==0){
				return 0;
			}
			
			int maxLen =0 , len = nums.length, sum =0;
			int[] prefixSum = new int[len+1];
			prefixSum[0] = 0;
			for(int i=0; i<len;i++){
				sum+= nums[i];
				prefixSum[i+1] = sum;
			}
			for(int i=len; i>=0;i--){
				for(int j = len-1; j>=0;j--){
					if(prefixSum[i] - prefixSum[j] == targetSum){
						maxLen = Math.max(maxLen, i-j);
					}
				}
			}
			
		
			return maxLen;
		}
		
	}
	
	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsK instance = new MaximumSizeSubarraySumEqualsK(); 
		Solution1 s1 = instance.new Solution1();
		Solution2 s2 = instance.new Solution2();
		int[] a1 = {3, 5, 8, -2, 6, 1, 10, -3, 2, 3, 12, 16, -5 };
		System.out.println(s1.maxSubArrayLen(a1, 13));
		System.out.println(s2.maxSubarrayLen(a1, 13));
		int[] a2 = {-2,6,8,-3,7,-1,12, -6, 0,6,9 };
		System.out.println(s1.maxSubArrayLen(a2, 9));
		System.out.println(s2.maxSubarrayLen(a2, 9));

	}

}
