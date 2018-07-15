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
 *  2) PriorityQueue (heap):   O(nlogk) time,  O(k) space,    适合于 TopKLargestNumbersII 这样的活数据
 *   
 *   
 * 类似问题: TopKLargestNumbers.java  KthSmallestNumberInSortedMatrix.java
 *   
 */
public class KthLargestElement {

	//quick select (recommended): O(n) Time,  O(1) space
	class Solution {
	    public int kthLargestElement(int k, int[] nums) {
	        if (nums == null || nums.length == 0 || k <= 0)
	            return 0;
	        //Note:  nums.length - k + 1 is the index of Kth largest number as it's in ascending order
	        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
	    }
	    
	    private int quickSelect(int[] nums, int l, int r, int k) {
	        if (l == r) {
	            return nums[l];
	        }
	        int position = partition(nums, l, r);
	        if (position + 1 == k) {
	            return nums[position];
	        } else if (position + 1 < k) {
	            return quickSelect(nums, position + 1, r, k);
	        }  else {
	            return quickSelect(nums, l, position - 1, k);
	        }
	    }
	    //return the index after partition - ascending order
	    private int partition(int[] nums, int l, int r) {
	        // 初始化左右指针和pivot
	        int left = l, right = r;
	        int pivot = nums[left]; // choose left 
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
	    
	}
	
	
//////////////////
	//PriorityQueue (heap): O(nlogk) time,  O(k) space
	class Solution2 {
	    public int kthLargestElement(int[] nums, int k) {
	        PriorityQueue<Integer> q = new PriorityQueue<>(k);
	        for (int num : nums) {
	            q.offer(num);
	            if (q.size() > k) {
	                q.poll(); 
	            }
	        }
	        return q.peek();
	        
	    }
	}
	
	/// trying to do something.  wrong - need to fix it
	class Solution3 {
		public int findKthLargest(int[] nums, int k) {
			if (nums == null || nums.length == 0 || k <= 0)
				return 0;
			return quickSelect(nums, 0, nums.length - 1, k);
		}

		private int quickSelect(int[] nums, int l, int r, int k) {
			if (l == r) {
				return nums[l];
			}
			int position = partition(nums, l, r);
			if (position + 1 == k) {
				return nums[position];
			} else if (position + 1 < k) {
				return quickSelect(nums, position + 1, r, k);
			} else {
				return quickSelect(nums, l, position - 1, k);
			}
		}

		private int partition(int[] nums, int l, int r) {
			int left = l, right = r;
			int pivot = nums[left + (right - left) / 2]; // choose middle
			// 进行partition
			while (left <= right) {
				while (left <= right && nums[left] > pivot) {
					left++;
				}
				while (left <= right && nums[right] < pivot) {
					right--;
				}
				if (left <= right) {
					swap(nums, left, right);
					left++;
					right--;
				}
			}

			return left;
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

	}
	
}
