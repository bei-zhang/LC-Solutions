package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * http://www.lintcode.com/en/problem/letter-combinations-of-a-phone-number/
 * http://www.jiuzhang.com/solution/letter-combinations-of-a-phone-number/
 * 
 * Expedia interview question (I got this on 8/31/2017 with Expedia Global Payment team)
 *
 *
 *
 */
public class LetterCombinationsOfPhoneNumber {
	class Solution {
	    public List<String> letterCombinations(String digits) {
	        List<String> result = new ArrayList<>();
	        if(digits == null || digits.length() ==0){
	            return result;
	        }
	        Map<Character, char[]> map = initializeMappping();
	        dfsHelper(map, digits, result, new StringBuilder(), 0);
	        return result;
	    }
	    
	    private void dfsHelper(Map<Character, char[]> map,String digits,List<String> result, StringBuilder sb, int index){
	        if(index == digits.length()){
	            result.add(sb.toString());
	            return;
	        }
	        
	        char c = digits.charAt(index);
	        char[] arr = map.get(c);
	        for(int i=0; i<arr.length;i++){
	            sb.append(arr[i]);
	            dfsHelper(map,digits,result, sb, index +1);
	            sb.deleteCharAt(sb.length() -1); //backtracking
	        }
	    }
	    
	    
	    private Map<Character, char[]> initializeMappping(){
	        Map<Character, char[]> map = new HashMap<>();
	        map.put('0', new char[]{});
	        map.put('1', new char[]{});
	        map.put('2', new char[] { 'a', 'b', 'c' });
	        map.put('3', new char[] { 'd', 'e', 'f' });
	        map.put('4', new char[] { 'g', 'h', 'i' });
	        map.put('5', new char[] { 'j', 'k', 'l' });
	        map.put('6', new char[] { 'm', 'n', 'o' });
	        map.put('7', new char[] { 'p', 'q', 'r', 's' });
	        map.put('8', new char[] { 't', 'u', 'v'});
	        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
	        return map;
	    }
	}

}
