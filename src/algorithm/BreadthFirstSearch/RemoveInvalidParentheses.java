package algorithm.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *  Remove the minimum number of invalid parentheses in order to make the input string valid.
 *  Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * https://leetcode.com/problems/remove-invalid-parentheses
 * 
 * http://bookshadow.com/weblog/2015/11/05/leetcode-remove-invalid-parentheses/
 * https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution/2
 * 
 * 解题方案： BFS， DFS 都可以
 * 
 * Tag: Facebook
 * Difficulty:Hard
 * 
 */
public class RemoveInvalidParentheses {

/**
 * BFS solution ***
 * The idea is straightforward, with the input string s, we generate all possible states by removing one ( or ), 
 * check if they are valid, if valid ones are found on the current level, put them to the final result list and we are done, 
 * otherwise, add them to a queue and carry on to the next level.
 * 
 * The good thing of using BFS is that we can guarantee the number of parentheses that need to be removed is minimal, 
 * also no recursion call is needed in BFS.
 *
 */
	public class Solution {
	    public List<String> removeInvalidParentheses(String s) {
	        List<String> result = new ArrayList<>();
	        if(s == null) return result;
	        
	        Queue<String> queue = new LinkedList<>();
	        HashSet<String> visited = new HashSet<>();
	        
	        //initialize
	        queue.offer(s);
	        visited.add(s);
	        
	        boolean found = false;
	        while(!queue.isEmpty()){
	            String str = queue.poll();
	            if(isValid(str)){// found an answer, add to the result
	                found = true;
	                result.add(str);            
	            }
	            if(found) continue; //No need to go to next level if a valid one is found.
	            
	            //Generate all possible states at next level by removing single one ( or )
	            for(int i =0; i<str.length();i++){
	                if(str.charAt(i) != '(' && str.charAt(i) != ')' ){
	                    continue;
	                }
	                String temp = str.substring(0,i) + str.substring(i+1);
	                if(!visited.contains(temp)){
	                    queue.offer(temp);
	                    visited.add(temp);
	                }                
	                
	            }
	            
	        }
	        
	        return result;
	        
	    }
	    
	    //check if string has valid parentheses. 
	    //No need to use stack. 因为只有一种括号 (), 如果像题目@{ValidParentheses}那样有多种括号({[, 则必须借助stack
	    private boolean isValid(String s){
	        int count =0;
	        for(int i=0; i<s.length();i++){
	            if( s.charAt(i) == '(' )   count++; 
	            if(s.charAt(i) == ')')   count--;
	            if(count <0)     return false;
	        }
	        return count ==0;
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
