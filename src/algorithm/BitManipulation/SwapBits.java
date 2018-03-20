package algorithm.BitManipulation;

/**
 * Write a program to swap odd and even bits in an integer with as few
 * instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 * 
 * http://www.lintcode.com/en/problem/swap-bits/
 * http://www.geeksforgeeks.org/swap-all-odd-and-even-bits/
 * 
 * 
 *
 *解题思路：
Let the input number be x
1) Get all even bits of x by doing bitwise AND of x with 0xAAAAAAAA. The number 0xAAAAAAAA is a 32 bit number with all even bits set as 1 and all odd bits as 0.
2) Get all odd bits of x by doing bitwise AND of x with 0x55555555. The number 0x55555555 is a 32 bit number with all odd bits set as 1 and all even bits as 0.
3) Right shift all even bits.
4) Left shift all odd bits.
5) Combine new even and odd bits and return.


Two special hexadecimal literals:  0xAAAAAAAA and 0x55555555
其实这个很好理解记忆
十六进制的   A 对应 十进制的 10， 对应二进制  1010
十六进制的   5 对应 十进制的 5， 对应二进制  0101
如果十六进制的8位数 每一位都是A, 对应的二进制1010重复8遍，就是32 bit number with all even bits set as 1 and all odd bits as 0.
因为 2^4 = 16, 所以容易理解 二进制数的 4 位 才能表示 十六进制数中的一位


 */
public class SwapBits {
	
    public int swapOddEvenBits(int x) {
        int evenBits = x & 0xAAAAAAAA;
        int oddBits = x & 0x55555555;
        evenBits = evenBits >>> 1; //unsigned right shift
        oddBits = oddBits <<1;
        return (evenBits | oddBits);

     }
	
	

	public static void main(String[] args) {

		int a = 0b00000000000000000000000000001010;
		int b = 0b11000000000000000000000000001010;
		int c = 0b01111111111111111111111111111010;
		System.out.println(a + " in binary string is "+  Integer.toBinaryString(a));
		System.out.println(b + " in binary string is "+  Integer.toBinaryString(b));
		System.out.println(c + " in binary string is "+  Integer.toBinaryString(c));
		
		System.out.println(a + " in binary string is "+  Integer.toBinaryString(a >>2));
		System.out.println(b + " in binary string is "+  Integer.toBinaryString(b >>2));
		System.out.println(b + " b >>>2 in binary string is "+  Integer.toBinaryString(b >>>2));
		
		System.out.println(-1 + " in binary string is "+  Integer.toBinaryString(-1));
		System.out.println("Integer.MIN_VALUE="+ Integer.MIN_VALUE + " in binary string is "+  Integer.toBinaryString(Integer.MIN_VALUE));
		System.out.println(0xAAAAAAAA + " in binary string is "+  Integer.toBinaryString(0xAAAAAAAA));
		System.out.println(0x55555555 + " in binary string is "+ Integer.toBinaryString(0x55555555));
		
		
		
		
		
	}
	

}
