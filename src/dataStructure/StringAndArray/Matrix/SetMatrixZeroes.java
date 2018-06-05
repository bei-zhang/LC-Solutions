package dataStructure.StringAndArray.Matrix;

//Do it in place
public class SetMatrixZeroes {
	
	//Best solution:   O(m*n) Time,   O(1) Space
    //using extra O(m+n) space is easy, to enable O(1), we have to use the space within the matrix 
	public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        // Determine if the first row should be Zero.
        for(int i=0; i<n;i++) {
        	if(matrix[0][i] == 0) {
        		firstRowZero = true;
        		break;
        	}
        }
        //Determine if the first column should be Zero.
        for(int i=0; i<m;i++) {
        	if(matrix[i][0] == 0) {
        		firstColZero = true;
        		break;
        	}
        }
        
        // we use the first row and the first column as the flag to record the cells whether or not set to 0.
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                	matrix[i][0] = 0;
                	matrix[0][j] = 0;
                }
            }
        }
        
        //set the inner cells. Be careful: i, j start from 1.
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j]  ==0){
                	matrix[i][j] = 0;
                }
            }
        }
        
        //set the first row
        if(firstRowZero) {
            for(int i=0;i<n;i++){
                matrix[0][i] = 0;
            }
        }
        
        //set the first col
        if(firstColZero) {
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
        
	}
	
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		int[][] matrix = {{1,0,1},{1,2,3}};
		s.setZeroes(matrix);

	}
}

//A simple solution using O(m + n) space, but not the best solution.
// O(m*n) Time,      O(m + n) Space
class Solution2 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[] rowZero = new boolean[m];
        boolean[] colZero = new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(rowZero[i]){
                setRowZeros(matrix, i);
            }
        }
        for(int i=0;i<n;i++){
            if(colZero[i]){
                setColZeros(matrix, i);
            }
        }
        
    }
    
    private void setRowZeros(int[][] matrix, int row){
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i] = 0;
        }
    }
    
    private void setColZeros(int[][] matrix, int col){
        for(int i=0;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
    }
    
}

