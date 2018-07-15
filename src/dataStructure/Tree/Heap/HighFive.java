package dataStructure.Tree.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There are two properties in the node student id and scores, 
 * to ensure that each student will have at least 5 points, 
 * find the average of 5 highest scores for each person.
 * 
 * https://www.lintcode.com/problem/high-five
 *
 */
public class HighFive {
    public Map<Integer, Double> highFive(Record[] results) {
    	if(results == null || results.length == 0) {
    		return new HashMap<>();
    	}
    	Map<Integer, Double> res = new HashMap<>();
    	Map<Integer, PriorityQueue<Integer>> idToScoreMap = new HashMap<>();
    	for(Record record : results) {
    		PriorityQueue<Integer> minHeap = idToScoreMap.getOrDefault(record.id, new PriorityQueue<Integer>());
    		if(minHeap.size() < 5) {
    			minHeap.offer(record.score);
    			continue;
    		}
    		if(record.score > minHeap.peek()) {
    			minHeap.poll();
    			minHeap.offer(record.score);
    		}
    	}
    	for(int id : idToScoreMap.keySet()) {
    		res.put(id, calculateAverage(idToScoreMap.get(id)));
    		System.out.println(id + ": " + res.get(id));
    	}
    	
    	return res;
    }
    
    private double calculateAverage(PriorityQueue<Integer> minHeap) {
    	int size = minHeap.size();
    	double sum =0.0d;
    	while(!minHeap.isEmpty()) {
    		sum += minHeap.poll();
    	}
    	return sum/size;
    }
	
    public static void main(String[] args) {
    	double sum = 102;
    	int size =8;
    	System.out.println(sum/size);
    }
}



class Record {
	public int id, score;

	public Record(int id, int score) {
		this.id = id;
		this.score = score;
	}
}
