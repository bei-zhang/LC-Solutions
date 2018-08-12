package dataStructure.StringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * 
 *
 */
public class ContinuousSubarraySum {

	
/**
 * Best solution - using HashMap
 * Time: O(n),   Space: O(n)
 * 解题思路
 * keeping track of the running sum mod k of the elements in the process. 
 * If we find that a running sum value at index j has been previously seen before in some earlier index i  
 *  in the array, then we know that the sub-array (i,j] contains a desired sum.
 *
 * Follow-up: find the total number of those subarray. 
 * 
 */
	public class Solution2 {
	    public boolean checkSubarraySum(int[] nums, int k) {
	        int sum = 0;
	        Map < Integer, Integer > map = new HashMap < > ();
	        map.put(0, -1);
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            if (k != 0) sum = sum % k;
	            if (map.containsKey(sum)) {
	                if (i - map.get(sum) > 1)
	                    return true;
	            } else
	                map.put(sum, i);
	        }
	        return false;
	    }
	}
	
///////////////////////	
	//Brute Force - Time:O(n^2), Space: O(1)
	public class Solution1 {
		public boolean checkSubarraySum(int[] nums, int k) {
			for (int i = 0; i < nums.length; i++) {
	            int sum= nums[i];
	            for (int j = i + 1; j < nums.length; j++) {
	                sum+=nums[j];
	                if(k ==0 && sum ==0) return true;
	                if (k != 0 && sum % k ==0) return true;
	            }
	        }
			return false;
		}
	}
	
	
}
