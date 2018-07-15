package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * 
 *http://www.lintcode.com/en/problem/permutations-ii/
 *http://www.jiuzhang.com/solutions/permutations-ii/
 *https://leetcode.com/problems/permutations-ii/#/description
 *
 *
 *
 *Tags(此题标签):  DFS, Recursion, Permutation
 *
 *总结：
 *
 *此题和 Permutations 相比：
 *1. Firstly, sort the given array:  Arrays.sort(nums)
 *2. Use an extra array (boolean[] visited) to track if an element has been visited.
 *
 *****
 *此题和 Combination Sum II 相比：
 *相同点:  给定数组都有重复数字，所以必须先排序 Arrays.sort(nums);
 *不同点:  在去除重复元素影响时， 此题要额外  !visited[i - 1]， 因为每次都是从0 开始，不是startIndex
 *
 * Permutations II
 *( i > 0          && nums[i] == nums[i - 1] && !visited[i - 1])
 *
 *
 *Combination Sum II
 *( i > startIndex && nums[i] == nums[i - 1]  )
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			permutations.add(permutation);
			return permutations;
		}
		//sort the given array first
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		dfsHelper(nums, visited, permutations, permutation);
		return permutations;
	}

	private void dfsHelper(int[] nums, boolean[] visited, List<List<Integer>> permutations, List<Integer> permutation) {
		if (permutation.size() == nums.length) {
			permutations.add(new ArrayList<Integer>(permutation));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			
		   /*
		            下面的判断主要是为了去除重复元素影响。
		            比如，给出一个排好序的数组，[1,2,2]，那么第一个 2 和第二 2 如果在结果中互换位置，我们也认为是同一种方案，
		            所以我们强制要求相同的数字，原来排在前面的，在结果当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就不应该让后面的2使用。
            */
			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				continue;
			}

			permutation.add(nums[i]);
			visited[i] = true;
			dfsHelper(nums, visited, permutations, permutation);
			permutation.remove(permutation.size() - 1);
			visited[i] = false;

		}

	}

	public static void main(String[] args) {

	}

}
