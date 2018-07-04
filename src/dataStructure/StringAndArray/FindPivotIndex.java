package dataStructure.StringAndArray;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.

  We define the pivot index as the index where the sum of the numbers to the left of the index 
            is equal to the sum of the numbers to the right of the index.

  If no such index exists, we should return -1. 
  If there are multiple pivot indexes, you should return the left-most pivot index.
 * 
 * https://leetcode.com/problems/find-pivot-index/description/
 * 
 *
 */
public class FindPivotIndex {

	class Solution {
	    public int pivotIndex(int[] nums) {
	        int sum =0;
	        for(int i : nums){
	            sum += i;
	        }
	        int left =0;
	        for(int i=0; i<nums.length;i++){
	            if(left == (sum - nums[i] - left)){
	                return i;
	            }
	            left += nums[i];            
	        }
	        return -1;
	    }
	}
}
