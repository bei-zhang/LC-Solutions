package algorithm.Math;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 *
 */
public class PalindromeNumber {

	//compare half of the digits in x, so don’t need to deal with overflow.
    public boolean isPalindrome(int x) {
        if(x <0 || (x!=0 && x%10 == 0))
            return false;
        int rev =0;
        while(rev < x){
            rev = rev * 10 + x%10;
            x = x/10;
        }
        return (x == rev || x == rev/10);        
    }
    
}
