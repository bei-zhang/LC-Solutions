package algorithm.DynamicProgramming;


/**
 * 
 * http://www.lintcode.com/en/problem/minimum-path-sum/
 * http://www.jiuzhang.com/solution/minimum-path-sum
 * 
 *
 */
public class MinimumPathSum {

	class Solution {
	    /**
	     * @param grid: a list of lists of integers.
	     * @return: An integer, minimizes the sum of all numbers along its path
	     */
	    public int minPathSum(int[][] grid) {
	        if(grid == null ||  grid.length ==0 || grid[0].length == 0 ){
	            return 0;
	        }
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] minSum = new int[m][n];
	        
	        //initialization 
	        minSum[0][0] = grid[0][0];
	        for(int i=1;i<m;i++){
	           minSum[i][0] = minSum[i-1][0] + grid[i][0];
	        }
	        for(int i=1;i<n;i++){
	            minSum[0][i] = minSum[0][i-1] +  grid[0][i];
	        }
	        
	        //用上一步算的最小值来算当前最小值
	        for(int i=1; i<m;i++){
	            for(int j=1; j<n;j++){
	                minSum[i][j] = Math.min(minSum[i][j-1], minSum[i-1][j]) + grid[i][j];
	            }
	        }
	        
	        return minSum[m-1][n-1];
	        
	    }
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
