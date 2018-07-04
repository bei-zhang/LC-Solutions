package dataStructure.StringAndArray.Matrix;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * Similar: Search2DMatrix.java
 * 
 * 解题思路:
 * We start search the matrix from top right corner, 
 * initialize the current position to top right corner, 
 * if the target is greater than the value in current position, 
 * then the target can not be in entire row of current position because the row is sorted, 
 * if the target is less than the value in current position, 
 * then the target can not in the entire column because the column is sorted too.
 *  We can rule out one row or one column each time, so the time complexity is O(m+n).
 * 
 */
public class Search2DMatrixII {
	//Best concise solution:  divide and conquer method
	//Time complexity: O(m+n),  Space complexity: O(1)
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
