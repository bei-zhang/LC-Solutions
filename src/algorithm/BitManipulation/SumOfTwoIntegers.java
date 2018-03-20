package algorithm.BitManipulation;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * http://www.lintcode.com/en/problem/a-b-problem/
 * https://leetcode.com/problems/sum-of-two-integers/#/description
 * 
 * 英文描述的集体思路 
 * Sum of two bits can be obtained by performing XOR (^) of the two bits. 
 * Carry bit can be obtained by performing AND (&) of two bits. 
 * 
 * Above is simple Half Adder logic that can be used to add 2 single bits. 
 * We can extend this logic for integers. If x and y don’t have set bits at same position(s),
 * then bitwise XOR (^) of x and y gives the sum of x and y. To incorporate
 * common set bits also, bitwise AND (&) is used. Bitwise AND of x and y gives
 * all carry bits. We calculate (x & y) << 1 and add it to x ^ y to get the
 * required result.
 * http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
 *
 *
 *
 *
 */
public class SumOfTwoIntegers {

	public static int getSum(int a, int b) {
		// 主要利用异或运算来完成
		// 异或运算有一个别名叫做：不进位加法
		// 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
		// 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
		// a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
		// 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
		// 令a' = a ^ b, b' = (a & b) << 1
		// 可以知道，这个过程是在模拟加法的运算过程，进位不可能
		// 一直持续，所以b最终会变为0。因此重复做上述操作就可以
		// 求得a + b的值。
		while (b != 0) {
			int carry = a & b;
			a = a ^ b; //不进位加法
			b = carry << 1;
		}

		return a;
	}
	
	

	//recursion 解法， 不过能够不用递归就不要用递归
	public static int getSum2(int a, int b) {
		if(b==0){
			return a;
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return getSum2(sum,carry);
	}
	
	
	public static void main(String[] args) {
		int a = 0b011; // 3
		int b = 0b111; // 7
		if((a&1) == 0){
			System.out.println(a + b);
		}else{
			System.out.println("else: "+ a + b);
		}
		System.out.println(3 + 10 ==10);
		
		System.out.println(SumOfTwoIntegers.getSum(a, b)); // 100

	}

}
