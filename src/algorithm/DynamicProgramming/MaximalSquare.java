package algorithm.DynamicProgramming;

/**
 * 
 * http://www.lintcode.com/en/problem/maximal-square/
 * http://www.jiuzhang.com/solution/maximal-square/
 * 
 * 
 * DP 动态规划  O(n*m) time
 * 状态转移方程：
 * dp[x][y] = min(dp[x - 1][y - 1], dp[x][y - 1], dp[x - 1][y]) + 1
 * 上式中，dp[x][y]表示以坐标(x, y)为右下角元素的全1正方形矩阵的最大长度（宽度）
 * 如果当前点为0  则dp[x][y]就是0  肯定没有以0 为右下角元素的全1正方形
 *
 *
 *
 * 滚动数组 优化二维空间从O(n*m) 到O(m)  看下面Solution2. 
 *
 */
public class MaximalSquare {

	
	//O(n*m) time,  O(n*m) space
	public class Solution {
	    public int maxSquare(int[][] matrix) {
	        if(matrix == null || matrix.length ==0){
	            return 0;
	        }
	        int result = 0;
	        int n = matrix.length;
	        int m = matrix[0].length;
	        int[][] dp = new int[n][m]; // default 都是0 
	        
	        for(int i =0;i<n;i++){
	            dp[i][0] = matrix[i][0]; //初始化第一列
	            result = Math.max(result, dp[i][0]);
	            for(int j=1;j<m;j++){
	                if(i==0){//初始化第一行
	                    dp[0][j] = matrix[0][j]; 
	                    result = Math.max(result, dp[0][j]);
	                    continue;
	                }
	                if(matrix[i][j] == 1){
	                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
	                    result = Math.max(result, dp[i][j]);
	                }/*else{
	                	dp[i][j] = 0; //此处可以comment，因为new出来的 int array, default 都是0
	                }*/
	            }
	        }
	        
	       return result*result;
	    }
	}
	
	
	//O(n*m) time,  O(m) space
	public class Solution2 {
	    public int maxSquare(int[][] matrix) {
	        if(matrix == null || matrix.length ==0){
	            return 0;
	        }
	        int result = 0;
	        int n = matrix.length;
	        int m = matrix[0].length;
	        int[][] dp = new int[2][m]; // default 都是0 
	        
	        for(int i =0;i<n;i++){
	            dp[i%2][0] = matrix[i][0]; //初始化第一列
	            result = Math.max(result, dp[i%2][0]);
	            for(int j=1;j<m;j++){
	                if(i==0){//初始化第一行
	                    dp[0][j] = matrix[0][j]; 
	                    result = Math.max(result, dp[0][j]);
	                    continue;
	                }
	                if(matrix[i][j] == 1){
	                    dp[i%2][j] = Math.min(dp[(i-1)%2][j-1], Math.min(dp[i%2][j-1], dp[(i-1)%2][j])) + 1;
	                    result = Math.max(result, dp[i%2][j]);
	                }else{
	                	dp[i%2][j] = 0; //此行必须要，否则不能更新当前的值
	                }
	            }
	        }
	        
	       return result*result;
	    }
	}
	
	
	
	
	public static void main(String[] args) {

	}

}
