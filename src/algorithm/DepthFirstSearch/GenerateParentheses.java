package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * 
 * https://leetcode.com/problems/generate-parentheses/
 * 
 */
public class GenerateParentheses {	
	 //DFS solution 
	 static class Solution {
	    public static List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<>();
	        if(n<= 0) return result;
	        helper(result,"",n, n);
	        return result;
	    }
	    
	    private static void helper(List<String> result, 
	    		String paren, 	//current parentheses
	    		int left, 		// how many left parentheses we need to add
	    		int right){ 	// how many right parentheses we need to add
	        if(left ==0 && right == 0){
	            result.add(paren);
	            return;
	        }
	        if(left > 0){
	            helper(result, paren+"(", left-1, right);
	        }
	        if(right > 0 && left < right){
	            helper(result, paren+")", left, right-1);
	        }
	    }
	}
	
	
	public static void main(String[] args){
		GenerateParentheses.Solution.generateParenthesis(3);
	}
}
