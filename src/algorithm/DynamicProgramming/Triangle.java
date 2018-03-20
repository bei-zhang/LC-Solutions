package algorithm.DynamicProgramming;


/**
 * http://www.lintcode.com/en/problem/triangle
 * http://www.jiuzhang.com/solutions/triangle
 * 
 * 
 *
 */
public class Triangle {

	
	public class Solution1 {
	    /**
	     * @param triangle: a list of lists of integers.
	     * @return: An integer, minimum path sum.
	     */
	    public int minimumTotal(int[][] triangle) {
	        //Bottom-Up
	          if (triangle == null || triangle.length == 0) {
	            return -1;
	        }
	        if (triangle[0] == null || triangle[0].length == 0) {
	            return -1;
	        }
	        
	        // state: f[x][y] = minimum path value from x,y to bottom
	        int n = triangle.length;
	        int[][] f = new int[n][n];
	        
	        // initialize 
	        for (int i = 0; i < n; i++) {
	            f[n - 1][i] = triangle[n - 1][i];
	        }
	        
	        // bottom up
	        for (int i = n - 2; i >= 0; i--) {
	            for (int j = 0; j <= i; j++) {
	                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle[i][j];
	            }
	        }
	        
	        // answer
	        return f[0][0];
	        
	        
	    }
	}

	
	
}
