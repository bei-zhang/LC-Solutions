package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.

 * http://www.lintcode.com/en/problem/subsets-ii/
 * 
 * 
 * Tags(此题标签):  DFS, Recursion, Combination 
 * 
 * 总结： 
 * 此题在 Subsets题目的 基础上 只多了 要对重复元素的处理
 * 
 * 排列问题对重复元素的处理方式 跟 Combination Sum II 一样： 
 * 	1). 先排序   -- Arrays.sort(nums);
 *  2). 当 i 不是 startIndex，   重复元素不能再被使用  -- (i>startIndex && nums[i] == nums[i-1])
 * 
 *
 */
public class SubsetII {
	//DFS(Recommended solution): Time: O(2^n),   Space: O(n)
	//按照Lai Offer的思路写的
	class Solution1 {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			List<List<Integer>> res = new ArrayList<>();
			if (nums == null || nums.length == 0)
				return res;
			Arrays.sort(nums);
			dfsHelper(res, new ArrayList<>(), nums, 0);
			return res;
		}

		private void dfsHelper(List<List<Integer>> result, List<Integer> subset, int[] nums, int pos) {
			if (pos == nums.length) {
				result.add(new ArrayList<>(subset));
				return;
			}
			subset.add(nums[pos]);
			dfsHelper(result, subset, nums, pos + 1);
			subset.remove(subset.size() - 1);//DFS 任何情况 backtracking 不可少
			// 下面的判断主要是为了去除重复元素影响. 如果当前position的数等于 subset 里面最后一个数，那么我们skip掉下面一步
			if (subset.size() == 0 || subset.get(subset.size() - 1) != nums[pos]) {
				dfsHelper(result, subset, nums, pos + 1);
			}
		}
	}
	
/////////////////////////////	
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums ==null){
            return result;
        }
        ArrayList<Integer> subset = new ArrayList<>();
        if(nums.length ==0){
            result.add(subset);
            return result;
        }
        
        Arrays.sort(nums);
        
        dfsHelper(nums,0, result,subset);
        return result;
        
    }
    
    private void dfsHelper(int[] nums, int startIndex, 
                  ArrayList<ArrayList<Integer>> result, 
                  ArrayList<Integer> subset){
                      
        result.add(new ArrayList<Integer>(subset));
        
        for(int i=startIndex; i<nums.length; i++){
        	
        	  /*
            下面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2], sum 为3 ，result {1,2}, 但是取第一个 2 和第二 2，我们也认为是同一种方案，
            为了保证唯一性，我们强制要用2必须要用前面的2，代码实现 当 i 不是 startIndex， 后面的 2 不能被重复使用
    */
            if(i>startIndex && nums[i] == nums[i-1]){
                continue;
            }
            
            subset.add(nums[i]);
            dfsHelper(nums,i+1, result,subset);
            subset.remove(subset.size() - 1);
        }
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
