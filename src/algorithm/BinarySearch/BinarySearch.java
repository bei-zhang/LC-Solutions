package algorithm.BinarySearch;


/**
 * Binary search is a famous question in algorithm. 
 *	For a given sorted array (ascending order) -nums and a target number - target, 
 *  Find the any/first/last position of target in nums - 3 different questions are as follows
 *  If the target number does not exist in the array, return -1. 
  
   九章的 模板
  http://www.jiuzhang.com/solutions/binary-search/
 *
 */
public class BinarySearch {
	
	/**
	 * Classical Binary Search :  Find any position of target in nums
	 * Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2 or 3.
	 * http://www.lintcode.com/en/problem/classical-binary-search/
	 * 
	 *  九章算法 的 模板
	 */
	public static int findAnyPosition(int[] nums, int target){
		if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
        	//avoid overflow
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
            	// return since we just need to find any position.
                return mid;  
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
	
	
	/**
	 * 
	 * Find the first position of target in nums
	 * Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
	 * http://www.lintcode.com/problem/first-position-of-target/
	 * 
	 * 九章算法 的 模板
	 */
	public static int findFirstPosition(int[] nums, int target){
		if(nums == null || nums.length ==0){
			return -1;
		}
		int start = 0 , end = nums.length - 1;
		while (start + 1 < end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target){
				end = mid; // this line is different from findAnyPosition and findLastPosition
				//return mid;   //return if we just need to find any position.
			}else if (nums[mid] < target){
				start = mid;
			}else {
				end = mid;
			}
		}
		
		//Check nums[start] first, as we need to find first position of target  
		if(nums[start] == target){
			return start;
		}
		if(nums[end] == target){
			return end;
		}

		return -1;
	}
	
	/**
	 * Find the last position of target in nums
	 * Example If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 3.
	 * http://www.lintcode.com/en/problem/last-position-of-target/
	 * 
	 */
	public static int findLastPosition(int[] nums, int target){
		if(nums == null || nums.length ==0){
			return -1;
		}
		int start = 0 , end = nums.length - 1;
		while (start + 1 < end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target){
				// this line is different from findFirstPosition and findAnyPosition
				start = mid; 
			}else if (nums[mid] < target){
				start = mid;
			}else {
				end = mid;
			}
		}
		
		//Check nums[end] first , as we need to find last position of target 
		if(nums[end] == target){
			return end;
		}
		if(nums[start] == target){
			return start;
		}

		return -1;
	}
	
	
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 3, 4, 5, 10};
		int[] b = {3,3,3};
		System.out.println(findAnyPosition(a , 3));
		System.out.println(findFirstPosition(b , 3));

		
		
		
	}

}
