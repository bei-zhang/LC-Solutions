package algorithm.DynamicProgramming;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 *https://leetcode.com/problems/longest-valid-parentheses/#/description
 *Difficulty: hard
 * 
 *http://bangbingsyb.blogspot.com/2014/11/leetcode-longest-valid-parentheses.html
 *https://segmentfault.com/a/1190000003481194
 *
 *
 *
 */
public class LongestValidParentheses {
	//自己独立思考出来的 DP solution  (Best solution)
	public class Solution1 {
	    public int longestValidParentheses(String s) {
	        if(s == null || s.length() <2){
	            return 0;
	        }
	        //dp[i] 表示以i结尾的子字符串 的longest valid parentheses 的长度， 注意此子字符串必须含有第i个元素
	        int[] dp = new int[s.length()];//no need to initialize as the array is initialized to zeros
	        int maxLen = 0;
	        int count =0; //因为只含有一种 括号，所以不需要借助Stack,只需要count计数就行 same as RemoveInvalidParentheses.java
	        for(int i=0; i<s.length();i++){
	            if('(' == s.charAt(i)){
	                count++;
	            }else{
	                if(count>0){
	                    dp[i] = dp[i-1] + 2;
	                    int k = i - dp[i];
	                    while(k>=1 && dp[k]>0){
	                        dp[i] += dp[k];
	                        k = k- dp[k];
	                    }
	                    maxLen = Math.max(maxLen, dp[i]);
	                    count--;
	                }
	            }
	        }
	        
	        return maxLen;
	        
	    }
	}
	
	
	//自己独立思考出来的, DP + Stack
	public class Solution2 {
	    public int longestValidParentheses(String s) {
	        if(s == null || s.length() <2){
	            return 0;
	        }
	        int[] dp = new int[s.length()];
	        int max = 0;
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length();i++){
	            if('(' == s.charAt(i)){
	                stack.push(s.charAt(i));
	            }else{
	                if(!stack.isEmpty()){
	                    dp[i] = dp[i-1] + 2;
	                    int k = i - dp[i];
	                    while(k>=1 && dp[k]>0){
	                        dp[i] += dp[k];
	                        k = k- dp[k];
	                    }
	                    max = Math.max(max, dp[i]);
	                    stack.pop();
	                }
	            }
	        }
	        
	        return max;
	        
	    }
	}
}
