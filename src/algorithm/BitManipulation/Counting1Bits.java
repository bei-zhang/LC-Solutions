package algorithm.BitManipulation;

/**
 * 
 * Write a function that takes an unsigned integer and returns the number of '1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer '11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * http://www.lintcode.com/en/problem/count-1-in-binary/
 * https://leetcode.com/problems/number-of-1-bits/#/description
 * 
 * 
 使用小技巧：
x & (x - 1) 用于消去x最后一位的1
x = 1100
x - 1 = 1011
x & (x - 1) = 1000

 *
 */
public class Counting1Bits {

	public int countOnes(int num) {
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int a = 0b011; // 3
		int b = 0b111; // 7
		System.out.println(a & 1);
		System.out.println(SumOfTwoIntegers.getSum(a, b)); // 100

	}
}
