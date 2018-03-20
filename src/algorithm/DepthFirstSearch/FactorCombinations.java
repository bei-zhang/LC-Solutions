package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * 
 * https://leetcode.com/problems/factor-combinations/
 * http://www.cnblogs.com/grandyang/p/5332722.html
 * 
 *
 */
public class FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(2, 1, n, result, list);
		return result;
	}

	//DFS
	public void helper(int start, int product, int n, List<List<Integer>> result, List<Integer> curr) {
		if (start > n || product > n)
			return;

		if (product == n) {
			ArrayList<Integer> t = new ArrayList<>(curr);
			result.add(t);
			return;
		}

		for (int i = start; i < n; i++) {
			if (i * product > n)
				break;

			if (n % i == 0) {
				curr.add(i);
				helper(i, i * product, n, result, curr);
				curr.remove(curr.size() - 1); //backtracking
			}
		}
	}

	public static void main(String[] args) {

	}

}
