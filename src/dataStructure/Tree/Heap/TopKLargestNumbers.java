package dataStructure.Tree.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://www.lintcode.com/problem/top-k-largest-numbers
 * 
 * Similar problems: TopKLargestNumbersII
 * 
 */
public class TopKLargestNumbers {
	//Use Heap.   Time O(nlogk),  Space O(logk)
	public int[] findTopK(int[] nums, int k) {
		if(nums == null || nums.length ==0)
			return new int[] {};
		int len = nums.length;

		if(len <= k) {
			//Arrays.sort(integerArray, Collections.reverseOrder()); only  takes Integer[] array.
			//there are no Arrays.sort() method which can sort the primitive int[] array in the reverse order.
			 Arrays.sort(nums);//sort in ascending order
			 reverseArray(nums);//reverse it in descending order in place
			 return nums;
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		for(int i : nums) {
			if(minHeap.size() <k) {
				minHeap.offer(i);
				continue;
			}
			if(i > minHeap.peek()) {
				minHeap.poll();
				minHeap.offer(i);
			}
		}
		int[] result = new int[k];
		for(int j=k-1; j>=0;j--) {
			result[j] = minHeap.poll();
		}
		
		return result;
	}
	
	private void reverseArray(int[] nums) {
		int i=0, j=nums.length -1;
		while(i<j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

}
