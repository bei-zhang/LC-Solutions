package algorithm.DynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 * 
 *
 */
public class BestTimeToBuyAndSellStockII {
	
	/**
	 Approach 1: Simple One Pass
	 Time complexity : O(n). Single pass.
     Space complexity: O(1). Constant space needed.
	 */
    class Solution {
		public int maxProfit(int[] prices) {
		    int total = 0;
		    for (int i=0; i< prices.length-1; i++) {
		        if (prices[i+1]>prices[i])
		        	total += prices[i+1]-prices[i];
		    }
		    
		    return total;
		}
	}
	
	/**
	 Approach 2: Peak Valley Approach
	 Time complexity : O(n). Single pass.
     Space complexity: O(1). Constant space needed.
	 */
    class Solution2 {
        public int maxProfit(int[] prices) {
            int i = 0;
            int n = prices.length;
            int valley = prices[0];
            int peak = prices[0];
            int maxprofit = 0;
            while (i < n - 1) {
                while (i < n - 1 && prices[i] >= prices[i + 1])
                    i++;
                valley = prices[i];
                while (i < n - 1 && prices[i] <= prices[i + 1])
                    i++;
                peak = prices[i];
                maxprofit += peak - valley;
            }
            return maxprofit;
        }
    }
}
