package algorithm.Math;

import java.util.Collections;

/**
 * http://www.lintcode.com/en/problem/divide-two-integers/
 * https://leetcode.com/problems/divide-two-integers/#/description
 * http://www.jiuzhang.com/solution/divide-two-integers/
 *http://bangbingsyb.blogspot.com/2014/11/divide-two-integers-divide-two-integers.html
 *
 *	Divide two integers without using multiplication, division and mod operator.
 *  If it is overflow, return MAX_INT.
 *
 *
 * 解题思路:
 *我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，即 num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
 * 求 x = a/b  =>  a = b*x ,这样的 x 肯定可以用2的幂为底的一组基的线性组合表示
 *
 *  但题目不允许用乘法，可以用移位代替：x*2^i = x<<i
 *  
 * Left Shift   <<      i.e.    x << 3   二进制数左移3位，  就是 x 乘以 2^3
 * Right Shift  >>      i.e.    x >> 3  二进制数右移3位，     就是  x 除以 2^3
 *  
 *  
 *  corner case 非常重要：

(1) dividend,  divisor  可能会是负数
(2) divisor ==0, return Integer.MAX_VALUE or Integer.MIN_VALUE
(3) dividend ==0, return 0
(4) MIN_VALUE / -1 > MAX_VALUE,   overflow
(5) 必须将dividend,  divisor 转为long, 因为 Integer.MIN_VALUE取绝对值还是其本身， 一个负数

 *  
 */
public class DivideTwoIntegers {
	
    public static int divide(int dividend, int divisor) {
        if(divisor ==0){
            return dividend>0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if(dividend ==0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){//overflow 
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend >0 && divisor <0) || (dividend <0 && divisor >0);
        
        //注意这里一定要转成 long 因为Math.abs() 求绝对值时，如果是Integer.MIN_VALUE， 返回的还是负数Integer.MIN_VALUE
        long abs_dividend = Math.abs((long)dividend); 
        long abs_divisor = Math.abs((long)divisor);
        
        int result = 0;
        while(abs_dividend >= abs_divisor){
            int shift =0;
            while(abs_dividend >= (abs_divisor << shift)){
                shift++;
            }
            abs_dividend -= abs_divisor << (shift-1);
            result+= 1 << (shift-1);
        }
        result = isNegative? -result : result;
        
        return result;
    }
    
    
	public static void main(String[] args) {
		DivideTwoIntegers.divide(Integer.MIN_VALUE, 1);

	}

}
