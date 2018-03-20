package dataStructure.Tree.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * http://www.lintcode.com/en/problem/data-stream-median/
 * 
 * 
 */
public class DataStreamMedian {

	//Time: O(nlogn) ,  Space: O(n)
	public class Solution {
	    /**
	     * @param nums: A list of integers.
	     * @return: the median of numbers
	     */
	    public int[] medianII(int[] nums) {
	        if(nums == null || nums.length ==0){
	            return null;
	        }
	        int[] result = new int[nums.length];
	        Queue<Integer> minHeap = new PriorityQueue<>();
	        Queue<Integer> maxHeap = new PriorityQueue<>(1, Collections.reverseOrder());
	        
	        maxHeap.offer(nums[0]); //maxHeap always keeps the current median. 
	        result[0] = nums[0];
	        for(int i=1; i<nums.length;i++){
	           //1. 先把新来的数加入到相对应heap    
	            //Add the new number into  minHeap if it's greater than the current median
	            //otherwise, add the new number into maxHeap
	            if(nums[i] > maxHeap.peek()){
	                minHeap.offer(nums[i]);
	            }else{ 
	                maxHeap.offer(nums[i]);
	            }
	            //2. 调整两个heap 个数， 确保median存在maxHeap中
	            adjust(minHeap, maxHeap);
	        
	            result[i] = maxHeap.peek();
	        }
	        return result;
	    }
	    
	    private void adjust(Queue<Integer> minHeap, Queue<Integer> maxHeap){
	    	//Since maxHeap always keeps the current median, we need to adjust two heap when minHeap.size() > maxHeap.size()
	        if( minHeap.size() > maxHeap.size()){
	            int min = minHeap.poll();
	            maxHeap.offer(min);
	        }
	        
	        if(maxHeap.size() >= minHeap.size() +2 ){
	            int max = maxHeap.poll();
	            minHeap.offer(max);
	        } 
	        
	    }
	}
	
}
