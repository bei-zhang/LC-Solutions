package dataStructure.StringAndArray;


/**
 * 
 * LeetCode doesn't have this question.
 * https://www.hackerrank.com/challenges/string-compression
 * Expedia 高频题目
 *
 */
public class StringCompression {
	public static String compressString(String input){
		if(input == null || input.length() <2){
			return input;
		}
		StringBuilder sb = new StringBuilder();
		char c;
		for(int i=0;i<input.length();i++){
			c = input.charAt(i);
			sb.append(c);
			int count =1;
			int j=i+1;
			while(j<input.length() && input.charAt(j) == c){
				count++;
				j++;
			}
			if(count>1){
				sb.append(count);
				i = j-1;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(StringCompression.compressString(null));
		System.out.println(StringCompression.compressString(""));
		System.out.println(StringCompression.compressString("a"));
		System.out.println(StringCompression.compressString("abc"));
		System.out.println(StringCompression.compressString("abcccef"));
		System.out.println(StringCompression.compressString("abcaaaaaaaaaaaaaaabbe"));
		System.out.println(StringCompression.compressString("abbcc"));

	}

}
