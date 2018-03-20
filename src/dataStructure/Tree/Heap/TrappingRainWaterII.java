package dataStructure.Tree.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * http://www.lintcode.com/en/problem/trapping-rain-water-ii/
 * http://www.jiuzhang.com/solution/trapping-rain-water-ii
 * 
 * 解题技巧： ****从外向内遍历*****
 * 
 * Matrix 从外向内遍历小技巧
 * 
 *
 */
public class TrappingRainWaterII {
	public class Solution {
	    /**
	     * @param heights: a matrix of integers
	     * @return: an integer
	     */
	    public int trapRainWater(int[][] heights) {
	        if(heights == null || heights.length <3 || heights[0].length <3){
	            return 0;
	        }
	        int n = heights.length;
	        int m = heights[0].length;
	        boolean[][] visited = new boolean[n][m];
	        //Starting Java 8, no need to specify INITIAL_CAPACITY
	        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>(){
	            public int compare(Cell c1, Cell c2){
	                return c1.h - c2.h;
	            }
	            
	        });
	        
	        //initialize 加入外围所有Cell到Heap里.   
	        for(int i=0; i<n; i++){
	            minHeap.offer( new Cell(i, 0, heights[i][0]) );
	            minHeap.offer( new Cell(i, m-1, heights[i][m-1]) );
	            //凡是加入到Heap里面的元素，都要mark it visited
	            visited[i][0] = true; 
	            visited[i][m-1] = true;
	            
	        }
	        for(int i=1; i<m-1; i++){
	            minHeap.offer( new Cell(0, i, heights[0][i]) );
	            minHeap.offer( new Cell(n-1, i, heights[n-1][i]) );
	            visited[0][i] = true;
	            visited[n-1][i] = true;
	        }
	        
	        int[] delatX = {-1,1,0,0};
	        int[] deltaY = {0,0, 1, -1};
	        
	        int result =0;
	        while(!minHeap.isEmpty()){
	            Cell min = minHeap.poll();
	            for(int i=0; i<4;i++){
	                int newX = min.x + delatX[i];
	                int newY = min.y + deltaY[i];
	                if(isValidPosition(newX,newY,n,m)  && !visited[newX][newY]){
	                    visited[newX][newY] = true;
	                    /**
	                     * 类似一维数组那道题目一样 {@code TrappingRainWater.java},  不断跟新外围柱子高度
	                     */
	                    int height = Math.max(min.h, heights[newX][newY]);
	                    //注意: 此处 new Cell的高度不是自身柱子的高度，而是外围柱子的高度(决定灌水的基调)
	                    minHeap.offer(new Cell(newX,newY, height));
	                    result+= height - heights[newX][newY];
	                }
	            }
	            
	        }
	        
	        return result;
	        
	    }
	    
	    private boolean isValidPosition(int x, int y, int n, int m){
	        return (x>= 0 && x <n && y >=0 && y<m);
	    }
	    
	    
	    //定义三元组 object来存储 坐标和高度
	    class Cell{
	        int x, y, h;
	        public Cell(int x, int y, int h){
	            this.x = x;
	            this.y = y;
	            this.h= h;
	        }
	    }
	    
	}
	
	

}
