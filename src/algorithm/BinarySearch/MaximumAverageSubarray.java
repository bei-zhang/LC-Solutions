package algorithm.BinarySearch;


/**
 * http://www.lintcode.com/en/problem/maximum-average-subarray/
 * 
 *
 */
public class MaximumAverageSubarray {

	public class Solution {
		  /**
		     * @param nums an array with positive and negative numbers
		     * @param k an integer
		     * @return the maximum average
		     */
		    public double maxAverage(int[] nums, int k) {
		        // Write your code here
		        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
		        for (int i = 0; i < nums.length; ++i) {
		            if (nums[i] < l)
		                l = nums[i];
		            if (nums[i] > r)
		                r = nums[i];
		        }
		        
		       
		        while (r - l >= 1e-6) {
		            double mid = (l + r) / 2.0;

		            if (check_valid(nums, mid, k)) {
		                l = mid;
		            }
		            else {
		                r = mid;
		            }
		        }

		        return l;
		    }
		    
		    //1. 原数组里的每个数减去 mid 得到新数组 newNums[]
		     //这样问题就变成了求新数组里 subarray的和 >= 0 并且 subarray 的 size >=k , 只要存在就return
		    //2. get prefixSum[] based on newNums[]
		    //3. check if a size of prefixeSum[]  >= 0 
		    private boolean check_valid(int nums[], double mid, int k) {
		        int n = nums.length;
		        double min_pre = 0;
		        double[] sum = new double[n + 1];
		        sum[0] = 0; 
		        for (int i = 1; i <= n; ++i) {
		            sum[i] = sum[i - 1] + nums[i - 1] - mid;
		            if (i >= k && sum[i] - min_pre >= 0) {
		                return true;
		            }
		            if (i >= k)
		                min_pre = Math.min(min_pre, sum[i - k + 1]);
		        }
		        return false;
		    }

		}
	
}
