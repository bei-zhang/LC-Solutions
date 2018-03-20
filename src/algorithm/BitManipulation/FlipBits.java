package algorithm.BitManipulation;

/**
 * Determine the number of bits required to flip if you want to convert integer
 * n to integer m. Both n and m are 32-bit integers.
 * 
 * http://www.lintcode.com/en/problem/flip-bits/
 * 
 * 解题思路： 这个应用是另外一个应用 @{Counting1Bits} 的拓展。
 * 思考将整数A转换为B，如果A和B在第i（0<=i<32）个位上相等，则不需要改变这个BIT位，如果在第i位上不相等，则需要改变这个BIT位。
 * 所以问题转化为了A和B有多少个BIT位不相同。联想到位运算有一个异或操作，相同为0，相异为1，所以问题转变成了计算A异或B之后这个数中1的个数。
 * 
 * 
 */
public class FlipBits {

	public static int bitSwapRequired(int a, int b) {
		int diff = a ^ b;
		int count = 0;
		while (diff != 0) {
			diff = diff & (diff - 1);
			count++;
		}
		return count;
	}

}
