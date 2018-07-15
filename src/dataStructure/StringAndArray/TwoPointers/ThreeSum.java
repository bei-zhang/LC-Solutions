package dataStructure.StringAndArray.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC#15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

 Notice

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
 * 
 * http://www.lintcode.com/en/problem/3sum/
 * https://leetcode.com/problems/3sum
 * http://www.jiuzhang.com/solutions/3sum/
 * 
 *
 * 类似题目: TwoSum, ThreeSum, FourSum
 * 
 */
public class ThreeSum {
	//(recommended)Sorting + two pointers solution
	//Time: O(n^2), Space: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>>  res = new ArrayList<>();
        if(nums ==null || nums.length <3)  return res;
        Arrays.sort(nums); //#1. Sort the array
        for(int i=0; i<nums.length-2;i++){
        	if(i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates
        	int target = 0 - nums[i];
        	int low = i+1, high = nums.length  -1; //#2. Two pointers to find target like TwoSum
        	while(low < high){
        		if(nums[low] + nums[high] == target){
        			res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low+1]) low++; // skip duplicates
                    while(low < high && nums[high] == nums[high-1]) high--; // skip duplicates
                    low++;
                    high--;
                }else if(nums[low] + nums[high] > target){
                    high--;
                }else{
                    low++;
                }
        	}
        }
        
        return res;
    }

    
    public static void main(String[] args) {


	}

}
