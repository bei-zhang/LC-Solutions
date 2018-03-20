package dataStructure.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *  All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
 *  for example: "ACGAATTCCG". 
 *  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

   Write a function to find all the 10-letter-long sequences (substrings) 
   		that occur more than once in a DNA molecule.

 * https://leetcode.com/problems/repeated-dna-sequences/
 * http://www.jiuzhang.com/solutions/repeated-dna-sequences/
 * 
 *
 */
public class RepeatedDNASequences {

	//Time: O(n) , Space: O(n)
	public class Solution {
	    public List<String> findRepeatedDnaSequences(String s) {
	        HashSet<Integer> hash = new HashSet<Integer>();
	        HashSet<String> result = new HashSet<>();
	    	Map<Character, Integer> map = new HashMap<>();
	    	map.put('A', 0);
	    	map.put('C', 1);
	    	map.put('G', 2);
	    	map.put('T', 3);
	    	
	        for (int i = 9; i < s.length(); i++) {
	            String subString = s.substring(i - 9, i + 1);
	            int encoded = encode(subString, map);
	            if (hash.contains(encoded)) {
	            	result.add(subString);
	            } else {
	                hash.add(encoded);
	            }
	        }
	        return new ArrayList<>(result);
	    }
	    
	    //Convert each 10-letter-long sequences to base 4 number
	    private int encode(String s , Map<Character, Integer> map) {
	        int sum = 0;
	        for (int i = 0; i < s.length(); i++) {
	        	sum = sum*4 + map.get(s.charAt(i));
	        }
	        return sum;
	    }
	    
	}
	
}
