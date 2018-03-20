package dataStructure.StringAndArray.TwoPointers;

import java.util.Arrays;

/**
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
 * http://www.lintcode.com/en/problem/remove-duplicate-numbers-in-array/
 * 
 *
 */
public class RemoveDuplicatesFromArray {

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if(nums ==null || nums.length ==0){
            return 0;
        }
        Arrays.sort(nums); // First, sort array if given array is not sorted.
        
        int index =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != nums[index]){
                nums[++index] =nums[i];
            }
        }
        return index +1;
    }
    
    
	public static void main(String[] args) {

	}

}
