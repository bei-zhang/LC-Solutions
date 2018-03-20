package algorithm.BitManipulation;

import java.util.HashSet;
import java.util.Iterator;

/**
 * http://www.lintcode.com/en/problem/single-number/
 * https://leetcode.com/problems/single-number/#/description
 * http://www.jiuzhang.com/solutions/single-number/
 *http://bangbingsyb.blogspot.com/2014/11/leetcode-single-number-i-ii.html
 * 
 *
 *解题思路
 *1) brute force: 每个数加入到HashSet， 如果已经存在就从HashSet里删除，最后HashSet里面就只剩一个数了
 *2) bit manipulation 按位操作小技巧    a ^ b ^ b = a 
 *
 *
 *
 */
public class SingleNumber {

	//bit manipulation   O(n) time    O(1) space
	public class Solution {
	    public int singleNumber(int[] A) {
	        if(A == null || A.length ==0){
	            return 0;
	        }
	        int result = A[0];
	        for(int i=1; i<A.length;i++){
	            result ^= A[i];
	        }
	        return result;
	    }
	}
	
	//brute force   O(n) time    O(n) space
	public class Solution2 {
	    public int singleNumber(int[] A) {
	        if(A == null || A.length ==0){
	            return 0;
	        }
	        HashSet<Integer> hash = new HashSet<>();
	        //每个数加入到HashSet， 如果已经存在就从HashSet里删除，最后HashSet里面就只剩一个数了
	        for(int i=0; i<A.length;i++){
	            if(hash.contains(A[i])){
	                hash.remove(A[i]);
	            }else{
	                hash.add(A[i]);
	            }
	        }
	        Iterator<Integer> it = hash.iterator();
	        return it.next();
	    }
	}
	
	
	public static void main(String[] args) {

	}

}
