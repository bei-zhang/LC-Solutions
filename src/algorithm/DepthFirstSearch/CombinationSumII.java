package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * 
 * 
 *  Tags(此题标签):  DFS, Recursion,Combination 
 *  
 * 总结： 
 * 此题在 CombinationSum 题目的 基础上 只多了 要对重复元素的处理
 * 
 * 排列问题对重复元素的处理方式 (跟 Subsets II 一样 )： 
 * 	1). 先排序   -- Arrays.sort(nums);
 *  2). 当 i 不是 startIndex，   重复元素不能再被使用  -- (i>startIndex && nums[i] == nums[i-1])
 *
 *
 *
 */
public class CombinationSumII {

	/**
	 * @param num:
	 *            Given the candidate numbers
	 * @param target:
	 *            Given the target number
	 * @return: All the combinations that sum to target
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return combinations;
		}

		Arrays.sort(candidates);
		dfs(candidates, 0, target, new ArrayList<Integer>(), combinations);
		return combinations;

	}

	private void dfs(int[] nums, int startIndex, int target, List<Integer> combination,
			List<List<Integer>> result) {

		if (target == 0) {
			result.add(new ArrayList<Integer>(combination));
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if (nums[i] > target) {
				break;
			}

  /*
            下面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2], sum 为3 ，result {1,2}, 但是取第一个 2 和第二 2，我们也认为是同一种方案，
            为了保证唯一性，我们强制要用2必须要用前面的2，代码实现 当 i 不是 startIndex， 后面的 2 不能被重复使用
    */
			if (i > startIndex && nums[i] == nums[i - 1]) {
				continue;
			}

			combination.add(nums[i]);
			dfs(nums, i + 1, target - nums[i], combination, result);
			combination.remove(combination.size() - 1);
		}

	}

	public static void main(String[] args) {
		CombinationSumII instance = new CombinationSumII();
		int[] input = { 1, 2, 6, 3, 2, 1 };
		List<List<Integer>> result = instance.combinationSum2(input, 8);
		System.out.println(result.toString());

	}

}
