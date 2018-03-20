package algorithm.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
 * http://www.lintcode.com/en/problem/single-number-iii/
 * https://leetcode.com/problems/single-number-iii
 * https://www.hrwhisper.me/leetcode-bit-manipulation/
 * http://fisherlei.blogspot.com/2015/10/leetcode-single-number-iii-solution.html
 * 
 * 思路： Once again, we need to use XOR to solve this problem.
 *  But this time, we need to do it in two passes: 
 *  In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find.
 *   Note that since the two numbers are distinct, so there must be a set bit (that is, the bit
 * with value ‘1’) in the XOR result. Find out an arbitrary set bit (for example, the rightmost set bit). 
 * 
 * In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, 
 * another with the aforementinoed bit unset. Two different numbers we need to find must fall
 * into thte two distrinct groups. XOR numbers in each group, we can find a
 * number in either group.
 * 
 *Complexity: 
  Time: O (n)
  Space: O (1)

 * 
 */
public class SingleNumberIII {

	public static List<Integer> singleNumberIII(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}

		int xOR = 0;
		for (int i = 0; i < A.length; i++) {
			xOR ^= A[i];
		}
		int lastSetBit = xOR - (xOR & (xOR - 1));
		int group0 = 0, group1 = 0;
		for (int i = 0; i < A.length; i++) {
			if ((lastSetBit & A[i]) == 0) {
				group0 ^= A[i];
			} else {
				group1 ^= A[i];
			}
		}

		List<Integer> result = new ArrayList<>();
		result.add(group0);
		result.add(group1);
		return result;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 5, 2, 3, 9 };
		SingleNumberIII.singleNumberIII(A);

	}

}
