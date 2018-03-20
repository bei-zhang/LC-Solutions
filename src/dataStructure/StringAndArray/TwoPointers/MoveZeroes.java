package dataStructure.StringAndArray.TwoPointers;

/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it 
 * 			while maintaining the relative order of the non-zero elements.

	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 * https://leetcode.com/problems/move-zeroes
 * http://www.lintcode.com/en/problem/move-zeroes/
 * 
 * 此题 跟 @{RemoveElement} 解题思路一样
 * 
 * 解题思路
 * 左右两个指针， 左指针指向第一个为0的位置， 右指针必须保持在前面，指向第一个 non-zero element, 然后两个交换位置swap
 * 
 */
public class MoveZeroes {

	public class Solution {
	    public void moveZeroes(int[] nums) {
	        if(nums == null || nums.length < 2){
	            return;
	        }
	        int n = nums.length;
	        int left=0,right=1;
	        while(right<n){
	            while(left<n-1 && nums[left] != 0){
	                left++;
	            }       
	            right = right>left? right:left+1; //保证右指针在前面
	            while(right<n && nums[right] ==0){
	                right++;
	            }
	            
	            if(left<n-1 && right <n){
	                int temp = nums[left];
	                nums[left] = nums[right];
	                nums[right] = temp;  
	                left++;
	                right++;
	            }
	        }
	    }
	}
	
}
