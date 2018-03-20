package dataStructure.StringAndArray;

/**
 * LeetCode #48, CTCI 1.6
 * Rotate Image
 * http://www.lintcode.com/en/problem/rotate-image/#
 * https://leetcode.com/problems/rotate-image/
 *http://www.cnblogs.com/yuzhangcmu/p/4050891.html
 *
 *
 * 	You are given an n x n 2D matrix representing an image.
	Rotate the image by 90 degrees (clockwise).

	Follow up:
	Could you do this in-place?

 * 
 * 经验总结: 数组问题如果要在 in-place 解决，那只能swap elements.  e.g. swap(a,b)
 * 
 *
 *The idea is for each square cycle (each layer), we swap the elements involved with the corresponding cell
 * in the matrix in same ration direction (clockwise).
 * i.e. from left to top, bottom to left, right to bottom and from top to right one at a time. 
 * We use nothing but a temporary variable to achieve this.
 *
 */
public class RotateImage {
	
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length ==0){
            return;
        }
        int n = matrix.length;
        for(int layer=0; layer<n/2 ;layer++){
            int end = n-1 - layer;
            for(int i=layer; i<end;i++ ){
                int offset = i - layer;
                
                //Do 4-way element swap
                int temp = matrix[layer][i]; //save top
                //left -> top
                matrix[layer][i] = matrix[end - offset][layer];
                //bottom -> left
                matrix[end - offset][layer] = matrix[end][end -offset];
                //right -> bottom
                matrix[end][end -offset] = matrix[i][end];
                //top -> right
                matrix[i][end ] = temp;
                
            }
        }
        
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix=new int[4][4];
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				matrix[i][j]='*';
			}
		}
		matrix[2][0]='-';
		matrix[2][1]='-';
		matrix[2][2]='-';
		matrix[2][3]='>';
		
		matrix[3][0]='*';
		matrix[3][1]='*';
		matrix[3][2]='*';
		matrix[3][3]='*';
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print((char)matrix[i][j]);
			}
			System.out.print('\r');
		}
		
		
		System.out.println("After the image is rotated:");
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print((char)matrix[i][j]);
			}
			System.out.print('\r');
		}

	}

}
