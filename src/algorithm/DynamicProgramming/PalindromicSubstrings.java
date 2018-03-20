package algorithm.DynamicProgramming;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * https://leetcode.com/problems/palindromic-substrings/
 *
 */
public class PalindromicSubstrings {
	//自己完全独立思考的 DP solution  (recommended)
	class Solution {
	    public int countSubstrings(String s) {
	        if(s==null || s.length() ==0) return 0;
	        int len = s.length();
	        //dp[i] saves the count of Palindromic Substrings from begining to ith
	        int[] dp = new int[len];
	        dp[0] =1;
	        for(int i=1; i<len;i++){
	            int count = dp[i-1] +1;// each new char is a palindrome anyway, so always add 1 first.
	            //查看每个包含第i个字符的substring是否是palindrome
	            for(int j=i-1; j>=0;j--){
	                if(isPalindrom(s.substring(j,i+1))) count++;
	            }
	            dp[i] = count;
	        }
	        return dp[len-1];
	    }
	    private boolean isPalindrom(String s){
	        for(int i=0, j = s.length()-1; i<j ;i++,j--){
	            if(s.charAt(i) != s.charAt(j)){
	                return false;
	            }
	        }
	        return true;
	    }
	}
	
	
}
