package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * LC# 39. Combination Sum
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.


Notice 
•All numbers (including target) will be positive integers.
•Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
•The solution set must not contain duplicate combinations.
 * 
 * http://www.lintcode.com/en/problem/combination-sum/#
 * http://www.jiuzhang.com/solutions/combination-sum/
 *
 * 类似题目: CombinationSumII.java,   CoinChangeII.java
 *
 */
public class CombinationSum {

	//来Offer的解题思路, 自己独立写出来的Solution
	class Solution1 {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(candidates == null || candidates.length ==0){
	            return result;
	        }
			Arrays.sort(candidates);
			findCombination(target, candidates, 0, new int[candidates.length], result);
			return result;
		}
		
	    private void findCombination(int targetLeft, int[]candidates, int level, int[] combination, List<List<Integer>> result) {
	    	int index = candidates.length - 1- level;
	    	if(level == candidates.length - 1) {//Base case
	    		if(targetLeft > 0 && targetLeft % candidates[index] !=0) {
	    			return;
	    		}
	    		combination[index] = targetLeft / candidates[index];
	    		result.add(generateCombination(candidates, combination));
	    		return;
	    	}
	    	
	    	//每一层有多少个分支 就调用自己多少次     dynamically changed  K叉树
	    	for(int i=0; i<= targetLeft/candidates[index];i++) {
	    		combination[index] = i;
	    		findCombination(targetLeft - i * candidates[index], candidates, level+1, combination, result);
	    	}
	    }
	    
	    private List<Integer> generateCombination(int[]candidates, int[] combination){
	    	List<Integer> res = new ArrayList<>();
    		for(int i=0; i<combination.length ;i++) {
    			for(int j=0; j<combination[i];j++) {
    				res.add(candidates[i]);
    			}
    		}
    		return res;
	    }
	    
	}	
	
////////////////////////////////////////	
	//按照九章算法 解题思路
	class Solution2 {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> combinations = new ArrayList<>();
	        if(candidates == null || candidates.length ==0){
	            return combinations;
	        }
	        int[] newCandidates = sortAndRemoveDuplicates(candidates);
	        bfs(newCandidates, 0, target, new ArrayList<Integer>(), combinations);
	        return combinations;
	    }
	    
		// DFS algorithms template
		private void bfs(int[] candidates, int startIndex, int target, List<Integer> combination, List<List<Integer>> result) {
			if (target == 0) {
				result.add(new ArrayList<>(combination));
				return;
			}

			for (int i = startIndex; i < candidates.length; i++) {
				if (candidates[i] > target) {
					break;
				}
				combination.add(candidates[i]);
				// 因为可以重复取数， 这里i不加1， 不同于 subset那道题
				bfs(candidates, i, target - candidates[i], combination, result);
				combination.remove(combination.size() - 1);
			}

		}
	    
	    //Standard algorithm to remove duplicates
	    private int[] sortAndRemoveDuplicates(int[] candidates){
	        Arrays.sort(candidates);
	        int index =0;
	        for(int i =0; i<candidates.length ; i++){
	            //如果有相等的数，那 i 一直往下走， 直到不相等的数
	            if(candidates[i] != candidates[index]){
	                candidates[++index] = candidates[i]; 
	            }
	        }
	        int[] newCandidates = new int[index + 1];
	        for(int i=0;i<=index ;i++){
	            newCandidates[i] = candidates[i];
	        }
	        return newCandidates;
	    }
	}
    
}