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

LC# 127. Word Ladder


Follow-up: WordLadderII

 */
public class WordLadder {
	//最短路径问题 -  自己写的BFS solution (recommended)
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        if(wordList == null || wordList.size() ==0) return 0;
	        //为了能在LeetCode 上AC, 必须得把List<String> 转成 Set<String>, 
	        //因为 contains() method takes O(n) time on ArrayList but only O(1) time on HashSet
	        Set<String> dict = new HashSet<>(wordList);
	        Queue<String> queue = new LinkedList<>();
	        Set<String> visisted =  new HashSet<>();
	        queue.offer(beginWord);
	        visisted.add(beginWord);
	        int level = 1;
	        while(!queue.isEmpty()){
	            int size = queue.size(); //需要按层记录
	            while(size-- >0){
	                String curWord = queue.poll();
	                List<String> neighbors = getNeighbors(curWord, dict);
	                for(String nextWord : neighbors){
	                    if(visisted.contains(nextWord))  continue;
	                    if(nextWord.equals(endWord)){
	                        return level +1;
	                    }
	                    queue.offer(nextWord);
	                    visisted.add(nextWord);
	                }
	            }
	            level++; //注意每一层结束要加1
	        }
	        return 0;
	    }
	    
	    // get all neighbors (所有可能演变来的words) by given word.  
	    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog', 'dog'}
	    // it will return ['hit', 'hog']
	    private List<String> getNeighbors(String word, Set<String> wordList){
	        List<String> nextWords = new ArrayList<>();
	        char[] arr = word.toCharArray(); //String -> char[]
	        for(int i=0;i<arr.length;i++){
	        	char temp = arr[i]; //不要忘记keep it temporarily 
	            for(char c ='a' ; c <= 'z'; c++){
	                if(c == arr[i]) continue;
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
