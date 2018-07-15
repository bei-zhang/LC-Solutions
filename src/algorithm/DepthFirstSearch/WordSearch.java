package algorithm.DepthFirstSearch;

/**
 * LC# 79. Word Search
 * https://www.jiuzhang.com/solution/word-search/
 * http://www.cnblogs.com/yuzhangcmu/p/4040418.html
 * 
 * 常考题目    (Apptio interview question I got during on-site on 9/25/2017)
 * Loop each char in the given 2D board, 找到开头第一个字母，然后递归
 * Just use recursion to implement it. no special data structure used.
 * 
 * Follow up:  see {WordSearchII.java} which uses DFS + Trie 
 */
public class WordSearch {
	//DFS solution:  time complexity:  m*n*4^(k-1). 也就是m*n*4^k.
	//m X n is board size, k is the size of  word.
	class Solution {
	    public boolean exist(char[][] board, String word) {
	        if(board == null || board.length ==0 || word == null || word.length() ==0){
	            return false;
	        }
	        for(int i=0; i<board.length; i++){
	            for(int j=0; j<board[0].length;j++){
	                if(board[i][j] == word.charAt(0)){//找到开头第一个字母，然后递归
	                    if(dfsSearch(board, i, j, word, 1)){ 
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }
	    
	    //DFS: 此DFS 有  K levels(k : size of  word)， 每一层有个4 branches (判断上下左右的char)
	    private boolean dfsSearch(char[][] board, int x, int y, String word, int pos){
	        if(pos == word.length()){
	            return true;
	        }
	        // remember to mark it as visited. No need extra matrix to track visited. 
	        board[x][y] = '#'; 
	        int[] deltaX = {-1,1,0,0};
	        int[] deltaY = {0,0, 1,-1};
	        for(int i=0; i<4;i++){
	            int newX = deltaX[i] + x;
	            int newY = deltaY[i] + y;
	            if(newX>=0 && newX<board.length && newY>=0 && newY< board[0].length 
	                        && board[newX][newY] != '#'
	                        && board[newX][newY] == word.charAt(pos)){
	                if(dfsSearch(board, newX, newY, word, pos+1)){
	                    return true;
	                }
	            }
	        }
	        //执行到这一步，意味着此路不通，需要返回到上一层再去找其他路径
	        board[x][y] = word.charAt(pos-1); //backtracking, restore it to original character
	        return false;
	    }
	    
	}
	
	public static void main(String[] args) {

	}

}
