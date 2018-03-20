package algorithm.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * https://leetcode.com/problems/number-of-islands/
 * http://www.lintcode.com/en/problem/number-of-islands/
 * http://www.jiuzhang.com/solutions/number-of-islands/
 * 
 * Flood fill algorithms
 * It uses BSF.
 *
 */
public class NumberofIslands {
	//grid a boolean 2D matrix  - false (sea) and true (island)
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length ==0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]){
                	//use BFS every time when it's an island.
                    markByBFS(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }
    
    //Check the 4 adjacent neighbors (up/down/left/right), mark them to 0 if it's 1.
    private void markByBFS(boolean[][] grid, int x, int y){
    	//relative coordinates for the 4 adjacent neighbors (up/down/left/right)
        int[] deltaX = {-1,1,0,0};
        int[] deltaY = {0,0,-1,1};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x,y));
        grid[x][y] = false;
        while(!queue.isEmpty()){
             Coordinate co = queue.poll();
             //loop the 4 adjacent neighbors
             for(int i=0;i<deltaX.length;i++){
                 Coordinate adj = new Coordinate(co.x+ deltaX[i], co.y + deltaY[i]);
                 //check if it's an island
                 if(isIsland(grid, adj)){
                	 grid[adj.x][adj.y] = false;
                	 queue.offer(adj);
                 }
             }
        }
    }

    private boolean isIsland(boolean[][] grid, Coordinate adj){
        int n = grid.length;
        int m = grid[0].length;
        //make sure it's inbound.
        if(adj.x >= 0 && adj.x < n && adj.y >= 0 && adj.y < m){
        	return grid[adj.x][adj.y];
        }
        return false;
    }
    
    class Coordinate {
       int x, y;
       public Coordinate(int x, int y){
           this.x = x;
           this.y =y;
       }
    }
    
    
}
