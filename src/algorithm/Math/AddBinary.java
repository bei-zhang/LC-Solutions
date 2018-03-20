package algorithm.Math;

/**
 * https://leetcode.com/problems/add-binary
 * http://www.lintcode.com/en/problem/add-binary/
 * 
 * 
 * Similar question: AddTwoNumbers, AddTwoNumbersII
 * 
 *
 */
public class AddBinary {

	public class Solution {
	    public String addBinary(String a, String b) {
	        if(a==null || a.length() ==0) return b;
	        if(b==null || b.length() ==0) return a;
	        StringBuilder sb = new StringBuilder();
	        int carry =0;
	        int i = a.length()-1;
	        int j = b.length()-1;
	        while(i>=0 && j>=0){
	            int sum = Integer.parseInt(String.valueOf(a.charAt(i)))
	                    + Integer.parseInt(String.valueOf(b.charAt(j))) + carry;
	            sb.append(String.valueOf(sum%2));
	            carry = sum/2;
	            i--;
	            j--;
	        }
	        while(i>=0){
	            int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + carry;
	            sb.append(String.valueOf(sum%2));
	            carry = sum/2;
	            i--;
	        }
	        while(j>=0){
	            int sum = Integer.parseInt(String.valueOf(b.charAt(j))) + carry;
	            sb.append(String.valueOf(sum%2));
	            carry = sum/2;
	            j--;
	        }
	        if(carry>0){
	            sb.append(String.valueOf(carry));
	        }
	        
	        return sb.reverse().toString();        
	        
	    }
	}
	
	public static void main(String[] args) {

	}

}
