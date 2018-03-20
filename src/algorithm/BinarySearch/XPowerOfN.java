package algorithm.BinarySearch;

/**
 * https://leetcode.com/problems/powx-n/#/description
 * http://www.lintcode.com/en/problem/powx-n/
 * 
 *
 */
public class XPowerOfN {

	//Divide and Conquer (recursive): calculates power(x, n/2) only once and store it.
	//Time Complexity: O(logn), Space Complexity: O(1)
	public class Solution1 {
	    public double myPow(double x, int n) {
	        if(n==0) 
	        	return 1;
	        double temp = myPow(x, n/2); 
	        if(n%2 == 0){
	            return temp*temp;
	        }else{
	            if(n>0){
	                return temp*temp*x;
	            }else{//注意n<0的情况
	                return temp*temp/x;
	            }
	        }
	                
	    }
	}
	
	//iterative
	public class Solution2 {
	    public double myPow(double x, int n) {
	        boolean negative = n<0;
	        double ans = 1.0;
	        while(n != 0){
	            if(n%2 !=0)
	                ans*=x;
	            x*=x;
	            n/=2;
	        }
	        return negative ? 1 / ans : ans;
	    }
	}
	
}
