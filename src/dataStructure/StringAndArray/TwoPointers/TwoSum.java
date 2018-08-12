package dataStructure.StringAndArray.TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  *Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 * https://leetcode.com/problems/two-sum/#/description
 * http://www.lintcode.com/en/problem/two-sum/
 * 
 * 
********************************   TwoSum 题解分析     *******************
*
					1) brute force    2) HashMap       3) Sort + 2 Pointers ()
Time complexity:  	   O(n^2)			 O(n)				O(nlogn)   ( 只需要 O(n) if given array is sorted)
Space complexity:	   O(1)			     O(n)				O(1)

此题要求返回indices， 只能用前两种方案， 因为排序后index变化了
何时可以用2 Pointers： 如果给定数组已排序  或者  要求的是 返回值而不是 数组中的indices, 例题： TwoSumWithSortedArray， TwoSumUniquePairs

对于题目 TwoSum_DataStructureDesign -- 只能用 HashMap solution

//follow-up: find all pairs      -- 以上三种方法都可以， 需要返回 a List of Pair(first,second)  或者 HashMap(key,value)

//follow-up: duplicate allowed   -- 如果要返回indices，则必须要用 brute force，

 */
public class TwoSum {
	//HashMap solution
	public int[] twoSum(int[] nums, int target) {
		//Using HashMap to store remaining sum is the key.
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			}
			map.put(target - nums[i], i);
		}
		return null;
	}
	

	public static void main(String[] args) {

	}

}
