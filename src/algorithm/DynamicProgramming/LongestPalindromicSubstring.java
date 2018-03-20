package algorithm.DynamicProgramming;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * https://leetcode.com/problems/longest-palindromic-substring
 * http://www.lintcode.com/en/problem/longest-palindromic-substring/
 * 主页君给出3种解法
 * http://www.cnblogs.com/yuzhangcmu/p/4189068.html
 * http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
 * 
 *
 */
public class LongestPalindromicSubstring {
	//Time complexity is O(n^2), space O(n^2). 此题DP 解虽不是最优，但是有普遍性. See Solution2 for space optimize.
	//DP solution： 用二维数组保存从j 到i 的 substring是否是 palindromic, so need extra space O(n^2)  
	//DP function:  dp[j][i] = (s.charAt(i) == s.charAt(j)) && ((i-j <=2) || dp[j+1][i-1]);
	class Solution1 {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0){
	            return s;
	        }
	        int n = s.length();
	        String longest = null;
	        int max =0;
	        boolean[][] dp = new boolean[n][n];
	        for(int i=0; i<n;i++){
	            for(int j=0;j<=i;j++){
	                //DP function
	            	//注意: 判断(i-j<=2) 必须在 dp[j+1][i-1] 前面， 这样才能保证j+1 或者i-1 不会越界
	                dp[j][i] = (s.charAt(i) == s.charAt(j)) && ((i-j <=2) || dp[j+1][i-1]);
	                if(dp[j][i]){
	                    if(max < i-j+1){
	                        max = i -j +1;
	                        longest = s.substring(j,i+1);
	                    }
	                }
	            }
	        }
	        return longest;
	    }
	}
	
	//Time complexity is O(n^2), space O(1) 
	//Optimized solution : Expand Around Center  (recommended)
	//We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, 
	//and there are only 2n −1 such centers.
	//这个方法其实很直观，就是从头扫描到尾部，每一个字符以它为中心向2边扩展，扩展到不能扩展为止（有不同的字符），返回以每一个字符为中心的回文，然后不断更新最大回文并返回之。
	class Solution2 {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0){
	            return s;
	        }
	        int n = s.length();
	        String longest = "", tmp ="";
	        for(int i=0;i<n;i++){
	        	// get longest palindrome with center of i			  Such palindromes have odd number of letters
	            tmp = getLongest(s,i,i);
	            if(tmp.length() > longest.length()){
	                longest = tmp;
	            }
	            
	            // get longest palindrome with center of i, i+1         Such palindromes have even number of letters
	            tmp = getLongest(s,i,i+1);
	            if(tmp.length() > longest.length()){
	                longest = tmp;
	            }
	        }
	        
	        return longest;
	    }
	    
	    // Find longest palindrome with given a center, either one letter or two letter
	    private String getLongest(String s, int left, int right){
	        while(left >=0 && right < s.length()  && (s.charAt(left) == s.charAt(right))) {
	            left--;
	            right++;
	        }
	        return s.substring(left+1, right);
	    }
	}
	
    
	
	
	public static void main(String[] args) {
		String s = "abcdzdcaa";
		s.substring(0, 5);

	}

}
