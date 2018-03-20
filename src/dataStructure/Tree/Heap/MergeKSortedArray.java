package dataStructure.Tree.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 
 * 更多解题思路和Solutions 参见 MergeKSortedLists.java
 * 
 */
public class MergeKSortedArray {
	// Solution#1: Heap/PriorityQueue
	static class Solution1 {
		 public static int[] mergeKSortedArray(int[][] arr) {
			/* Queue<Element> minHeap = new PriorityQueue<Element>(1, new Comparator<Element>(){
				 public int compare(Element a, Element b){
					 return a.val - b.val;
				 }
			 });*/
			 Queue<Element> minHeap = new PriorityQueue<Element>((a,b) -> a.val - b.val);
			 int total =0;
			 //利用一个额外数组index保存k个array的当前下标，初始为0
			 int[] index = new int[arr.length]; 
			 //1. Add 1st element from each array to minHeap
			 for(int i=0; i<arr.length;i++){
				 minHeap.offer(new Element(i, arr[i][0]));
				 total+= arr[i].length; // get total size
			 }
			 
			 int[] res = new int[total];
			 int i=0;
			 //2. 每次poll Heap 里面的最小数，同时将其对应的array里面的下一个元素加入到Heap
			 while(!minHeap.isEmpty()){
				 Element top = minHeap.poll();
				 res[i++] =  top.val;
				 if(++index[top.arrId] < arr[top.arrId].length){
					 minHeap.offer(new Element(top.arrId, arr[top.arrId][index[top.arrId]]));
				 }
			 }
			 
			 return res;
		 }
	}
	
	
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 5, 7 };
		int[] arr2 = { 2, 100};
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = Solution1.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}
	
}


class Element{
	int arrId, val;
	public Element(int arrId, int val){
		this.arrId = arrId;
		this.val = val;
	}
}

