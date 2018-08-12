package dataStructure.StringAndArray;

/**
 * 41. First Missing Positive
 * 
 * 解题思路:
 * Put each number in its right place.
 * For example:
 * When we find 5, then swap it with A[4].
 * At last, the first place where its number is not right, return the place + 1.
 */
public class FirstMissingPositive {
	//O(1) space, and O(n) time
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length ==0) return 1;
		int n = nums.length;
		for (int i = 0; i < n; ++i)
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
				swap(nums, i, nums[i] - 1);

		for (int i = 0; i < n; ++i)
			if (nums[i] != i + 1)
				return i + 1;

		return n + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
