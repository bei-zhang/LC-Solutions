package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. 
 * The only difference is now you are given the list of words and 
 * your method will be called repeatedly many times with different parameters.
 *  How would you optimize it?
 * 
 * https://leetcode.com/problems/shortest-word-distance-ii/
 *
 * Related problems: ShortestWordDistance, ShortestWordDistanceIII
 *
 *解题思路： Use HashMap to save a list of indexes for each word
 *
 *  With Optimized method, Time complexity is O(M+N), Space complexity is O(n) because we use HashMap
 *  
 */
public class ShortestWordDistanceII {

	public class WordDistance {
	    private Map<String, List<Integer>> wordsIndexMap;

	    //Time complexity for constructor is O(n), Space complexity is O(n)
	    // n is the number of words in the array.
	    public WordDistance(String[] words) {        
	        wordsIndexMap = new HashMap<>();
	        for(int i=0; i<words.length;i++){
	            if(wordsIndexMap.containsKey(words[i])){
	            	wordsIndexMap.get(words[i]).add(i);
	            }else{
	                List<Integer> list = new ArrayList<>();
	                list.add(i);
	                wordsIndexMap.put(words[i], list);
	            }
	            
	        }
	        
	    }
	    
	    //#1  Time complexity is O(MN), but this method can be optimized. See method shortest2() 
	    public int shortest(String word1, String word2) {
	        List<Integer> list1 = wordsIndexMap.get(word1);
	        List<Integer> list2 = wordsIndexMap.get(word2);
	        int shortest = Integer.MAX_VALUE;
	        for(int pos1 : list1){
	            for(int pos2 : list2){
	                shortest = Math.min(shortest, Math.abs(pos1 - pos2));
	            }
	        }
	        return shortest;
	    }
	    
	    //#2 Optimized method.  Time complexity is O(M+N)
	    //M is the frequency of word1, N is the frequency of word2
	    public int shortest2(String word1, String word2) {
	        List<Integer> list1 = wordsIndexMap.get(word1);
	        List<Integer> list2 = wordsIndexMap.get(word2);
	        int shortest = Integer.MAX_VALUE;
	        int i=0, j=0;
	        while(i<list1.size() && j < list2.size()){
	        	if(list1.get(i) < list2.get(j)){
	        		shortest = Math.min(shortest, list2.get(j) - list1.get(i));
	        		i++;
	        	}else{
	        		shortest = Math.min(shortest, list1.get(i) - list2.get(j));
	        		j++;
	        	}
	        }
	        return shortest;
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
