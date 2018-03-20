package dataStructure.Tree.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * http://www.lintcode.com/en/problem/sliding-window-median/#
 * http://www.jiuzhang.com/solution/sliding-window-median
 * 
 * 此题就是基于  {@ DataStreamMedian.java} 解题思路 来做的.
 * 由于此题涉及到删除， it takes O(n) time to delete an element in PriorityQueue in Java.
 * so we use TreeSet (Java里面HashHeap的替代品 ) which supports O(logn) time for all operations (pop, push, peek, remove)
 *
 */
public class SlidingWindowMedian {

	//Time: O(nlogn), space: O(n)
	public class Solution {
	    /**
	     * @param nums: A list of integers.
	     * @return: The median of the element inside the window at each moving.
	     */
	    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	    	ArrayList<Integer> result = new ArrayList<>();
	    	if(nums == null || nums.length ==0){
	    		return result;
	    	}
	    	TreeSet<Node> minHeap = new TreeSet<>();
	    	TreeSet<Node> maxHeap = new TreeSet<>(Collections.reverseOrder());
	    	
	    	maxHeap.add(new Node(0,nums[0]));
	    	//1.add first K numbers into two heaps.
	    	for(int i=1; i<k;i++){
	    		addNum(maxHeap, minHeap, new Node(i,nums[i]));
	    		adjust(maxHeap, minHeap);
	    	}
	    	result.add(maxHeap.first().val); // add first median before moving window
	    	//2. sliding window -  remove a number and then add a new number
	    	//Remember: always adjust two heaps after removing or adding a number
	    	for(int i=k; i<nums.length;i++){
	    		//step1: remove
	    		removeNum(maxHeap, minHeap,new Node(i-k,nums[i-k]));
	    		adjust(maxHeap, minHeap);
	    		//step2: add
	    		addNum(maxHeap, minHeap, new Node(i,nums[i]));
	    		adjust(maxHeap, minHeap); 
	    		
	    		result.add(maxHeap.first().val);
	    	}
	    	
	    	return result;
	    }
	    
	    private void addNum(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, Node num){
	    	if(maxHeap.size()>0  &&  num.compareTo(maxHeap.first()) > 0){
	    		minHeap.add(num);
	    	}else{
	    		maxHeap.add(num);
	    	}
	    }
	    
	    private void removeNum(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, Node num){
	    	if(num.compareTo(maxHeap.first()) > 0){
	    		minHeap.remove(num);
	    	}else{
	    		maxHeap.remove(num);
	    	}
	    }
	    
	    
	    private void adjust(TreeSet<Node> maxHeap, TreeSet<Node> minHeap){
	    	if(minHeap.size() > maxHeap.size()){
	    		Node min = minHeap.pollFirst();
	    		maxHeap.add(min);
	    	}
	    	if(maxHeap.size() > minHeap.size() +1){
	    		Node max = maxHeap.pollFirst();
	    		minHeap.add(max);
	    	}
	    }

	}

	//1. 创建Node object的目的是为了保存重复值，e.g {1,2,7,7,2}
	//2. Object (or key in TreeMap) in TreeSet has to implement Comparable interface or provide specified Comparator in constructor.  
    //TreeSet uses compareTo() method to maintain uniqueness. 
    class Node implements Comparable<Node>{
    	int id, val;
    	public Node(int id, int num){
    		this.id = id;
    		this.val = num;
    	}
		@Override
		public int compareTo(Node node) {
			if(this.val == node.val){
				return this.id - node.id;
			}
			return this.val - node.val;
		}
    }
    
	
	
	
	public static void main(String[] args) {
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		Solution solution = slidingWindowMedian.new Solution();
		int[] nums = {1,2,7,7,2};
		int[] nums2 = {1,2,7,8,5};
		System.out.println(solution.medianSlidingWindow(nums, 1));
		System.out.println(solution.medianSlidingWindow(nums2, 3));
		
		
		TreeSet<Node> minHeap = new TreeSet<>();
		minHeap.add(slidingWindowMedian.new Node(1,3));
		minHeap.add(slidingWindowMedian.new Node(2,3));
		minHeap.add(slidingWindowMedian.new Node(3,3));
		System.out.println(minHeap.size());
		
		HashSet<Node> hashSet = new HashSet<>();
		hashSet.add(slidingWindowMedian.new Node(1,3));
		hashSet.add(slidingWindowMedian.new Node(2,3));
		hashSet.add(slidingWindowMedian.new Node(3,3));
		System.out.println("hashSet: " + hashSet.size());
		
	}

}
