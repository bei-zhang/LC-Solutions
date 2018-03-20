package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

 * https://leetcode.com/problems/group-anagrams/
 * 
 *
 *解题思路： 使用Anagram的特性， Anagram的所有string排序后肯定都一样
 * 对每一个string都转换为char[] 然后排序，这样相同Anagram就都一样了，用排序后的string 做key来保存到一个HashMap
 * 
 */
public class GroupAnagrams {

	//recommended solution.  
	//Time:O(n) + sorting time on each string 
	//Space: O(n)
	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {      
	        if(strs == null || strs.length ==0){
	            return new ArrayList<List<String>>();
	        }
	        Map<String, List<String>> hash = new HashMap<>();
	        for(String str : strs){
	            char[] arr = str.toCharArray();//string -> char[]
	            Arrays.sort(arr);
	            String key = String.valueOf(arr);//convert char[] back to String
	            if(!hash.containsKey(key)){
	                hash.put(key, new ArrayList<String>());
	            }
	            hash.get(key).add(str);
	        }

	        return new ArrayList<List<String>>(hash.values());
	    }
	}
	
}
