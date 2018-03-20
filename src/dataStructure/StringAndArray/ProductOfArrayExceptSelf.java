package dataStructure.StringAndArray;

/**
 * 
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6]. 

 * https://leetcode.com/problems/product-of-array-except-self/
 * https://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
 * http://www.cnblogs.com/grandyang/p/4650187.html
 * 
 * Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
See Optimized solution2 with constant space complexity.

 *
 */
public class ProductOfArrayExceptSelf {
	//Solution#1 Time complexity is  O(n),  Space is O(n) which can be optimized to O(1) as Solution#2 below
	/**
	 * 由于output[i] = (x0 * x1 * ... * xi-1) * (xi+1 * .... * xn-1)
因此执行两趟循环：
第一趟正向遍历数组，计算x0 ~ xi-1的乘积
第二趟反向遍历数组，计算xi+1 ~ xn-1的乘积
	 */
	class Solution1 {
		public int[] productExceptSelf(int[] nums) {
			int[] result = new int[nums.length];

			int[] t1 = new int[nums.length];
			int[] t2 = new int[nums.length];

			t1[0] = 1;
			t2[nums.length - 1] = 1;

			// scan from left to right
			for (int i = 0; i < nums.length - 1; i++) {
				t1[i + 1] = nums[i] * t1[i];
			}

			// scan from right to left
			for (int i = nums.length - 1; i > 0; i--) {
				t2[i - 1] = t2[i] * nums[i];
			}

			// multiply
			for (int i = 0; i < nums.length; i++) {
				result[i] = t1[i] * t2[i];
			}

			return result;
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////
	
	// Optimized solution. Space is O(1) now. Time complexity is still O(n) same as Solution#1
	/**
	 * 我们可以对上面的方法进行空间上的优化，
	 * 由于最终的结果都是要乘到结果res中，所以我们可以不用单独的数组来保存乘积，
	 * 而是直接累积到res中，我们先从前面遍历一遍，将乘积的累积存入res中，然后从后面开始遍历，
	 * 用到一个临时变量right，初始化为1，然后每次不断累积，最终得到正确结果，
	 * 
	 */
	class Solution2 {
		public int[] productExceptSelf(int[] nums) {
			int n = nums.length;
			int[] result = new int[n];
	        result[0] = 1;
	        for (int i = 1; i < n; ++i) {
	            result[i] = result[i - 1] * nums[i - 1];
	        }
	        
	        int right =1;
	        for (int i = n - 1; i >= 0; --i) {
	            result[i] *= right;
	            right *= nums[i];
	        }
	        return result;
	        
	    	/*		
	    	int[] result = new int[nums.length];

			result[nums.length - 1] = 1;
			for (int i = nums.length - 2; i >= 0; i--) {
				result[i] = result[i + 1] * nums[i + 1];
			}

			int left = 1;
			for (int i = 0; i < nums.length; i++) {
				result[i] = result[i] * left;
				left = left * nums[i];
			}*/
	        
		}
	}

}
