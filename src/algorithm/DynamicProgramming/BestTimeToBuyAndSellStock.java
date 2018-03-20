package algorithm.DynamicProgramming;
/**
 ********In June, 2017, I got this question during 3rd round of on-site interview at Amazon.*****
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
 * http://www.jiuzhang.com/solution/best-time-to-buy-and-sell-stock/
 * 
 *
 */
public class BestTimeToBuyAndSellStock {
	// time complexity: O(n)    (recommended)
	class Solution1 {
	    public int maxProfit(int[] prices) {
	        if(prices ==null || prices.length <2){
	            return 0;
	        }
	        int maxProfit =0;
	        int minPrice = Integer.MAX_VALUE;
	        for(int price : prices){
	           //对于前面的数，只关心和保存最小price.
	           minPrice = Math.min(minPrice, price);
	           //对于任一点，求最大profit,只需要减去之前出现过的最小price, 然后与之前已经求出的maxProfit比较看谁更大
	           maxProfit = Math.max(maxProfit, price-minPrice);
	        }
	        
	        return maxProfit;
	    }
	}
	
	
	//brute force:  time complexity: O(n^2)
	class Solution2 {
	    public int maxProfit(int[] prices) {
	        if(prices ==null || prices.length <2){
	            return 0;
	        }
	        int maxProfit =0;
	        for(int i=0; i<prices.length-1;i++){
	            for(int j=i+1; j<prices.length;j++){
	                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
	            }
	        }
	        return maxProfit;
	    }
	}
	
	
	public static void main(String[] args) {
		

	}

}
