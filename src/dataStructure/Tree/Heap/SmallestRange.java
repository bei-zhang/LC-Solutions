package dataStructure.Tree.Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You have k lists of sorted integers in ascending order. 
 * Find the smallest range that includes at least one number from each of the k lists.
   We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

 *https://leetcode.com/problems/smallest-range/
 *http://bookshadow.com/weblog/2017/07/02/leetcode-smallest-range/
 *
 *解题思路：
 *Solution#1  滑动窗口(Sliding Window)
 *
 *Solution#2  MinHeap (Priority Queue)     思路类似于Merge k Sorted Lists  (MergeKSortedLists)
利用数组listArr保存k个list的当前下标，初始为0
将Point(i, nums[i][0])依次加入优先队列pq（小顶堆，key为Point.x）
变量max记录当前队列中出现过的最大值
循环直到pq的size < nums.size()

  弹出pq的最小元素first（min, idx），用max - min更新答案
  
  将idxArr[idx]++，若idxArr[idx] < nums[idx].size()，将(nums[idxArr[idx]], idx)加回pq
  
 *
 */
public class SmallestRange {
	//Solution#2  MinHeap (Priority Queue)
	class Solution {
	    public int[] smallestRange(List<List<Integer>> nums) {
	        Queue<Point> minHeap = new PriorityQueue<>((p1, p2) -> (p1.val - p2.val)); 
	    	/*Queue<Point> minHeap = new PriorityQueue<>(1, new Comparator<Point>(){
	    		public int compare(Point p1, Point p2){
	    			return p1.val - p2.val;
	    		}
	    	});*/
	    	
	        int size = nums.size();
	        int[] listArr = new int[size];
	        int max = Integer.MIN_VALUE;
	        for (int i = 0; i < size; i++) {
	            int val = nums.get(i).get(0);
	            minHeap.add(new Point(i, val));
	            max = Math.max(max, val);
	        }
	        int start = -1, end = -1, gap = Integer.MAX_VALUE;
	        while (minHeap.size() == size) {
	            Point first = minHeap.poll();
	            int min = first.val, listId = first.listId;
	            if (max - min < gap) {
	                gap = max - min;
	                start = min;
	                end = max;
	            }
	            if (++listArr[listId] < nums.get(listId).size()) {
	                first.val = nums.get(listId).get(listArr[listId]);
	                minHeap.add(first);
	                max = Math.max(max, first.val);
	            }
	        }
	        return new int[]{start, end};        
	    }
	}
	
	class Point{
		int listId, val;
		public Point(int listId, int val){
			this.val = val;
			this.listId = listId;
		}
	}
	
	
	
	
	public static void main(String[] args) {

	}

}
