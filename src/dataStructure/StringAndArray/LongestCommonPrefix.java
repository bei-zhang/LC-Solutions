package dataStructure.StringAndArray;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * https://leetcode.com/problems/longest-common-prefix//
 * 
 *
 */
public class LongestCommonPrefix {
	
	//My own solution
	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        if(strs == null || strs.length == 0){
	            return "";
	        }
	        if(strs.length == 1)  return strs[0];
	        String first = strs[0];
	        int i=0, end=-1;
	        for(;i<first.length();i++){
	            char c = first.charAt(i);
	            for(String str : strs){
	                if(i>= str.length() ||  c != str.charAt(i)){
	                    end = i;
	                }
	            }
	            if(end >=0) break;
	        }
	        if(i == first.length())
	            return first;     
	        if(end >0)
	            return first.substring(0,end);
	        
	        return "";
	    }
	}
	
	
	public String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	}
	
}
