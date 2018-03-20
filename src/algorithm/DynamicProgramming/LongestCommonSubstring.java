package algorithm.DynamicProgramming;


/**
 * Given two strings, find the longest common substring.
 * 
 * http://www.lintcode.com/en/problem/longest-common-substring/
 * http://www.jiuzhang.com/solution/longest-common-substring/
 * 
 * 动规DP 
 * 状态： dp[i][j] 表示以A[i-1]和 B[j-1] 结尾的 common substring的长度
 * 
 * 
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        if( A==null || B ==null || A.length() ==0 || B.length() ==0){
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        // initialize: dp[i][j] is 0 by default

        int longest =0;
        for(int i=1; i<=n;i++){
            for(int j=1; j<=m;j++){
            	//动规的方程
                if(A.charAt(i-1) == B.charAt(j-1)){  
                    dp[i][j] = dp[i-1][j-1] +1;
                    longest = Math.max(longest, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return longest;
    }
    
    
}
