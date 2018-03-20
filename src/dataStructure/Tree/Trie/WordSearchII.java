package dataStructure.Tree.Trie;

import java.util.ArrayList;


/**
 * http://www.lintcode.com/en/problem/word-search-ii/
 * http://www.jiuzhang.com/solution/word-search-ii
 * http://blog.csdn.net/ljiabin/article/details/45846527
 * 
 * 
 *
 */
public class WordSearchII {

	
	//下面是我的solution， only 51% test cases passed.
	public class Solution {
	    /**
	     * @param board: A list of lists of character
	     * @param words: A list of string
	     * @return: A list of string
	     */
	    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
	        // write your code here
			ArrayList<String> result = new ArrayList<>();
			if(board == null || board.length ==0 || words == null || words.size()==0){
				return result;
			}
			Trie trie = new Trie();
			for(String word : words){
				trie.addWord(word);
			}
			
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					dfsHelper(board, i, j,trie.root, result);
				}
			}
			return result;
	    }
		
		//递归的定义：找到以点board[x][y]开头的word， 然后加入到result里面
		private void dfsHelper(char[][] board, int x, int y, TrieNode parent,  ArrayList<String> result){
			if(parent.isEnd && !result.contains(parent.str)){
				result.add(parent.str);
				return;
			}
			
			TrieNode current = parent.children[board[x][y] - 'a'];
			if(current == null){
				return;
			}
			
			if(current.isEnd && !result.contains(current.str)){
				result.add(current.str);
				return;
			}
			
			char temp = board[x][y];
			board[x][y] = '0'; // mark it as visited
						
			int[] deltaX = {-1,1,0,0};
			int[] deltaY = {0,0,-1,1};
			for(int i=0;i<4; i++){
				int newX = x + deltaX[i];
				int newY = y + deltaY[i];
				if(newX>=0 && newX <board.length && newY>=0 && newY<board[0].length && board[newX][newY] !='0'){
						dfsHelper(board,newX,newY,current,result);
				}
			}
			
			board[x][y] = temp; //reset after checking the 4 neighbors
			
		}
		
		
		class TrieNode{
			TrieNode[] children = null;
			boolean isEnd;
			String str;
			public TrieNode(){
				this.children = new TrieNode[26];
				this.isEnd = false;
				str="";
			}
			
		}
		
		class Trie{
			TrieNode root;
			public Trie(){
				this.root = new TrieNode();
			}
			
		
			 // add a word into the trie.
			public void addWord(String word) {
				if(word == null || word.length() ==0){
					return;
				}
				TrieNode p = root;
				for(int i=0; i< word.length() ; i++){
					char c = word.charAt(i);
					int index = c - 'a';
					if(p.children[index] == null){
						 TrieNode temp = new TrieNode();
						 temp.str = p.str + c;
						 p.children[index] =temp;
						 p = temp;
					}else{
						p = p.children[index];
					}
					
				}
				p.isEnd = true;
	        
			}
			
		
		}
		
		
	}
	
	
	public static void main(String[] args) {
		WordSearchII wordSearch = new WordSearchII();
		Solution solution = wordSearch.new Solution();
		char[][] board = {{'a','b','c','e'}, {'s','f','e','s'}, {'a','d','e','e'}};
		ArrayList<String> words = new ArrayList<> ();
		words.add("abceseeefs");
		words.add("abceseedasfe");
		solution.wordSearchII(board, words);

	}

}
