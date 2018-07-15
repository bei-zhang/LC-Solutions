package algorithm.Math;

/**
 * LeetCode#204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * https://leetcode.com/problems/count-primes/description/
 * 
 * A prime number is a whole number greater than 1 whose only factors are 1 and itself.
 * Numbers that have more than two factors are called composite numbers.
 * Prime Numbers(质数,又称素数): 2, 3, 5, 7, 11 ...
 * Composite Numbers(合数): 4, 6, 8, 9 ... 
 *
 */
public class CountPrimes {
	//Best Solution  
	//Time complexity: looks like it's O(n^2) but it's close to O(n)
	 public int countPrimes(int n) {
		 if(n <=2) return 0;
		 boolean[] composites = new boolean[n];
		 int count = 0;
		 for(int i=2; i<n; i++) {
			 if(composites[i]) continue;
			 count++; //print it here or add it to the output array/list if needed. 
			 //对于每一个Prime number, 将其对应的倍数全部设置为true. 
			 //例如 prime 3, 将辅助数组里 下标为 6, 9, 12, 15 etc. 全部为true
			 for(int j=2*i; j<n; j+= i) {
				 composites[j] = true;
			 }
		 }
		 return count;
	 }
}
