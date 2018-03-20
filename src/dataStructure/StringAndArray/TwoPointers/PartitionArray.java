package dataStructure.StringAndArray.TwoPointers;

/**
 * Given an array nums of integers and an int k, 
 * 	partition the array (i.e move the elements in "nums") such that:
All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.
 * 
 *  Notice

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

 *
 *
 *Follow up:  Partition into three parts.  See "Sort Colors"
 *
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
        if(nums ==null || nums.length ==0){
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            while(left <= right && nums[left] < k){
                left++;
            }
            while(left <= right && nums[right] >= k){
                right--;
            }
            
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
        
        return left ;
        
    }
    
	public static void main(String[] args) {

	}

}
