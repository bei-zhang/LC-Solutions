package dataStructure.StringAndArray.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类似题目: TwoSum, ThreeSum, FourSum
 * 
 *
 */
public class FourSum {
	// (recommended)Sorting + two pointers solution 
	// Time: O(n^3), Space: O(1)
	//解题思路： 将其转为 Three Sum,  因为多了一个数，所以比3Sum 多了一层for-loop
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(nums); // #1. Sort the array
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue; // prevent duplicates
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i+1 && nums[j] == nums[j - 1]) continue; // prevent duplicates
				int newTarget = target - nums[i] - nums[j];
				int low = j + 1, high = nums.length - 1; // #2. Two pointers to find target like TwoSum
				while (low < high) {
					if (nums[low] + nums[high] == newTarget) {
						res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1])  low++; // skip duplicates
						while (low < high && nums[high] == nums[high - 1]) high--; // skip duplicates
						low++;
						high--;
					} else if (nums[low] + nums[high] > newTarget) {
						high--;
					} else {
						low++;
					}
				}
			}
		}

		return res;  
	}
}
