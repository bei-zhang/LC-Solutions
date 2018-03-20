package dataStructure.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 * 
 *
 */
public class IsomorphicStrings {

	//Time is O(n).  Space is O(n)
	 public boolean isIsomorphic(String s, String t) {
	        if(s == null || t == null || s.length() != t.length()){
	            return false;
	        }
	        Map<Character,Character> hash = new HashMap<>();
	        //boolean[] matched = new boolean[256];//如果不用HashMap检查是否value已经匹配的话，也可以用boolean[256]代替
	        for(int i=0;i<s.length();i++){
	        	char c1 = s.charAt(i), c2 = t.charAt(i);
	            if(hash.containsKey(c1)){
	                if(hash.get(c1) != c2){//if not consistant with the previous ones
	                    return false;
	                }
	            }else{
	            	if(hash.containsValue(c2))//if c2 is already being mapped
	            		return false;
	                hash.put(c1, c2);
	            }
	        }
	        return true;
	        
	    }
	 
	public static void main(String[] args) {

	}

}
