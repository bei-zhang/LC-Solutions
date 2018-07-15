package algorithm.Math;

/**
 * 263. Ugly Number
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 */
public class UglyNumber {
	//iterative solution (Recommended)
	class Solution {
		public boolean isUgly(int num) {
			while (num > 1) {
				if (num % 2 == 0) {
					num /= 2;
					continue;
				} else if (num % 3 == 0) {
					num /= 3;
					continue;
				} else if (num % 5 == 0) {
					num /= 5;
					continue;
				}
				break;
			}
			return num == 1;
		}
	}
	
	//recursive solution
	class Solution2 {
	    public boolean isUgly(int num) {
	        if(num ==0) return false; //corner case
	        if(num ==1) return true; //base case
	        if(num % 2 == 0){        
	            return isUgly(num/2);
	        } else if(num % 3 == 0){        
	            return isUgly(num/3);
	        } else if(num % 5 == 0){        
	            return isUgly(num/5);
	        }
	        return false;
	    }
	}
	
}
