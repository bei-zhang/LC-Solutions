package algorithm.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/roman-to-integer/
 * https://leetcode.com/problems/roman-to-integer
 * 
 *
 */
public class RomantoInteger {
	//Solution#1 (Recommended)  from right to left, coding is easier than from left to right
    public int romanToInt(String s) {
        if(s ==null || s.length() ==0){
            return 0;
        }
        Map<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);

        int len = s.length();
        int result = hashMap.get(s.charAt(len-1));
        //from right to left, coding is easier than from left to right
        for(int i=len-2;i>=0;i--){
            if(hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i+1))){
                result -= hashMap.get(s.charAt(i));
            }else{
                result += hashMap.get(s.charAt(i));
            }
        }
        return result;
    }
	
	
    //Solution2:  from left to right
	public class Solution2 {
	    public int romanToInt(String s) {
	        if(s ==null || s.length() ==0){
	            return 0;
	        }
	        Map<Character,Integer> hashMap = new HashMap<>();
	        hashMap.put('I',1);
	        hashMap.put('V',5);
	        hashMap.put('X',10);
	        hashMap.put('L',50);
	        hashMap.put('C',100);
	        hashMap.put('D',500);
	        hashMap.put('M',1000);
	        
	        int result = 0;
	        //from left to right
	        for(int i=0;i<s.length();i++){
	            int current = hashMap.get(s.charAt(i));
	            if( (i+1 < s.length()) &&  current < hashMap.get(s.charAt(i+1)) ) {
	                result += hashMap.get(s.charAt(i+1)) - current;
	                i++;
	            }else{
	                result += current;
	            }
	            
	        }
	        
	        return result;
	    }
	}
	
	
	public static void main(String[] args) {
        Map<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I', 100);
        char c = 'I';
        System.out.println(hashMap.get(c));
	}

}
