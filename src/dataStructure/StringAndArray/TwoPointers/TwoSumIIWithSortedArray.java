package dataStructure.StringAndArray.TwoPointers;

/**
 * 
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * Notice: You may assume that each input would have exactly one solution.
 * 
 * http://www.lintcode.com/en/problem/two-sum-input-array-is-sorted/
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 * 
 *
 *
 *参见 TwoSum 的题解分析
 *
 */
public class TwoSumIIWithSortedArray {

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <2){
            return null;
        }
        //Two pointers
        //left pointer always pointing to the smaller number of the potential pair.
        //right pointer always pointing to the greater number of the potential pair.
        int low = 0, high = nums.length-1;
        while(low < high){
        	//左边最小的数 + 右边最大的数 > target， 那么只有将右指针向左移动一位(较小的数)再比较
            if(nums[low] + nums[high] > target){
                high--;
            }else if(nums[low] + nums[high] < target){
                low++;
            }else{
                int[] pair = new int[2];
                pair[0] = low+1;
                pair[1] = high+1;
                return pair;
            }
        }
        return null;
    }
}
