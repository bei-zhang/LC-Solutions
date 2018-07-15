package dataStructure.StringAndArray.Matrix;

/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * 
 * This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right. 
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * 
 * https://www.lintcode.com/en/problem/search-a-2d-matrix/
 * 
 * Follow up: Search2DMatrixII.java
 */
public class Search2DMatrix {
	//Best Solution: Binary Search once
	//思路: Don't treat it as a 2D matrix, just treat it as a sorted list
	//m * n matrix convert to an array => matrix[x][y] => a[x * n + y]
	//an array convert to m * n matrix => a[x] =>matrix[x / n][x % n];
	//Time:O(log(m*n))
	public class Solution1 {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return false;
	        }
	        int row = matrix.length, column = matrix[0].length;
	        int start = 0, end = row * column - 1;
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            int number = matrix[mid / column][mid % column];
	            if (number == target) {
	                return true;
	            } else if (number < target) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	        
	        if (matrix[start / column][start % column] == target) {
	            return true;
	        }
	        if (matrix[end / column][end % column] == target) {
	            return true;
	        }
	        
	        return false;
		 }
	}
	
	
	//Simple solution: Apply Binary Search Twice
	//Time:O(logm + logn)  = O(log(m*n)) same time complexity as solution 1
	public class Solution2 {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix==null || matrix.length == 0 || matrix[0].length==0){
	            return false;
	        }
	        int rows = matrix.length;
	        
	        //first binary search to find which row the target resides. 
	        int start=0, end = rows-1;
	        while (start + 1 < end){
	            int mid = start + (end-start)/2;
	            if(matrix[mid][0] == target){
	                return true;
	            }else if (matrix[mid][0] > target){
	                end = mid;
	            }else {
	                start = mid;
	            }
	            
	        }
	        
	        if(matrix[end][0] == target){
	            return true;
	        }else if (matrix[end][0] > target){
	            return binarySearch (matrix[start], target);
	        }else {
	           return binarySearch(matrix[end], target);
	        }
	        
	        
	    }
	    //second binary search to find the target in the row.
	    private boolean binarySearch(int[] A, int target){
	        if(A==null || A.length ==0){
	            return false;
	        }
	        int start=0,end = A.length -1;
	        while (start+1 < end){
	            int mid = start + (end -start)/2;
	            if (A[mid] == target){
	                return true;
	            }else if (A[mid] > target){
	                end =mid;
	            }else{
	                start = mid;
	            }
	        }
	        if(A[start] == target  || A[end] == target){
	            return true;
	        }
	        return false;
	        
	    }
	}
	
	

	
	public static void main(String[] args) {

		int[][] matrix = {{2,3,4,6},{7,8,10,12},{15,18,20}};
		
		 System.out.println(matrix.length);
		 System.out.println(matrix[0].length);
		 System.out.println(matrix[2].length);

	}

}
