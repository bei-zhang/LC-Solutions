package dataStructure.StringAndArray;

import java.util.Arrays;

/**
 * Leetcode #26: Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that 
 *    each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
  Given input array nums = [1,1,2],

  Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
  It doesn't matter what you leave beyond the new length.


 * 
 */
public class RemoveDuplicateFromSortedArray {

	 //it runs in O(n) time and O(1) space
	public static int removeDuplicates(int[] nums) {
		if (nums.length<2)
			return nums.length;

		int j = 0; //point to the last element without duplicate
		for (int i = 1; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				nums[++j] = nums[i];
			}
		}

		return j+1;
				
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2 };
		//we need to sort it first if the given array is not sorted.
		Arrays.sort(arr);
		int length = removeDuplicates(arr);
		for (int k = 0; k < length; k++) {
			System.out.println(arr[k]);
		}

	}

}
