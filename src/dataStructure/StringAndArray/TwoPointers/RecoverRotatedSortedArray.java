package dataStructure.StringAndArray.TwoPointers;

import java.util.ArrayList;


/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 * 

What is rotated array?
•For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]

Example 

[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

 * http://www.lintcode.com/en/problem/recover-rotated-sorted-array/
 * 
 *
 *
 *此题类似 RotateString
 * 
 */
public class RecoverRotatedSortedArray {

    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if(nums == null || nums.size() <=1){
            return;
        }
        for(int i=0; i<nums.size()-2;i++){
            if(nums.get(i) > nums.get(i+1)){
            	//找到那个翻转的点， 采用 三步翻转, - reverse 3 times
                reverse(nums,0,i);
                reverse(nums,i+1,nums.size()-1);
                reverse(nums,0,nums.size()-1);
            }
        }     
        
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end){
        for(int i=start,j=end; i<j; i++,j--){
            int temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
        }
    }
    
	public static void main(String[] args) {

	}

}
