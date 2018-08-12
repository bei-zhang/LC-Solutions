package dataStructure.Tree.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * http://www.lintcode.com/en/problem/top-k-largest-numbers-ii/
 * 
 * 此题关键是使用  PriorityQueue (heap)
 * 
 * Similar problems: KthLargestElement.java,  TopKLargestNumbers
 */
public class TopKLargestNumbersII {
    private int maxSize;
    private Queue<Integer> minHeap;
    
    public TopKLargestNumbersII(int k) {
        this.maxSize = k;
        this.minHeap = new PriorityQueue<>();
    }

    public void add(int num) {
        if(minHeap.size() < maxSize){
            minHeap.offer(num);
            return;
        }
        if(num > minHeap.peek()){
           minHeap.poll();
           minHeap.offer(num);
        }
    }
    
    public List<Integer> topk() {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = minHeap.iterator();
        while(it.hasNext()){
            result.add(it.next());
        }
        Collections.reverse(result);
        return result;
    }
    
    
    
	public static void main(String[] args) {
		TopKLargestNumbersII instance = new TopKLargestNumbersII(3);
		instance.add(100);
		instance.add(130);
		instance.add(150);
		instance.add(200);
		System.out.println(instance.topk());
		

	}
	
	

}
