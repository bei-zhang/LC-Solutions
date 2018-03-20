package dataStructure.StringAndArray.TwoPointers;

/**
 * http://www.lintcode.com/en/problem/trapping-rain-water/
 * http://www.jiuzhang.com/solution/trapping-rain-water/
 * 
 * 解题思路：
 *  1. 先看左右两端 柱子高度， 确定灌水基调
 *  2. 从两边往中间罐, 哪边低就先灌那一边
 *  
 * Follow up:  2D array:  TrappingRainWaterII.java
 */
public class TrappingRainWater {
	//Two pointers 
	public class Solution {
	    public int trapRainWater(int[] heights) {
	        if(heights == null || heights.length <3){
	            return 0;
	        }
	        int left = 0, right = heights.length -1;
	        int leftHeight = heights[left];
	        int rightHeight = heights[right];
	        
	        int result = 0;
	        while(left < right){
	            if(leftHeight < rightHeight){
	                left++;
	                leftHeight = Math.max(leftHeight, heights[left]);//碰到更高的柱子，那就更新左边的高度
	                result+=  leftHeight - heights[left];//碰到低的柱子，意味着可以灌水，所以跟新result
	            }else{
	                right--;
	                rightHeight = Math.max(rightHeight, heights[right]);
	                result+= rightHeight - heights[right]; 
	            }
	        }
	        return result;
	    }
	}
	
}
