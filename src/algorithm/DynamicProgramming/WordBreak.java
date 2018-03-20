package algorithm.DynamicProgramming;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
 * You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

 * https://leetcode.com/problems/word-break/
 * https://segmentfault.com/a/1190000003698693
 * 
 *
 *DP思路:
 * dp[i]：S[0:i-1]是否能被break。例如dp[1]表示s[0]是否能被break。
dp[0] = true
dp[i] = true if and only if:
1. 存在一个i-1>=k>=0，使s[k:i-1]存在于dict中。
2. s[0: k-1]可以被break，即dp[k] = true

 *
 */
public class WordBreak {

	//DP solution (recommended)
	//Time: O(n^2), Space: O(n)
	class Solution {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true; //initialize
	        for(int i=0; i<s.length();i++){
	            for(int j=i; j>=0;j--){
	                if(dp[j] && wordDict.contains(s.substring(j, i+1))){
	                    dp[i+1] = true;
	                    break;
	                }
	            }
	            
	        }
	        return dp[s.length()];
	    }
	}
	
	
}
