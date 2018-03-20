package dataStructure.StringAndArray;

import java.util.ArrayList;

/**
 * http://www.lintcode.com/en/problem/majority-number/
 * https://leetcode.com/problems/majority-element
 * 
 * 3 solutions:
 * 											Time Complexity				Space Complexity					
 * 1) Sorting:      							O(nlogn)						O(1)
 * 2) Hash										O(n)							O(n)
 * 3) Boyer–Moore majority vote algorithm		O(n)							O(1)
 *
 */
public class MajorityElement {

	
	/**
	 * 摩尔投票(Boyer–Moore majority vote algorithm)
	 * 	简单来讲，就是不断对某个议案投票，如果有人有别的议案，则将前面认为的议案的count减1，减到0换一个议案。
		如果存在majority number，那么这个议案一定不会被减到0，最后会胜出。
	 */
    public static int majorityNumber(ArrayList<Integer> nums) {
        int candidate = 0, count =0;
        for(int num: nums){
            if(count ==0){
                candidate = num;
                count =1;
            }else if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        
        return candidate;
    }
    
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		MajorityElement.majorityNumber(nums);
		
	}
}
