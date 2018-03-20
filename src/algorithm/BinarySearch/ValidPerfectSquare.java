package algorithm.BinarySearch;

public class ValidPerfectSquare {

	//binary search solution:  Time: O(log n)
	class Solution {
	    public boolean isPerfectSquare(int num) {
	        if(num<0) return false;
	        int start = 1, end = num;
	        long mid;
	        while(start + 1 < end){
	            mid = start + (end - start)/2;
	            if(mid * mid == num){
	                return true;
	            }else if(mid * mid < num){
	                start = (int)mid;
	            }else{
	                end = (int)mid;
	            }
	        }
	        if((start * start == num) || (end * end == num)){
	            return true;
	        }
	        return false;
	    }
	}
	
}
