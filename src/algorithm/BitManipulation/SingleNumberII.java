package algorithm.BitManipulation;

/**
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
 * 
 * http://www.lintcode.com/en/problem/single-number-ii/
 * 
 * 1) 可以用 greedy 做， 需要用到HashMap 花费 O(n) extra space 
 Complexity: 
  Time: O (n)
  Space: O (n)
  
 * 2) 采用 Bit Manipulation 的解题思路：
 * 输入为int有32位，对数组中每个数的各个位上进行相加，然后Mod3就是该位上只出现一次应该取的值
 Complexity: 
  Time: O (n)
  Space: O (1)
 * 
 *
 */
public class SingleNumberII {

	public int singleNumberII(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < A.length; j++) {
				sum += (A[j] >> i) & 1;
			}
			result |= (sum % 3) << i;
		}

		return result;

	}

	public static void main(String[] args) {

	}

}
