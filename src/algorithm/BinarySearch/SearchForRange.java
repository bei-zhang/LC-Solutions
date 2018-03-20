package algorithm.BinarySearch;

/**
 * Given an array of integers sorted in ascending order, 
 * find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 * https://leetcode.com/problems/search-for-a-range/
 * 
 * 
 *解题思路: 实际上就是使用binary search 两次 
 */
public class SearchForRange {

	//Time: O(log n), Space: O(1)
	class Solution {
	    public int[] searchRange(int[] nums, int target) {
	        int[] res = new int[]{-1,-1}; //If the target is not found in the array, return [-1, -1].
	        if(nums == null || nums.length ==0){
	            return res;
	        }
	        res[0] = findFirstPosition(nums, target);
	        if(res[0] >=0){
	            res[1] = findLastPosition(nums, target);
	        }        
	        return res;
	    }
	    
	    //O(logn) time
	    private int findFirstPosition(int[] nums, int target){
	        int start = 0, end = nums.length -1;
	        while(start + 1 < end){
	            int mid = start + (end - start)/2 ;
	            if(nums[mid] < target){
	                start = mid;
	            }else{
	                end = mid;
	            }
	        }
	        if(nums[start] == target){
	            return start;
	        }else if(nums[end] == target){
	            return end;
	        }
	        return -1;
	    }
	    
	    //O(logn) time
	    private int findLastPosition(int[] nums, int target){
	        int start = 0, end = nums.length -1;
	        while(start + 1 < end){
	            int mid = start + (end - start)/2 ;
	            if(nums[mid] > target){
	                end = mid;
	            }else{
	                start = mid;
	            }
	        }
	        if(nums[end] == target){
	            return end;
	        }else if(nums[start] == target){
	            return start;
	        }
	        return -1;
	    }
	}
}
