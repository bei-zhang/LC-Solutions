package algorithm.DynamicProgramming;

/**
 * 
 * Given n items with size Ai and value Vi, and a backpack with size m. 
 * What's the maximum value can you put into the backpack?
 * 
 * 
 * http://www.lintcode.com/en/problem/backpack-ii/
 * 
 * 
 * DP 
 * 状态： dp[i][j] 表示前i 个物品当中选一些物品组成容量为j 的最大价值
 * 
 * 可以用滚动数组来优化空间
 * 
 */
public class BackpackII {

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        //dp[i][j] 表示前i 个物品当中选一些物品组成容量为j 的最大价值
        int n = A.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1; j<=m;j++){
                if(j>=A[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j- A[i-1]] + V[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        return dp[n][m];
    }
    
    
}
