package algorithm.DepthFirstSearch;

import java.util.Arrays;

/**
 * LC#518 Coin Change 2
 * You are given coins of different denominations 
 * and a total amount of money. Write a function to compute the number of combinations 
 * that make up that amount. You may assume that you have infinite number of each kind of coin.
 * 
 *
 */
public class CoinChangeII {
	class Solution {
		private int count;
	    public int change(int amount, int[] coins) {
	        if(coins == null || coins.length == 0) return 0;
	        Arrays.sort(coins);
	    	findCombination(amount, coins, 0, new int[coins.length]);
	    	return count;
	    }
	    private void findCombination(int moneyLeft, int[]coins, int level, int[] res) {
	    	if(level == coins.length - 1) {
	    		
	    	}
	    }
	}
	
}
