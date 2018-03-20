package dataStructure.StringAndArray;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * 
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 
 *
 */
public class MovingAverageFromDataStream {

	//O(1) time solution (Best solution recommended)
	//The idea is to keep the sum so far and update the sum just by replacing the oldest number with the new entry.
	class MovingAverage {
	    private int[] window; 
	    private int count, insertPos ;
	    private double sum;
	    
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        window = new int[size];      
	        this.count = 0;
	        this.insertPos =-1;
	        
	    }
	    public double next(int val) {
	        if(count < window.length){
	            sum+= val;
	            count++;
	            window[++insertPos] = val;
	            return sum/count;
	        }else{
	            insertPos = (insertPos+1) % window.length;
	            sum-= window[insertPos];
	            sum+=val;
	            window[insertPos] = val;            
	            return sum/window.length;            
	        }
	        
	    }
	}

	public static void main(String[] args){
		MovingAverageFromDataStream instance = new MovingAverageFromDataStream();
		MovingAverage moving = instance.new MovingAverage(3);
		System.out.println(moving.next(1));
		System.out.println(moving.next(10));
		System.out.println(moving.next(3));
		System.out.println(moving.next(5));
		
	}
	
	
}
