package dataStructure.StringAndArray;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * https://leetcode.com/problems/meeting-rooms-ii
 * https://www.lintcode.com/problem/meeting-rooms-ii
 *
 */
public class MeetingRoomsII {

    public int minMeetingRooms(List<Interval> intervals) {
    	if(intervals == null || intervals.size() ==0) return 0;
    	Collections.sort(intervals, (a, b) -> a.start - b.start);
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	minHeap.offer(intervals.get(0).end);
    	
    	int count =1;
    	for(int i=1; i<intervals.size();i++) {
    		if(intervals.get(i).start < minHeap.peek()) {
    			count++;
    		}else {
    			minHeap.poll();
    		}
    		minHeap.offer(intervals.get(i).end);
    	}
    	return count;
    }
    
}
