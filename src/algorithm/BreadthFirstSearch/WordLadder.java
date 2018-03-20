package algorithm.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

http://www.lintcode.com/en/problem/word-ladder/
http://www.jiuzhang.com/solutions/word-ladder/
https://leetcode.com/problems/word-ladder/


 *
 */
public class WordLadder {

	//自己写的BFS solution (recommended)
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        if(wordList == null || wordList.size() ==0){
	            return 0;
	        }
	        
	        //为了能在LeetCode 上AC, 必须得把List<String> 转成 Set<String>, 
	        //because contains() method on HashSet takes O(1) time, whereas contains() in ArrayList takes O(n) time.
	       /* Set<String> dict = new HashSet<>();
	        for (String word : wordList) {
	            dict.add(word);
	        }*/
	        Set<String> dict = new HashSet<>(wordList);
	        
	        /////////////////////
	        
	        Queue<String> queue = new LinkedList<>();
	        Set<String> visisted =  new HashSet<>();
	        queue.offer(beginWord);
	        visisted.add(beginWord);
	        int len = 0;
	        while(!queue.isEmpty()){
	            len++;
	            int size = queue.size();
	            while(size-- >0){
	                String top = queue.poll();
	                for(String nextWord : getNextWords(top, dict)){
	                    if(visisted.contains(nextWord)){
	                        continue;
	                    }
	                    if(nextWord.equals(endWord)){
	                        return len +1;
	                    }
	                    queue.offer(nextWord);
	                    visisted.add(nextWord);
	                }
	            }
	        }
	        return 0;
	    }
	    
	    // get connections with given word.
	    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
	    // it will return ['hit', 'hog']
	    private List<String> getNextWords(String word, Set<String> wordList){
	        List<String> nextWords = new ArrayList<>();
	        char[] arr = word.toCharArray(); //String -> char[]
	        for(int i=0;i<arr.length;i++){
	        	char temp = arr[i]; //不要忘记keep it temporarily 
	            for(char c ='a' ; c <= 'z'; c++){
	                if(c == arr[i]){
	                    continue;
	                }
	                arr[i] = c; //replace character of a string at given index with a new character
	                String newWord = String.valueOf(arr); //char[] -> String to form a new word
	                if(wordList.contains(newWord))
	                    nextWords.add(newWord);
	            }
	            arr[i] = temp; //restore
	        }
	        return nextWords;
	    }
	}
   
   
	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();
		Solution s = wordLadder.new Solution();
		
				
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(s.ladderLength("hit", "cog", wordList));

	}

}
