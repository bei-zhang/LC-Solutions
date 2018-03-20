package dataStructure.StringAndArray;

import java.io.Serializable;


/**
 * https://www.lintcode.com/en/problem/strstr/
 * https://www.jiuzhang.com/solutions/strstr/
 * https://leetcode.com/problems/implement-strstr/#/description
 * 
 * Implement strStr().
 * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
 * 
 */
public class StrStr {

	/**
	 * 
	 * @param source string to be scanned.
	 * @param target string containing the sequence of characters to match.
	 */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
		//Calculate the max index where the first character could exist.
		int max=source.length()-target.length();
		
        for (int i = 0; i < max + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
    
    
	public static void main(String[] args) {

	}

}

