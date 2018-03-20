package algorithm.Math;


/**
 * 
 * 
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 * 

  如果不能用Math.sqrt() method,那就用 binary search 先求出sqrt 的值, 参见另一题: Sqrt, 这部分的time complexity is O(log n)
  整体的time complexity 是 O(log n) +  O(sqrt(n)), 所以仍然是 O(sqrt(n)) 因为 O(sqrt(n))  > O(log n)
   
解题思路： 先定出可能范围，然后 用two pointers 缩小范围
 */
public class SumOfSquareNumbers {

	//Two pointers solution
	//Time: O(sqrt(n))
	class Solution {
	    public boolean judgeSquareSum(int n) {
	        if(n <0) return false;
	        int left =0;
	        int right = (int)Math.sqrt(n); //Use binary search to get sqrt if Math.sqrt() cannot be used.
	        while(left <=right){
	            int sum = left * left + right * right;
	            if(sum == n){
	                return true;
	            }else if(sum < n){
	                left++;
	            }else{
	                right--;
	            }
	        }
	        return false;
	    }
	}
	
	public static void main(String[] args) {

	}

}
