package dataStructure.StringAndArray;

/**
 * 
 * https://leetcode.com/problems/valid-number/description/
 * http://www.lintcode.com/en/problem/valid-number/
 * http://www.jiuzhang.com/solution/valid-number
 * http://blog.csdn.net/fightforyourdream/article/details/12900751
 * 

 * LinkedIn 高频题
 *  Validate if a given string is numeric.
 *  It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * Edge cases: 
 * -0
 * +8
 * 00123
 * .15
 * 15.
 * 1e-5
 * 1e5
 * e5
 * 001.111111111111111111111111111111111
 * 
 * test cases return false
 * 1a
 * abc
 * 1 e
 * 2 6    (white space in between)
 * 
 * 
 * 
 * 
 */
public class ValidNumber {

	//Solution#1 with regular expression -- Accepted on LeetCode
	//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
	public  boolean isNumber1(String str) {
        if(str == null || str.trim().isEmpty()){
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        return str.trim().matches(regex);
	}
	
	//Solution#2 -- Accepted on LeetCode
	//Time: O(n) , Space: O(n)
	 public boolean isNumber(String s) {
	        int len = s.length();
	        int i = 0, right = len - 1;
	        //s.trim(); If allowed by interviewer, we may use this String built-in method to remove leading and trailing whitespace 
	        while (i <= right && Character.isWhitespace(s.charAt(i))) i++; //Remove leading whitespace
	        if (i > len - 1) return false;
	        while (right >= i && Character.isWhitespace(s.charAt(right))) right--; //Remove trailing whitespace
	        
	        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++; // skip leading +/-
	        
	        boolean num = false; // is a digit
	        boolean dot = false; // is a '.'
	        boolean exp = false; // is a 'e'
	        while (i <= right) {
	            char c = s.charAt(i);
	            if (c >= '0' && c <= '9') { //DO NOT USE built-in method like Character.isDigit()
	                num = true;
	            }else if (c == '.') {
	                if(exp || dot) return false;
	                dot = true;
	            }else if (c == 'e') {
	                if(exp || num == false) return false;
	                exp = true;
	                num = false;
	            }else if (c == '+' || c == '-') {
	                if (s.charAt(i - 1) != 'e') return false;
	            }else {
	                return false;
	            }
	            i++;
	        }
	        return num;
	    }
	
	 
	 //The solution I provided for LinkedIn phone interview on 8/10/2017
	 /**
	  * Assumption: do not allow whitespace, exp (e) etc. 
	  * Interview expected to throw IllegalArgumentException if input string is NULL.
	  * But I chose NullPointerException and he said it's fine. 
	  */
	 public boolean isNumber3(String toTest){
		    // implementation here
		if (toTest == null) {
			throw new IllegalArgumentException();
		}
		int i = 0, right = toTest.length() - 1;
		if (toTest.charAt(i) == '+' || toTest.charAt(i) == '-')
			i++;

		boolean dot = false;
		while (i <= right) {
			char c = toTest.charAt(i);
			if (c >= '0' && c <= '9') {
				i++;
			} else if (c == '.') {
				if (dot)
					return false;
				dot = true;
				i++;
			} else {
				return false;
			}

		}
		return true;
		    
		}

	
	
	public static void main(String[] args) {
		ValidNumber instance = new ValidNumber();
		System.out.println(instance.isNumber3("9."));
		System.out.println(instance.isNumber3(".9"));
		System.out.println(instance.isNumber3("+201.9"));
		String s = null;
		//System.out.println(instance.isNumber3(s));
		System.out.println(instance.isNumber3("1 e"));
		System.out.println(instance.isNumber3("001.111111111111111111111111111111111"));
		
		String regx = "6";
		//System.out.println("regex: " + regx.matches("[168]?"));
		

	}

}
