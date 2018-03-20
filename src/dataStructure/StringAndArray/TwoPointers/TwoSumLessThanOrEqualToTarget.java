package dataStructure.StringAndArray.TwoPointers;

import java.util.Arrays;

/**
 * 
 * Given an array of integers, find how many pairs in the array such that their
 * sum is less than or equal to a specific target number. Please return the
 * number of pairs.
 * 
 * http://www.lintcode.com/en/problem/two-sum-less-than-or-equal-to-target/
 * 
 *
 */
public class TwoSumLessThanOrEqualToTarget {

	
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        if(nums == null || nums.length <2){
            return 0;
        }
        
        Arrays.sort(nums);
        int left=0, right = nums.length -1, count=0;
        while(left < right){
            if(nums[left] + nums[right] <= target){
                count+= right - left;
                left++;
            }else{
                right--;
            }
        }
        
        return count;
    }
    
    
    
    
    
    
    
    
    
    
    
    //solution2不是很好，但是 此方法适合 求 出 所有 pair
    public class Solution2 {
        public int twoSum5(int[] nums, int target) {
            if(nums == null || nums.length <2){
                return 0;
            }
            
            Arrays.sort(nums);
            int left=0, right = nums.length -1, count=0;
            while(left < right){
                if(nums[left] + nums[right] <= target){
                    int p = left;
                    while(p < right){
                         if(nums[p] + nums[right] <= target){
                             count++;
                         }
                          p++;
                    }
                    
                    int pr = right -1;
                    while(left < pr){
                         if(nums[left] + nums[pr] <= target){
                             count++;
                         }
                          pr--;
                    }
                    
                    left++;
                    right--;
                }else{
                    right--;
                }
                
            }
            
            return count;
        }
    }
    
}
