package algorithm.DynamicProgramming;

public class JumpGame {

	
	
	//DP solution.   O(n^2) time.   Better solution is Greedy with O(n) time.
	static class Solution {
	    /**
	     * @param A: A list of integers
	     * @return: The boolean answer
	     */
	    public static boolean canJump(int[] A) {
	        if(A == null || A.length ==0){
	            return false;
	        }
	        int n = A.length;
	        if(n==1){
	            return true;
	        }
	        
	        boolean[] canJump = new boolean[n];
	        canJump[n-1] = true;
	        for(int i=n-2; i>=0; i--){
	            if(A[i] >0){
	                for(int j=i+1; j-i<=A[i]; j++){
	                    if(canJump[j]){
	                        canJump[i] = true;
	                        break;
	                    }
	                }
	            }else{
	                canJump[i] =false;
	            }

	        }
	        
	        return canJump[0];
	        
	    }
	}

	
	
	public static void main(String[] args) {
		int[] A = {5,8,3,0,6,7,9,6,3,4,5,2,0,6,2,6,7,10,8,0};
		Solution.canJump(A);

	}

}
