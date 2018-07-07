package algorithm.Math;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 *
 * Some test cases: 
 *1. null or empty string
2. white spaces
3. +/- sign
4. calculate real value
5. handle min & max
6. containing non-digits: e.g. 6&9,  56are


 *
 * Ask interview: do we need to throw NumberFormatException if it's empty or contains non-digit characters.
 * Companies: LinkedIn (2017)
 * 
 * 类似题: ExcelSheetColumnNumber.java
 */
public class StringToInteger {
	public int str2Int(String str) {
		if (str == null || str.length() < 1){
			/*if(i<len){
				throw new NumberFormatException();*/
			return 0;
		}
	 
		// trim white spaces
		str = str.trim();
		int len = str.length();
	 
		boolean negative = false;
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			negative = true;
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		
		/*if(i<len){
			throw new NumberFormatException();
		}*/
	 
		if (negative)
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
		
	}
	
	public static void main(String[] args) {

	}

}
