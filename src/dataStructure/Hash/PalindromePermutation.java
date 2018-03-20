package dataStructure.Hash;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
	For example,
	"code" -> False, "aab" -> True, "carerac" -> True.

 * https://leetcode.com/problems/palindrome-permutation/
 * 
 * 
 *
 */
public class PalindromePermutation {

	//自己独立作出的解法， Best solution
	//Time: O(n), Space: O(1)
	public boolean canPermutePalindrome(String s) {
        if(s == null) return false;      
        int n = s.length();
        
        //Count the number of occurrences of each character
        int[] charCounts = new int[256];        
        for(int i=0; i<n;i++){
            charCounts[s.charAt(i)]++;
        }
        
        boolean hasOddCount = false;
        for(int i=0; i<256;i++){
            if(charCounts[i] % 2 == 1){
                if(hasOddCount) return false; // return false if there is more than one odd count. 
                hasOddCount = true;
            } 
        }
        
        if(n%2==0 && !hasOddCount) return true; // length of string is even, it cannot have odd count of any character.
        if(n%2==1 && hasOddCount) return true; //length of string is odd, it must have only one odd count of character.
        
        return false;
    }
}
