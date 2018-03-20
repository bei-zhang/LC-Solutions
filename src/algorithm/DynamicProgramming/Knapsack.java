package algorithm.DynamicProgramming;

/**
 * 
 * Given n items with size Ai, an integer m denotes the size of a backpack. 
 * How full you can fill this backpack? 
 * 
 * http://www.lintcode.com/en/problem/backpack/
 * http://www.jiuzhang.com/solution/backpack
 * 
 *
 */
public class Knapsack {

	public class Solution {
	    /**
	     * @param m: An integer m denotes the size of a backpack
	     * @param A: Given n items with size A[i]
	     * @return: The maximum size
	     */
	    public int backPack(int m, int[] A) {
	        if(A == null | A.length ==0 || m<1){
	            return 0;
	        }
	        int n = A.length;
	        boolean[][] dp = new boolean[n+1][m+1];
	        for(int i=0;i<=n;i++){
	            dp[i][0] = true;
	        }
	        
	        for(int i=1; i<=n;i++){
	            for(int j=1; j<=m;j++){
	                dp[i][j] = dp[i-1][j];
	                if(j >= A[i-1] && dp[i-1][j- A[i-1]]){
	                    dp[i][j] = true;
	                }
	            }
	        }
	        
	        for(int j=m; j>=0;j--){
	            if(dp[n][j]){
	                return j;
	            }
	        }
	        
	        return 0;
	    }
	}
	
	
}
