package algorithm.quicksort;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 * http://www.lintcode.com/en/problem/kth-largest-element/
 * 
 *
 * * 两种解法都可以，对比如下：
 *  1) Quick select:  O(n) Time,  O(1) space  更适合这道题， 死数据
 *  
 *  2)PriorityQueue (heap):   O(nlogk) time,  O(k) space,    适合于 TopKLargestNumbersII 这样的活数据
 *   
 *   
 */
public class KthLargestElement {

	//quick select (recommended)
	class Solution {
	    public int kthLargestElement(int k, int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        if (k <= 0) {
	            return 0;
	        }
	        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
	        
	    }
	    private int helper(int[] nums, int l, int r, int k) {
	        if (l == r) {
	            return nums[l];
	        }
	        int position = partition(nums, l, r);
	        if (position + 1 == k) {
	            return nums[position];
	        } else if (position + 1 < k) {
	            return helper(nums, position + 1, r, k);
	        }  else {
	            return helper(nums, l, position - 1, k);
	        }
	    }
	    private int partition(int[] nums, int l, int r) {
	        // 初始化左右指针和pivot
	        int left = l, right = r;
	        int pivot = nums[left];
	        // 进行partition
	        while (left < right) {
	            while (left < right && nums[right] >= pivot) {
	                right--;
	            }
	            nums[left] = nums[right];
	            while (left < right && nums[left] <= pivot) {
	                left++;
	            }
	            nums[right] = nums[left];
	        }
	        
	        // 返还pivot点到数组里面
	        nums[left] = pivot;
	        return left;         
	    }
	    
	};
	
	
//////////////////
	//PriorityQueue
	class Solution2 {
	    public int kthLargestElement(int[] nums, int k) {
	        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	        for (int num : nums) {
	            q.offer(num);
	            if (q.size() > k) {
	                q.poll(); 
	            }
	        }
	        return q.peek();
	        
	    }
	};
	
	
}
