package dataStructure.StringAndArray.TwoPointers;

import java.util.Arrays;

/**
 * Given an array of integers, find how many unique pairs in the array such that
 * their sum is equal to a specific target number. Please return the number of
 * pairs. 
 * Example:
 * Given nums = [1,1,2,45,46,46], target = 47 
 * return 2
 * 1 + 46 = 47 
 * 2 + 45 = 47
 * 
 * http://www.lintcode.com/en/problem/two-sum-unique-pairs/
 * 
 *
 *参见 TwoSum 的题解分析
 *
 */
public class TwoSumUniquePairs {
 
	//Sort + Two pointers 
    public int twoSum6(int[] nums, int target) {
        if(nums == null || nums.length <2){
            return 0;
        }
        
        //1.Sort array   -- time complexity O(nlogn)
        Arrays.sort(nums);
        
        //2. Two pointers
        //left pointer always pointing to the smaller number of the potential pair.
        //right pointer always pointing to the greater number of the potential pair.
        int left=0, right=nums.length-1, count=0;
        while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                count++;
                //如果有相同数，一直向右移动，直到指向相同数中最右边那位
                while(left<right && nums[left] == nums[left+1]){
                    left++;
                }
                //如果有相同数，一直向做移动，直到指向相同数中最左边那位
                while(left<right && nums[right] == nums[right-1]){
                    right--;
                }
                
                //指向下一位不相同的数
                left++;
                right--;
            }
            
        }
        return count;
       
    }
    
	public static void main(String[] args) {

	}

}
