package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/description/
 *
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length ==0){
            return result;
        }
        
        if(nums.length ==1){
            result.add(String.valueOf(nums[0]));
            return result;
        }            
        
        int start = 0;
        for(int i=1;i<nums.length;i++){
            if((nums[i-1] + 1) != nums[i] ){
                if(i > start +1){
                    result.add(nums[start]+"->"+ nums[i-1]);
                }else{
                    result.add(String.valueOf(nums[start]));
                }
                start = i;
            }
        }
        
        if(start == nums.length -1){
            result.add(String.valueOf(nums[start]));
        }else{
            result.add(nums[start]+"->"+ nums[nums.length -1]);
        }
        
        return result;
    }
    
	public static void main(String[] args) {

	}

}
