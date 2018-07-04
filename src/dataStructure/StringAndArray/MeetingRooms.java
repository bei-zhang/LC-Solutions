package dataStructure.StringAndArray;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/meeting-rooms
 * https://www.lintcode.com/problem/meeting-rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.
 * 
 * Follow-up: MeetingRoomsII.java
 */
public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
    	Collections.sort(intervals, (a, b) -> a.start - b.start);
    	for(int i=0; i<intervals.size() -1 ; i++) {
    		if(intervals.get(i).end > intervals.get(i+1).start) {
    			return false;
    		}
    	}
    	return true;
    }
    
}
