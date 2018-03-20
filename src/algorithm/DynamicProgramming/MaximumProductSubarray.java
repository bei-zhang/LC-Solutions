package algorithm.DynamicProgramming;

/**
 * http://www.lintcode.com/en/problem/maximum-product-subarray/
 * http://www.jiuzhang.com/solutions/maximum-product-subarray/
 *
 *解题思路：
 *
 *此题是Maximum Subarray那题的变种。
 *由于正负得负，负负得正的关系。不管当前值是正还是负，当前值乘以之前的最大或最小，总会得到最大，再与自身相比，哪个大就是当前max product. 
 *  当前最大乘积就是三个值中求最大 =   max(A[i], A[i] * preMax,  A[i] * preMin)
 *因此，需要记录前一位A[i-1]结尾的min/max product subarray两个状态
 *
 *为什么要与自身相比， 例如 如果前面最大和最小都是0，当前值是正数。
 *
 */
public class MaximumProductSubarray {

	//O(n) time, O(1) space
	public class Solution {
		public int maxProduct(int[] nums) {
			if (nums == null || nums.length == 0) {
				return 0;
			}
			int preMax = nums[0], preMin = nums[0];
			int curMax = nums[0], curMin = nums[0];
			int result = nums[0];
			for (int i = 1; i < nums.length; i++) {
				//不管当前值是正还是负，current max product =  max(A[i], A[i] * preMax,  A[i] * preMin)
				curMax = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
				curMin = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
				preMax = curMax;
				preMin = curMin;
				result = Math.max(result, curMax);
			}

			return result;

		}
	}

	public static void main(String[] args) {

	}

}
