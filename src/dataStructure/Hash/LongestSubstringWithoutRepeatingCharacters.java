package dataStructure.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * 
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	//Optimal solution 
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() < 1) {
			return 0;
		}
		Set<Character> hash = new HashSet<>();
		int max = 0, len = s.length(), j = 0;
		for (int i = 0; i < len; i++) {
			while (j < len) {
				if (hash.contains(s.charAt(j))) { // 注意此处要break
					break;
				} else {
					hash.add(s.charAt(j));
				}
				j++;
			}
			max = Math.max(max, hash.size());
			hash.remove(s.charAt(i));
		}

		return max;
	}

	
	//non-optimal solution
	//未优化的解法，每次都new 新的HashSet， 并且j 每次都是从i+1从头开始
	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        if(s == null || s.length() <1){
	            return 0;
	        }
	        
	        int max =0 , len = s.length();
	        for(int i=0; i<len;i++){
	            Set<Character> hash = new HashSet<>();
	            hash.add(s.charAt(i));
	            for(int j=i+1;j<len; j++){
	                if(hash.contains(s.charAt(j)) ){ // 注意此处要break
	                    break;
	                }
	                hash.add(s.charAt(j));
	            }
	            max = Math.max(max, hash.size());
	        }
	        
	        return max;
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
