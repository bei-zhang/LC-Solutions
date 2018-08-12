package dataStructure.StringAndArray.TwoPointers;

/**
 * https://leetcode.com/problems/minimum-window-substring
 * http://www.lintcode.com/en/problem/minimum-window-substring/
 * http://www.cnblogs.com/grandyang/p/4340948.html
 * 
 * 
 * 解题思路： Hash + two Pointers 
 * 先用Hash统计target里的每个字符出现的次数
 * 再用traverse source string, two pointers的思想: 一个指针指向出现的所有字符的结尾，然后用一个开头指针看看能不能将窗格变短。
 */
public class MinimumWindowSubstring {
	//Time complexity: O(n),  Space complexity: O(1) 
    public String minWindow(String source, String target) {
        if(source == null || target == null || target.length() ==0
                || source.length()< target.length()){
            return "";
        }
        //因为ASCII只有256个字符，所以用大小为256的int数组即可代替哈希表
        int[] targetHash = new int[256];
        //initialize targetHash
        for(int i=0;i<target.length();i++){
            targetHash[target.charAt(i)]++;
        }
        int targetLen = target.length();
        int left=0, count=0, minWin = Integer.MAX_VALUE;
        String minStr ="";
        //start traversing source string
        for(int i=0; i<source.length() ;i++){
            if(targetHash[source.charAt(i)] >0)
                count++;
            targetHash[source.charAt(i)]--;
            while(count >= targetLen){
                if(minWin > (i-left+1) ){
                    minWin = i-left + 1;
                    minStr = source.substring(left,i+1);
                }
                targetHash[source.charAt(left)]++;
                if(targetHash[source.charAt(left)] > 0)
                    count--;
                left++;
            }
        }
        return minStr;
    }	
    
    
	public static void main(String[] args) {

	}

}
