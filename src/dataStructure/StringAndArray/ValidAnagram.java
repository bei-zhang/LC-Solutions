package dataStructure.StringAndArray;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * Note: You may assume the string contains only lowercase alphabets.
 * https://leetcode.com/problems/valid-anagram
 *
 *两种方法
 *1) sort            O(nlogn) time
 *2) HashMap         O(n) time
 * 
 *这不算一道难题，核心点就在于使用哈希表映射，我们还是用一个数组来代替哈希表，
 *使用类似方法的题目有Minimum Window Substring 最小窗口子串，Isomorphic Strings 同构字符串，
 *Longest Substring Without Repeating Characters 最长无重复子串 和 1.
 *1 Unique Characters of a String 字符串中不同的字符。我们先判断两个字符串长度是否相同，不相同直接返回false。
 *然后把s中所有的字符出现个数统计起来，存入一个大小为26的数组中，因为题目中限定了输入字符串为小写字母组成。然后我们再来统计t字符串，如果发现不匹配则返回false。
 *
 *
Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

下面的解法 就可以处理上面的follow-up question.  因为  int[] sum = new int[256];  
   或者直接用HashMap<Character,Integer>来统计
 *
 *
 *Similar problem: GroupAnagrams, RansomNote.java, 
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null ||(s.length() != t.length())){
            return false;
        }
        //这是道Easy题，核心点就在于使用哈希表映射，我们还是用一个数组来代替哈希表
        int[] count = new int[256]; //  ASCII 
        //int[] count = new int[26];// if they are all lower cases English letters.
        for(int i=0; i<s.length();i++){
            count[s.charAt(i)]++;
        }
        
        for(int i=0; i<t.length();i++){
            char c = t.charAt(i);
            if(count[c] >=1){
                count[c]--;
            }else{
                return false;
            }
        }
        return true;
    }
    
}
