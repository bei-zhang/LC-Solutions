package dataStructure.StringAndArray.TwoPointers;

/**
 * http://www.lintcode.com/en/problem/remove-element/
 * https://leetcode.com/problems/remove-element/
 * 
 * 此题 跟 @{MoveZeroes} 解题思路一样
 * 
 *
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int left = 0, right = 0;
		while (right < n) {
			while (left < n && nums[left] != val) {
				left++;
			}
			right = right > left ? right : left + 1;
			while (right < n && nums[right] == val) {
				right++;
			}
			if (left < n - 1 && right < n) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right++;
			}
		}

		return left;
	}

	public static void main(String[] args) {

	}

}
