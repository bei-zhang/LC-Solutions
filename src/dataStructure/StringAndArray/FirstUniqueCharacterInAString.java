package dataStructure.StringAndArray;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 *Follow-up: we could change the size of the frequency array to 256 to store other kinds of characters. 
 *
 */
public class FirstUniqueCharacterInAString {

	//My own solution (Recommended)
	//O(n)time,  O(1) constant space.  
	class Solution {
	    public int firstUniqChar(String s) {
	        if(s == null || s.length() ==0){
	            return -1;
	        }
	        int[] lastIndex = new int[26];    
	        int[] counts = new int[26];
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            counts[c - 'a']++;
	            lastIndex[c- 'a'] = i;
	        }
	        int res =  s.length();
	        //use extra array to record counts so no need to go through entire string again.
	        for(int j=0;j<26;j++){
	            if(counts[j] ==1){
	                res = Math.min(res, lastIndex[j]);
	            }
	        }
	        res = res < s.length() ? res : -1;    
	        return res;
	    }
	}
	
}
