package algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/k-edit-distance/
 * 
 *1) brute force: 直接调用 {@EditDistance} 的 DP 解决方案, 可行，但是时间复杂度太高.
 *2） Trie + DP
 *
 */
public class KEditDistance {

	public class Solution {
	    public List<String> kDistance(String[] words, String target, int k) {
	        // Write your code here
	        TrieNode root = new TrieNode();
	        for (int i = 0; i < words.length; i++)
	            addWord(root, words[i]);

	        List<String> result = new ArrayList<String>();

	        int n = target.length();
	        int[] dp = new int[n + 1];
	        for (int i = 0; i <= n; ++i)
	            dp[i] = i;

	        find(root, result, k, target, dp);
	        return result;
	    }

	    public void find(TrieNode node, List<String> result, int k, String target, int[] dp) {
	        int n = target.length();
	        // dp[i] 表示从Trie的root节点走到当前node节点，形成的Prefix
	        // 和 target的前i个字符的最小编辑距离
	        if (node.isEnd && dp[n] <= k) {
	            result.add(node.str);
	        }
	        int[] next = new int[n + 1];
	        for (int i = 0; i <= n; ++i)
	            next[i] = 0;

	        for (int i = 0; i < 26; ++i)
	            if (node.children[i] != null) {
	                next[0] = dp[0] + 1;
	                for (int j = 1; j <= n; j++) {
	                    if (target.charAt(j - 1) - 'a' == i) {
	                        next[j] = Math.min(dp[j - 1], Math.min(next[j - 1] + 1, dp[j] + 1));
	                    } else {
	                        next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1));
	                    }
	                }
	                find(node.children[i], result, k, target, next);
	            }
	    }
	    
	    // Adds a word into the data structure.
	     public  void addWord(TrieNode root, String word) {
	        TrieNode now = root;
	        for(int i = 0; i < word.length(); i++) {
	            Character c = word.charAt(i);
	            if (now.children[c - 'a'] == null) {
	                now.children[c - 'a'] = new TrieNode();
	            }
	            now = now.children[c - 'a'];
	        }
	        now.str = word;
	        now.isEnd = true;
	    }
	     
	}
	
	class TrieNode {
	    // Initialize your data structure here.
	    public TrieNode[] children;
	    public boolean isEnd;
	    public String str;
	    
	    // Initialize your data structure here.
	    public TrieNode() {
	        children = new TrieNode[26];
	        for (int i = 0; i < 26; ++i)
	            children[i] = null;
	        isEnd = false;
	    }

	}

	
	
//////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////Below is second solution /////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 直接调用 {@EditDistance} 的 DP 解决方案, 可行，但是时间复杂度太高.
	 *
	 */
	public class Solution2 {
	    /**
	     * @param words a set of strings
	     * @param target a target string
	     * @param k an integer
	     * @return output all the strings that meet the requirements
	     */
	    public List<String> kDistance(String[] words, String target, int k) {
	        List<String> result = new ArrayList<>();
	        for(String word: words){
	            if(validDistance(word, target, k)){
	                result.add(word);
	            }
	        }
	        return result;
	    }
	    
	    private boolean validDistance(String word, String target, int k){
	        int n = word.length();
	        int m = target.length();
	        if(Math.abs(n-m) >k){
	            return false;
	        }
	        int[][] dp = new int[n+1][m+1];
	        //initialize
	        for(int i=0; i<=n;i++){
	            dp[i][0] = i;
	        }
	        for(int i=0; i<=m;i++){
	            dp[0][i] = i;
	        }
	        
	        for(int i=1; i<=n;i++){
	            for(int j=1; j<=m;j++){
	                if(word.charAt(i-1) == target.charAt(j-1)){
	                    dp[i][j] = dp[i-1][j-1];
	                }else{
	                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]));
	                }
	            }
	        }
	    
	        return dp[n][m] <=k;
	    }
	}
}
