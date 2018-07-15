package dataStructure.Tree.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LC#378. Kth Smallest Element in a Sorted Matrix
 * http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * 
 * 类似问题:  KthLargestElement.java, TopKLargestNumbers.java, Search2DMatrixII.java
 *
 */
public class KthSmallestNumberInSortedMatrix {

	//Solution 1 : Heap.  It's actually Best First Search algorithm.
	//Time: O(n*m*logk)
    public int kthSmallest(int[][] matrix, int k) {
		if(matrix == null || matrix.length ==0){
			return -1;
		}
        
		/*Queue<Coordinate> minHeap = new PriorityQueue<>(k, new Comparator<Coordinate>(){
			public int compare(Coordinate a, Coordinate b){
				return a.val - b.val;
			}
		});*/
		Queue<Coordinate> minHeap = new PriorityQueue<>(k, (a,b) -> a.val - b.val);
		
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

class Coordinate{
	int x, y , val;
	public Coordinate(int x, int y, int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

////////////////////
//Solution 2 : Binary Search
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
class solution2{
	 public int kthSmallest(int[][] matrix, int k) {
	        // num of rows and cols in matrix
	        int rows = matrix.length, cols = matrix[0].length;
	        // get the lowest and highest possible num, will shrink search space according to the two nums
	        // [lo, hi] is our initial search range
	        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
	        while(lo <= hi) {
	            int mid = lo + (hi - lo) / 2;
	            int count = 0,  maxNum = lo;
	            // for each row, we r going to find # of nums < mid in that row
	            for (int r = 0, c = cols - 1; r < rows; r++) {
	                while (c >= 0 && matrix[r][c] > mid) c--;   // this row's c has to be smaller than the c found in last row due to the sorted property of the matrix 
	                if (c >= 0) {
	                    count += (c + 1); // count of nums <= mid in matrix
	                    maxNum = Math.max(maxNum, matrix[r][c]); // mid might be value not in matrix, we need to record the actually max num;
	                }
	            }
	            // adjust search range
	            if (count == k) return maxNum;
	            else if (count < k) lo = mid + 1;
	            else hi = mid - 1;
	        }
	        // 1) Q: Why we return lo at the end:
	        //    A: Here lo=hi+1, for hi, we found <k elems, for lo, we found >=k elem, lo must have duplicates in matrix, return lo
	        // 2) Q: Why lo exist in the matrix
	        //    A: for lo which is only 1 more than hi, we could find some extra nums in matrix so that there r >=k elems, so lo it self must exist in the matrix to meet the requirement
	        return lo;
	    }
} 
