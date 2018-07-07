package algorithm.Math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 * 
 * 本质跟 StringToInteger.java 一样
 * 类似的 TinyUrl.java 里面将  short URL convert to base62 ID (62进制的ID)
 * 本质问题就是 将 string 转换为 基于  十进制，26进制， 62进制 等的 number的问题
 *   
 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++)
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("D")); //4
		System.out.println(titleToNumber("Z"));//26
		System.out.println(titleToNumber("AA"));//27
		System.out.println(titleToNumber("BA"));//53
	}
	
}
