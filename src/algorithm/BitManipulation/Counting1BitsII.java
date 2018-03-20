package algorithm.BitManipulation;

/**
 * 
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * https://leetcode.com/problems/counting-bits/#/description
 * 
 *
 *Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any built-in function like __builtin_popcount in c++ or in any other language.


三种解法：
1) 直接用{@Counting1Bits.java}解法 对每个数求解       O(n*sizeof(integer)) time

方法2和3 都是 DP思想， 利用已经求出来的数求解
2) 一个数 乘以2 就是把它的二进制全部左移一位，也就是说 1的个数是相等的，如果是奇数，只需要额外加1.   O(n) time  best solution
比如11和10除以2都是5，但是11是通过5左移一位并且+1得到，10则是直接左移

 DP 方程            dp[i] = dp[i/2] + (i%2)
写成位运算就是     dp[i] = dp[i>>1] + (i&1)


3) 当一个数为2的整数幂的时候，1的个数为1，比如2（10) 和4(100)，8(1000)        O(n) time but harder to explain/understand
      在这之后就是前一个序列的数+1 比如 9(1001) = 1(1) + 8 (1) = 2
       就是把一个数分解为小于它的最大2的整数幂 + x



 */
public class Counting1BitsII {
	
	
	/**
	 * 
	 * Solution#2     一个数 乘以2 就是把它的二进制全部左移一位，也就是说 1的个数是相等的，如果是奇数，只需要额外加1.
	 * O(n) time  best solution
	 */
	public int[] countBits(int num) {
		int[] dp = new int[num +1];
		for(int i=1; i<=num;i++){
			dp[i] = dp[i>>1] + (i&1); //DP 方程   
		}
		return dp;
	}
	
/////////////////////////////////////////////////////////////////////////
	
	/**
	 * Solution#3
	 * 把一个数分解为小于它的最大2的整数幂 + x
	 * 
	 * O(n) time
	 *  
	 */
	public int[] countBits_3(int num) {
		int[] dp = new int[num +1];
		int power2=2, diff =0;
		for(int i=2; i<=num;i++){
			if(i == power2){
				diff = dp[i] = 1;  //DP 方程  when a number is power of 2.
				power2 = power2 << 1;
			}else{
				dp[i] = dp[diff] + 1; //DP 方程  when a number is not power of 2.
				diff++;
			}
		}
		return dp;
	}
	
	
}
