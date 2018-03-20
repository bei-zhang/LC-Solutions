package dataStructure.StringAndArray.TwoPointers;

/**
 * Given a string, determine if it is a palindrome, 
 * 	considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

 * http://www.lintcode.com/en/problem/valid-palindrome/
 * https://leetcode.com/problems/valid-palindrome/
 * 
 *
 */
public class ValidPalindrome {

/////////简单版 basic question:  check if a given string is palindrome //////////
    public static boolean isPalindrome(String s){
        for(int i=0, j = s.length()-1; i<j ;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
	
//////升级版 LeetCode原题是: consider only alphanumeric characters and ignoring cases, spaces,punctuations etc. 	
	   public boolean validPalindrome(String s) {
	        if(s == null || s.length() <2){
	            return true;
	        }
	        
	        String lowerStr = s.toLowerCase();
	        for(int i=0, j=lowerStr.length()-1; i<j; i++,j--){
	            while(i<j && !isAlphanumeric(lowerStr.charAt(i)) ){
	                i++;
	            }
	            
	            // for emtpy string “.,,,”     
	            if(i == lowerStr.length()){
	                return true;
	            }
	            
	            while(i<j && !isAlphanumeric(lowerStr.charAt(j))  ){
	                j--;
	            }
	            
	            if(lowerStr.charAt(i) != lowerStr.charAt(j)){
	                return false;
	            }
	            
	        }
	        return true;
	    }
	    
	        private boolean isAlphanumeric(char c){
	        if((c >= 'a' && c <= 'z' ) ||  (c>= '0' && c<= '9')){
	            return true;
	        }
	        return false;
	    } 
    

}
