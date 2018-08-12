package algorithm.Math;

/**
 * 415. Add Strings
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * https://leetcode.com/problems/add-strings
 *
 */
public class AddStrings {
	//Straightforward solution
    public String addStrings(String num1, String num2) {
    	if(num1 == null || num1.length() == 0) return num2;
    	if(num2 == null || num2.length() == 0) return num1;
    	
        StringBuilder sb = new StringBuilder();
        int i = num1.length() -1;
        int j = num2.length() -1;
        int carry = 0;
        while(i>= 0 && j>= 0) {
        	int digit =  num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
        	sb.append(digit % 10);
        	carry = digit / 10;
        	i--;
        	j--;
        }
        while(i>= 0) {
        	int digit =  num1.charAt(i) - '0' + carry;
        	sb.append(digit % 10);
        	carry = digit / 10;
        	i--;
        }
        while(j>= 0) {
        	int digit =  num2.charAt(j) - '0' + carry;
        	sb.append(digit % 10);
        	carry = digit / 10;
        	j--;
        }
        if(carry > 0) {
        	sb.append(carry);
        }
        
        return sb.reverse().toString(); //Note: call reverse() method of StringBuilder
    }
    
//////////////////////////    
    
    //The following version is much cleaner. 跟上面解法思路一样，只是coding 方面更加简洁
    public class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--){
                int digit1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int digit2 = j < 0 ? 0 : num2.charAt(j) - '0';
                sb.append((digit1 + digit2 + carry) % 10);
                carry = (digit1 + digit2 + carry) / 10;
            }
            return sb.reverse().toString();
        }
    }
    
}
