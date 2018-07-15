package algorithm.Math;

/**
 * 264. Ugly Number II
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 *
 * 类似问题: UglyNumber.java, CountPrimes.java
 * 
 */
public class UglyNumberII {
/**
 * 解题思路 类似 CountPrimes 但是不同点是 every time we only try to find the next smallest ugly number
 * 1. Essentially, we have to multiply the existed ugly numbers by 2, 3 and 5 to get a bigger ugly number, 
 *     however, if we blindly multiply all the existed numbers by 2, 3 and 5, then the number could grow much faster than needed
 * 2. Hence, every time we only try to find the next smallest ugly number
 * 3. Also, since any existed number will be multiplied by 2, 3 and 5 once and only once, otherwise duplicate, 
 *    we can use a pointer to keep track of where the 2, 3 and 5 are going to multiply in the next step.
 * 4. Once, we find the next minimum, we can move on the corresponding pointer, 
 *    otherwise it always stays at the already existed ugly number which would makes pointer useless
 *
 */
	class Solution {
	    public int nthUglyNumber(int n) {
	        int[] ugly = new int[n];
	        ugly[0] = 1;
	        int p2 =0, p3 =0, p5 =0;
	        for(int i=1; i<n; i++){
	            ugly[i] = Math.min(2 * ugly[p2] , Math.min(3 * ugly[p3], 5 * ugly[p5]));
	            if(ugly[i] == 2 * ugly[p2]) p2++;
	            if(ugly[i] == 3 * ugly[p3]) p3++;
	            if(ugly[i] == 5 * ugly[p5]) p5++;            
	        }
	        return ugly[n-1];     
	    }
	}
}
