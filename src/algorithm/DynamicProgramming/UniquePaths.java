package algorithm.DynamicProgramming;


/**
 * 
 * A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?

 * http://www.lintcode.com/en/problem/unique-paths/
 * http://www.jiuzhang.com/solutions/unique-paths/
 * 
 *
 */
public class UniquePaths {
	
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        //杨辉三角形 Pascal's Triangle
        if (m == 0 || n == 0) {
            return 1;
        }
    //*******经典动 动态规划题目，  动规四要素*********       
        //1. state: f[x][y] 从起点到x,y的路径数
        int[][] f = new int[m][n];
        
        //2. initialize: f[0][i] = 1,   f[i][0] =1 
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        
        //3. function:  f[x][y] = f[x-1][y] + f[x][y-1] 
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        
        //4. answer 
        return f[m - 1][n - 1];
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
