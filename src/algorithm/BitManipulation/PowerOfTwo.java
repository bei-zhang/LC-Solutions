package algorithm.BitManipulation;

/**
 * Given an integer, write a function to determine if it is a power of two. 
 * 
 * http://www.lintcode.com/en/problem/o1-check-power-of-2/
 * https://leetcode.com/problems/power-of-two/#/description
 * 
 * 使用小技巧：
x & (x - 1) 用于消去x最后一位的1
x = 1100
x - 1 = 1011
x & (x - 1) = 1000

 * 
 * 思路解析：
N如果是2的幂次，则N满足两个条件。
   1.N >0 
   2.N的二进制表示中只有一个1
因为N的二进制表示中只有一个1，所以使用N & (N - 1)将N唯一的一个1消去，应该返回0。

 *
 */
public class PowerOfTwo {
	public boolean checkPowerOf2(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
	

	public static void main(String[] args) {

	}

}
