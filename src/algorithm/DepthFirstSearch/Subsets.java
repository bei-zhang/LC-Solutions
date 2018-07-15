package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * Given a set of distinct integers, return all possible subsets.
 * 
 * http://www.lintcode.com/en/problem/subsets/
 * http://www.jiuzhang.com/solutions/subsets/
 * 
 * LC# 78. Subsets
 * 
 */

public class Subsets {
	//DFS(Recommended solution).  Time: O(2^n),   Space: O(n)
	//按照Lai Offer的思路写的
	class Solution1 {
		public List<List<Integer>>  subsets(int[] nums) {
			List<List<Integer>>  res = new ArrayList<>();
			if(nums == null || nums.length == 0) return res;
			dfsHelper(res, new ArrayList<>(), nums, 0);
			return res;
		}
		private void dfsHelper(List<List<Integer>> result, List<Integer> subset, int[] nums, int pos) {
			if(pos == nums.length) {
				// Deep Copy
				result.add(new ArrayList<>(subset)); //DO NOT soft copy like result.add();
				return;
			}
			subset.add(nums[pos]);
			dfsHelper(result,subset, nums, pos+1);
			subset.remove(subset.size()-1); //backtracking
			dfsHelper(result,subset, nums, pos+1);
		}
	}

//////////  Solution2  //////////
	// 递归：实现方式，一种实现DFS算法的一种方式
	public List<List<Integer>>  subsets(int[] nums) {
		List<List<Integer>>  result = new ArrayList<>();
		if (nums == null || nums.length == 0) return result;
		dfsHelper(result, new ArrayList<>(), nums, 0); //找到所有以 [] 开头的 子集， 放到result 里
		return result;
	}

	// 递归三要素
	// 1.递归的定义 (接收什么样的参数， 返回什么样的值， 做了什么事)
	// 找到所有以subset 开头的 子集， 然后放到result 里
	// DFS algorithms template
	private void dfsHelper(List<List<Integer>> result, List<Integer> subset, int[] nums, int index) {
		// Deep Copy
		result.add(new ArrayList<Integer>(subset));//DO NOT soft copy like result.add();

		// 2. 递归的拆解
		for (int i = index; i < nums.length; i++) {
			subset.add(nums[i]); // [] ->[1] or [1] -> [1,2]
			dfsHelper(result, subset, nums, i + 1);
			subset.remove(subset.size() - 1);//backtracking
		}
		// 自然而然 return
		// 3. 递归的出口 (什么时候可以不往下递归了，可以直接找到答案退出)
	}
		

	// Non Recursion: this solution uses Bit Manipulation
	/**
	 * 解题思路：
思路就是使用一个正整数二进制表示的第i位是1还是0，代表集合的第i个数取或者不取。
所以从0到2^n-1总共2^n个整数，正好对应集合的2^n个子集。
S = {1,2,3}
N bit Combination
0 000 {}
1 001 {1}
2 010 {2}
3 011 {1,2}
4 100 {3}
5 101 {1,3}
6 110 {2,3}
7 111 {1,2,3}
	 *
	 */
	class Solution2{
	    public List<List<Integer>> subsets(int[] nums) {
	    	List<List<Integer>> result = new ArrayList<>();
	        int n = nums.length;
	        // 1 << n is 2^n
	        // each subset equals to an binary integer between 0 .. 2^n - 1
	        // 0 -> 000 -> []
	        // 1 -> 001 -> [1]
	        // 2 -> 010 -> [2]
	        // ..
	        // 7 -> 111 -> [1,2,3]
	        for (int i = 0; i < (1 << n); i++) {
	            List<Integer> subset = new ArrayList<>();
	            for (int j = 0; j < n; j++) {
	                // check whether the jth digit in i's binary representation is 1
	                if ((i & (1 << j)) != 0) {
	                    subset.add(nums[j]);
	                }
	            }
	            result.add(subset);
	        }
	        return result;
	    }

	}
	

	public static void main(String[] args) {
		Subsets subset = new Subsets();
		int[] nums =   {1,2,3};
		List<List<Integer>> results = subset.subsets(nums);
		
		System.out.println(results.toString());
		
		

	}

}
