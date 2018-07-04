package algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase letters is given. 
 *  We want to partition this string into as many parts as possible
 *  so that each letter appears in at most one part, 
 *  and return a list of integers representing the size of these parts.
 * 
 * https://leetcode.com/problems/partition-labels/
 *
 */
public class PartitionLabels {
	//Greedy:  Time Complexity: O(N), Space Complexity: O(1)
	//https://leetcode.com/problems/partition-labels/solution/
	class Solution {
	    public List<Integer> partitionLabels(String S) {
	        List<Integer> res = new ArrayList<>();
	        if(S == null || S.length() ==0) return res;
	        //Save the last occurrence for each letter from 'a' - 'z'
	        int[] lastIndex = new int[26];
	        for(int i=0; i<S.length();i++){
	            lastIndex[S.charAt(i) - 'a'] = i;
	        }
	        int p =0, j=0;
	        for(int i=0;i<S.length();i++){
	            p = Math.max(p, lastIndex[S.charAt(i) - 'a']);
	            if(p == i){
	                res.add(i-j+1);
	                j = i+1;
	            }
	        }
	        
	        return res;
	    }
	}
}
