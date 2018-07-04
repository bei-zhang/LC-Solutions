package algorithm.BinarySearch;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * There are three methods: 
 *   1) Linear Scan
 *   2) Recursive Binary Search
 *   3) Iterative Binary Search  (Best solution)
 */
public class FindPeakElement {
	
	/**
	 * Recommended solution
	 * Iterative Binary Search
	 * Time complexity : O(logn)
	 * Space complexity : O(1)
	 *
	 */
	public class Solution {
	    public int findPeakElement(int[] nums) {
	        int start = 0, end = nums.length - 1;
	        while (start < end) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid] > nums[mid + 1])
	                end = mid;
	            else
	                start = mid + 1;
	        }
	        return start;
	    }
	}
	
	/**
	 * Recursive Binary Search
	 * Time complexity : O(logn). We traverse the nums array of size n once only.
	 * Space complexity : O(logn). Constant extra space is used. 
	 *
	 */
    class Solution2 {
	    public int findPeakElement(int[] nums) {
	        return search(nums, 0, nums.length - 1);
	    }
	    public int search(int[] nums, int l, int r) {
	        if (l == r)
	            return l;
	        int mid = (l + r) / 2;
	        if (nums[mid] > nums[mid + 1])
	            return search(nums, l, mid);
	        return search(nums, mid + 1, r);
	    }
	}
	
    
	/**
	 * Linear Scan
	 * Time complexity : O(n). We traverse the nums array of size n once only.
	 * Space complexity : O(1). Constant extra space is used. 
	 *
	 */
	class Solution1 {
	    public int findPeakElement(int[] nums) {
	       for(int i=0; i<nums.length-1;i++){
	           if(nums[i] > nums[i+1]){
	               return i;
	           }
	       }   
	       return nums.length -1;
	    }
	}
	
	
}
