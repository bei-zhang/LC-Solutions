package dataStructure.StringAndArray;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * write a function that will return true if the ransom note can be constructed from the magazines ; 
 * otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

 * https://leetcode.com/problems/ransom-note/
 * 
 *
 * Similar problem: ValidAnagram.java
 */
public class RansomNote {
	class Solution {
	    public boolean canConstruct(String ransomNote, String magazine) {
	        if(magazine == null || ransomNote == null)  
	        	return false;
	        if(magazine.length() ==0 && ransomNote.length() ==0) 
	        	return true;
	        int len = ransomNote.length();
	        int[] count = new int[26];//Assumption is that both strings contain only lowercase letters.
	        //int[] count = new int[256]; //  ASCII if they are not only lowercase letters
	        for(int i=0; i<len;i++){
	            count[ransomNote.charAt(i) - 'a']++;
	        }
	        for(int i=0; i<magazine.length();i++){ 
	            char c = magazine.charAt(i);
	            if(len>0 && count[c - 'a'] >0 ){
	                count[c - 'a']--;
	                len--;
	            }
	            if(len == 0) return true;
	        }
	        return false;
	    }
	}
	
}
