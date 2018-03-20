package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/merge-intervals/
 * https://leetcode.com/problems/merge-intervals/
 * http://www.jiuzhang.com/solutions/merge-intervals/
 * http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 * 
 *
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> result = new ArrayList<Interval>();
	 
	    if(intervals==null||intervals.size()==0)
	        return result;
	 
	    Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	 
	    Interval pre = intervals.get(0);
	    for(int i=0; i<intervals.size(); i++){
	        Interval curr = intervals.get(i);
	        if(curr.start>pre.end){
	            result.add(pre);
	            pre = curr;
	        }else{
	            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
	            pre = merged;
	        }
	    }
	    result.add(pre);
	 
	    return result;
	}
	
}

/**
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

