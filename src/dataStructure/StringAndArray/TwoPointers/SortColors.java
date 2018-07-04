package dataStructure.StringAndArray.TwoPointers;

/**
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Notice
 * 
 * You are not suppose to use the library's sort function for this problem. You
 * should do it in-place (sort numbers in the original array).
 * http://www.lintcode.com/en/problem/sort-colors/
 * https://leetcode.com/problems/sort-colors/
 *
 * 此题实际上就是Partition Array (PartitionArray.java)的升级版：   原本是分成两部分， 现在是分成 三部分
 *
 * 三种解法:  1) 用两次Partition Array   2) two pass with counting sort     3) 3个指针       
 *
 */
public class SortColors {
	//Best solution: just one pass - 3 pointers solution
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <2)
            return;
        
        int p0 =0, p2 = nums.length-1;
        int p1 =0; //第三个指针来判断中间的数，然后往左右两边swap
        while(p1 <= p2){
            if(nums[p1] == 0){
                swap(nums,p0, p1);
                p0++;
                p1++;
            }else if(nums[p1] == 2){
                swap(nums,p1,p2);
                p2--;  
            }else{
                p1++;
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
}

////////////////////////////////////////////////////////////////////////////////

//Straight forward solution: a two-pass algorithm using counting sort.
class Solution2 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <2)
            return;
        int red=0, white=0, blue=0;
        for(int i : nums){
            switch(i){
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                default:
                    blue++;
                    break;              
            }
        }
        int p=-1;
        if(red>0) {
        	p = red -1;
        	assignColors(nums,0,p,0);
        }
          
        if(white>0) {
        	assignColors(nums,p+1,p+white,1);
        	p += white;
        }
            
        if(blue>0) {
        	assignColors(nums,p+1,p+blue,2);
        	p += blue;
        }
            
    }
    
    private void assignColors(int[] nums, int start, int end, int color){
        for(int i= start; i <=end; i++) {
        	nums[i] = color;
        }
    }
}
