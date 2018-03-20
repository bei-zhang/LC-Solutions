package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * 
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
 */
public class CombinationSum {
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
	private void bfs(int[] candidates, int startIndex, int target, List<Integer> combination,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(combination));
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