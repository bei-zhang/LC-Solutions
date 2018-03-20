package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 * 
 *
 */
public class NumberOfDistinctIslands {
 //新题目
	class Solution {
	    private int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	    public int numDistinctIslands(int[][] grid) {
	        int m = grid.length, n = grid[0].length;
	        Set<List<List<Integer>>> islands = new HashSet<>();
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                List<List<Integer>> island = new ArrayList<>();
	                if (dfs(i, j, i, j, grid, m, n, island))
	                    islands.add(island);
	            }
	        }
	        return islands.size();
	    }

	    private boolean dfs(int i0, int j0, int i, int j, int[][] grid, int m, int n, List<List<Integer>> island) {
	        if (i < 0 || m <= i || j < 0 || n <= j || grid[i][j] <= 0) return false;
	        island.add(Arrays.asList(i - i0, j - j0));
	        grid[i][j] *= -1;
	        for (int d = 0; d < 4; d++) {
	            dfs(i0, j0, i + delta[d][0], j + delta[d][1], grid, m, n, island);
	        }
	        return true;
	    }    
	}
}
