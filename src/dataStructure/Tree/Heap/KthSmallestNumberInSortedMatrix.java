package dataStructure.Tree.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
 * 
 *
 */
public class KthSmallestNumberInSortedMatrix {

	   
    class Coordinate{
		int x, y , val;
		public Coordinate(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
    
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
		if(matrix == null || matrix.length ==0){
			return -1;
		}
        
		Queue<Coordinate> minHeap = new PriorityQueue<>(k, new Comparator<Coordinate>(){
			public int compare(Coordinate a, Coordinate b){
				return a.val - b.val;
			}
		});
		minHeap.offer(new Coordinate(0,0, matrix[0][0]));
		int count = 0;
		int m = matrix.length, n = matrix[0].length;
		int[] deltaX ={1, 0};
		int[] deltaY ={0, 1};
		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		while(!minHeap.isEmpty() && count <k){
			Coordinate coor = minHeap.poll();
			count++;
			if(count == k){
				return coor.val;
			}
			for(int i=0; i<2;i++){
			    int newX = coor.x + deltaX[i];
			    int newY = coor.y + deltaY[i];
			    if(newX < m  && newY < n && !visited[newX][newY]){
			        visited[newX][newY] = true;
			        minHeap.offer(new Coordinate(newX, newY , matrix[newX][newY]));
			    }
				
			}
			
			
		}
		
		return 0;
		
    }

    
	public static void main(String[] args) {
		int[][] input = {{1,5,7},{3,7,8},{4,8,9}};
		KthSmallestNumberInSortedMatrix instance = new KthSmallestNumberInSortedMatrix();
		System.out.println(instance.kthSmallest(input, 7));;
	}

}
