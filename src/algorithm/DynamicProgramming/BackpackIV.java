package algorithm.DynamicProgramming;

public class BackpackIV {

	public class Solution {
	    /**
	     * @param nums an integer array and all positive numbers, no duplicates
	     * @param target an integer
	     * @return an integer
	     */
	    public int backPackIV(int[] nums, int target) {
	        if(nums == null || nums.length ==0 || target <1){
	            return 0;
	        }
	        int n = nums.length;
	        int[][] dp = new int[n+1][target+1];
	        //initialize 
	        for(int i=0; i<=n;i++){
	            dp[i][0] = 1;
	        }
	        
	        for(int i=1; i<=n;i++){
	            for(int j=1; j<=target;j++){
	                int k = 0; 
	                while(k * nums[i-1] <= j) {
	                    dp[i][j] += dp[i-1][j-nums[i-1]*k]; //DP 方程
	                    k++;
	                }

	            }
	        }
	        return dp[n][target];
	    }
	}
	
}
