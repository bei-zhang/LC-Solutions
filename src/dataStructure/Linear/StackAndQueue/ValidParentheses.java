package dataStructure.Linear.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * http://www.lintcode.com/en/problem/valid-parentheses/
 * https://leetcode.com/problems/valid-parentheses/#/description
 *
 *[解题思路]
 * 经典的栈匹配。一个栈，左符号入栈，右符号出栈。最后检查栈是否为空。
 */
public class ValidParentheses {
	//Stack.  best solution 
	public class Solution {
	    public boolean isValidParentheses(String s) {
	        if(s ==null || s.length() ==0){
	            return true;
	        }
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length();i++){
	            if("({[".indexOf(s.charAt(i)) >=0){
	                stack.push(s.charAt(i));
	            }else{
	                if(stack.isEmpty()){
	                    return false;
	                }
	                if(!isClosed(stack.pop(), s.charAt(i))){
	                    return false;
	                }
	            }
	        }
	        return stack.isEmpty();
	    }
	    
	    private boolean isClosed(char a, char b){
	    	if( (a == '(' && b == ')' )  ||  (a =='{' && b =='}')  
	    			|| (a == '[' && b == ']' ) ){
	    		return true;
	    	}
	    	return false;
	    }
	    
	}
	
	
	//Stack + HashMap
	public class Solution2 {
	    /**
	     * @param s A string
	     * @return whether the string is a valid parentheses
	     */
	    public boolean isValidParentheses(String s) {
	        if(s ==null || s.length() ==0){
	            return true;
	        }
	        Map<Character, Character> hashMap = new HashMap<>();
	        hashMap.put('(', ')');
	        hashMap.put('{', '}');
	        hashMap.put('[', ']');
	        
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length();i++){
	            if(hashMap.containsKey(s.charAt(i))){
	                stack.push(s.charAt(i));
	            }else{
	                if(stack.isEmpty()){
	                    return false;
	                }
	                if(hashMap.get(stack.pop()) != s.charAt(i)){
	                    return false;
	                }
	            }
	        
	        }
	        
	        return stack.isEmpty();
	        
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
