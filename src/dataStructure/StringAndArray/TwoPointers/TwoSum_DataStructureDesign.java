package dataStructure.StringAndArray.TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 * Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false


 * http://www.lintcode.com/en/problem/two-sum-data-structure-design/
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * 
 * Related problems: TwoSum
 * 
 * 
 * 此题只能用 HashMap 来做
 * 
 * Follow-up: what if we need  O(1) for find() method and O(n) for add() method? 
 *    See solution#2  
 * 
 */
public class TwoSum_DataStructureDesign {

	//Solution#1 (Recommended): Time complexity:  O(1) for add() method,  O(n) for find() method
	//			  				Space complexity: O(n)
	 class TwoSum {
		 //HashMap里存的<key,value> 是<number, 出现的次数>
	     private Map<Integer,Integer> numFrequency; 
	    
	    public TwoSum(){
	        numFrequency = new HashMap<>();
	    }
	    
	    // Add the number to an internal data structure.
	    public void add(int number) {
	        if(numFrequency.containsKey(number)){
	            numFrequency.put(number, numFrequency.get(number) +1);
	        }else{
	            numFrequency.put(number,1);
	        }
	        
	    }

	    // Find if there exists any pair of numbers which sum is equal to the value.
	    public boolean find(int value) {
	    	for(int num : numFrequency.keySet()){
	    		int target = value - num;
	    		if(numFrequency.containsKey(target)){
	    			//如果remaining sum 等于自身，并且只出现过一次，那不符合条件，所以continue继续找 next pair
	    			if(num == target && numFrequency.get(target) == 1){ 
	    				continue;
	    			}
	    			return true; //remaining sum不等于自身，或者等于自身但是出现过多次，所以可以组成pair
	    		}
	    	}
	       return false;
	        
	    }
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    //Not recommended solution unless interviewer requests to implement a solution for O(1) time for find() method
	    //When this solution performs better.  i.e. input is not big (say < 1000) and find() method are called more frequently.
		//solution#2: Time complexity:  O(n) for add() method,  O(1) for find() method
	 	//			  Space complexity: O(n)
		 class TwoSum2 {
			private List<Integer> nums; 
		    private Set<Integer> twoSumValues; 
		    
		    public TwoSum2(){
		    	nums = new ArrayList<>();
		    	twoSumValues = new HashSet<>();
		    }
		    
		    // Add the number to an internal data structure.
		    public void add(int number) {
			     for(int num : nums){
		             twoSumValues.add(num + number);
		         }   
			     nums.add(number);    
		    }

		    // Find if there exists any pair of numbers which sum is equal to the value.
		    public boolean find(int value) {
		    	return twoSumValues.contains(value);
		    }
		}	 
	 

	// Your TwoSum object will be instantiated and called as such:
	// TwoSum twoSum = new TwoSum();
	// twoSum.add(number);
	// twoSum.find(value);
	
	
	public static void main(String[] args) {

	}

}
