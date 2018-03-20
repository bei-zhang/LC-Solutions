package dataStructure.StringAndArray;

/**
 * https://leetcode.com/problems/zigzag-conversion
 *
 */
public class ZigZagConversion {

	//Solution1: 简单直接的解法
	//Time complexity: O(n)       n is the length of given string 
	//Space complexity: O(n)
	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuilder();

		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
				sb[idx].append(c[i++]);
			for (int idx = numRows - 2; idx >= 1 && i < len; idx--) // obliquely up
				sb[idx].append(c[i++]);
		}
		
		for (int idx = 1; idx < sb.length; idx++) {
			sb[0].append(sb[idx]);
		}
			
		return sb[0].toString();

	}

	public static void main(String[] args) {

		System.out.println(3 % 4 + 1);
	}

}
