package dataStructure.StringAndArray;

/**
 * 
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 * http://www.jiuzhang.com/solution/sparse-matrix-multiplication
 * http://www.programcreek.com/2014/10/leetcode-sparse-matrix-multiplication-java/
 * 
 *
 */
public class SparseMatrixMultiplication {

	//Naive solution
	public class Solution1 {
	    public int[][] multiply(int[][] A, int[][] B) {
	        int[][] ans = new int[A.length][B[0].length];
	        for (int i = 0; i < A.length; i++) {
	            for (int j = 0; j < B[0].length; j++) {
	                for (int k = 0; k < A[i].length; k++) {
	                    ans[i][j] += A[i][k] * B[k][j];
	                }
	            }
	        }
	        return ans;
	    }
	}

	//Optimized solution
	public class Solution {
	    public int[][] multiply(int[][] A, int[][] B) {
	        int[][] ans = new int[A.length][B[0].length];

	        for (int i = 0; i < A.length; i++) {
	            for (int k = 0; k < A[i].length; k++) {
	                if (A[i][k] == 0) {
	                    continue;
	                }
	                for (int j = 0; j < B[0].length; j++) {
	                    ans[i][j] += A[i][k] * B[k][j];
	                }
	            }
	        }
	        return ans;
	    }
	}

	
	
	
	
	public static void main(String[] args) {

	}

}
