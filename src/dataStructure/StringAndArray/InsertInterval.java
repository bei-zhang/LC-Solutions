package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 *
 * 类似题： MergeIntervals, MeetingRooms, MeetingRoomsII
 * 
 */
public class InsertInterval {
	//straight-forward and concise solution (best solution)
	//Time: O(n),   Space: O(n) if we consider the space used for the return list
	class Solution {
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> res = new ArrayList<>();
	        if(intervals == null || intervals.size() == 0){
	            res.add(newInterval);
	            return res;
	        }
	        int n = intervals.size();
	        int i = 0;
	        //1. add all the intervals ending before newInterval starts
	        while(i < n && intervals.get(i).end < newInterval.start){
	            res.add(intervals.get(i++));
	        }
	        //2. merge all overlapping intervals to one considering newInterval
	        while(i < n && intervals.get(i).start <= newInterval.end){
	            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
	            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
	            i++;
	        }
	        res.add(newInterval); // add the union of intervals we got
	       //3. add all the rest
	        while(i < n){
	            res.add(intervals.get(i++));
	        }        
	        return res;
	    }
	}
	
}
