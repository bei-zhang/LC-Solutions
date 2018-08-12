package dataStructure.Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * https://leetcode.com/problems/longest-consecutive-sequence
 * 
 * 解题思路:
 * 1) Sort first and then find the longest consecutive
 * 2) HashSet： Add all numbers in HashSet first, then iterate the number from array， 加1， 减1 看是否 在HashSet里面，
 *      如果在就其从HashSet 删除
 */
public class LongestConsecutiveSequence {
	//HashSet solution (Best): O(n) time, O(n) space 
	class Solution {
	    public int longestConsecutive(int[] nums) {
	    	Set<Integer> hash = new HashSet<>();
	        for(int num : nums) 
	        	hash.add(num);
	        
	        int max = 0;
	        for(int num : nums) {
	        	if(hash.contains(num)) {
	        		hash.remove(num);
	        		int count = 1;
	        		int next = num + 1;
	        		while(hash.contains(next)) {
	        			hash.remove(next);
	        			count++;
	        			next++;
	        		}
	        		int pre = num - 1;
	        		while(hash.contains(pre)) {
	        			hash.remove(pre);
	        			count++;
	        			pre--;
	        		}
	        		max = Math.max(max, count);
	        	}
	        }
	        return max;
	    }
	}
	
	//Sort first and then find the longest consecutive
	//Time: O(nlogn),    Space: O(1) or O(n) if not allowed to modify the input array
	class Solution2 {
	    public int longestConsecutive(int[] nums) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        Arrays.sort(nums);

	        int max = 1;
	        int current = 1;

	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] != nums[i-1]) {
	                if (nums[i] == nums[i-1]+1) {
	                    current += 1;
	                }
	                else {
	                    max = Math.max(max, current);
	                    current = 1;
	                }
	            }
	        }
	        return Math.max(max, current);
	    }
	}
	
}
