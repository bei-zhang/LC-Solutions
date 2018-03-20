package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/substring-anagrams/
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 * 
 *http://blog.csdn.net/yy254117440/article/details/53025142
 *
 *
 * 滑动窗口思想  + 基础题{@ValidAnagram}的判断
 *
 *
 */
public class FindAllAnagramsInString {

	
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || p == null || s.length() ==0 || p.length() ==0){
            return result;
        }
        int pLen = p.length();
        int[] hash = new int[26];
        for(int i=0; i<pLen;i++){
            char c = p.charAt(i);
            hash[c - 'a']++;
        }
        //滑动窗口思想, 每次将大小为 pLen的窗口  向右滑动一个位置，然后再while loop 检查当前substring window是否是一个anagram
        for(int i=0; i<=s.length() - pLen;i++){
            int j=i;
            int[] count = Arrays.copyOf(hash, 26);//注意每次都要重新copy赋值
            while(j<i+pLen){
                if(count[s.charAt(j) - 'a'] >=1){
                	count[s.charAt(j) - 'a']--;
                }else{
                	break;
                }
                j++;
            }
            if(j== (i+pLen)){
                result.add(i);
            }
        }
        
        return result;
    }
    
    
	public static void main(String[] args) {
		FindAllAnagramsInString.findAnagrams("abab", "ab");

	}

}
