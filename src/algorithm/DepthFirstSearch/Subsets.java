package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 
 * Given a set of distinct integers, return all possible subsets.
 * 
 * http://www.lintcode.com/en/problem/subsets/
 * http://www.jiuzhang.com/solutions/subsets/
 */

public class Subsets {
	// 递归：实现方式，一种实现DFS算法的一种方式
	class Solution {
		public ArrayList<ArrayList<Integer>> subsets(int[] num) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (num == null || num.length == 0) {
				return result;
			}
			ArrayList<Integer> subset = new ArrayList<Integer>();
			Arrays.sort(num);
			//找到所有以 [] 开头的 子集， 放到result 里 
			dfsHelper(result, subset, num, 0);
			return result;
		}

		// 递归三要素
		// 1.递归的定义 (接收什么样的参数， 返回什么样的值， 做了什么事)
		//找到所有以subset 开头的 子集， 然后放到result 里 
		//DFS algorithms template
		private void dfsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int[] num,
				int startIndex) {
			//deep copy
			result.add(new ArrayList<Integer>(subset));
			//do not do soft copy like result.add();
			
			//2. 递归的拆解
			for (int i = startIndex; i < num.length; i++) {
				subset.add(num[i]); // [] ->[1] or [1] -> [1,2]
				dfsHelper(result, subset, num, i + 1);
				subset.remove(subset.size() - 1);
			}
			//自然而然 return
			//3. 递归的出口 (什么时候可以不往下递归了，可以直接找到答案退出)
		}
		
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
		 /**
	     * @param S: A set of numbers.
	     * @return: A list of lists. All valid subsets.
	     */
	    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        int n = nums.length;
	        Arrays.sort(nums);
	        
	        // 1 << n is 2^n
	        // each subset equals to an binary integer between 0 .. 2^n - 1
	        // 0 -> 000 -> []
	        // 1 -> 001 -> [1]
	        // 2 -> 010 -> [2]
	        // ..
	        // 7 -> 111 -> [1,2,3]
	        
	        for (int i = 0; i < (1 << n); i++) {
	            ArrayList<Integer> subset = new ArrayList<Integer>();
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
		Solution recursionSolution = subset.new Solution();
		int[] nums =   {1,2,3};
		ArrayList<ArrayList<Integer>> results = recursionSolution.subsets(nums);
		
		System.out.println(results.toString());
		
		

	}

}
