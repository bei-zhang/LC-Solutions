package algorithm.DynamicProgramming;

/**
 * http://www.lintcode.com/en/problem/longest-common-subsequence/
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * 
 * 
 *匹配型 DP
 * 动规的 状态  dp[i][j] 表示前 i 个字符 配上 前 j个字符的LCS 的长度
 *
 */
public class LongestCommonSubsequence {

    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if( A==null || B ==null || A.length() ==0 || B.length() ==0){
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        // initialize: dp[i][j] is 0 by default
        
        
        for(int i=1; i<=n;i++){
            for(int j=1; j<=m;j++){
            	//动规的方程
            	dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(A.charAt(i-1) == B.charAt(j-1)){  
                    dp[i][j] = Math.max(dp[i-1][j-1] +1, dp[i][j]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    
	public static void main(String[] args) {

	}

}
