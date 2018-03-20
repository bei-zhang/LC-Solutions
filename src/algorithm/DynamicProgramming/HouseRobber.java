package algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/house-robber/
 * http://www.lintcode.com/en/problem/house-robber/#
 * http://www.jiuzhang.com/solution/house-robber
 * http://blog.csdn.net/ljiabin/article/details/46958233
 * 
 * 
 * 由于不是求具体的方案(返回的不是哪些houses， 而是抢到的最多的钱)， 不能用搜索(DFS,BFS)
 * 采用DP
 * f(i) = max(f(i-1),  f(i-2)+ A[i-1])
 * 
 * 滚动数组 优化一维空间从O(n) 到O(1)  看下面Solution2. 
 * 
 * 相同题目不同问法: Maximum sum such that no two elements are adjacent
 * 
 * Follow up: what if it's circular array?
 * 对于循环数组有三种解决方式:1) 分裂   2) 取反    3) 增倍
 * 
 */
public class HouseRobber {

	//O(n) time,  O(n) space
	public class Solution {
	    public long houseRobber(int[] A) {
	        if(A == null || A.length ==0){
	            return 0;
	        }
	        long[] dp = new long[A.length+1];
	        dp[0] =0;
	        dp[1] =A[0];
	        long max = dp[1];
	        for(int i=2; i<=A.length;i++){
	            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i-1]);
	            max = Math.max(max, dp[i]);
	        }
	        
	        return max;
	    }
	}
	
	//O(n) time,  O(1) space
	//滚动数组 优化空间从O(n) 到O(1)  看下面Solution2. 
	public class Solution2 {
	    public long houseRobber(int[] A) {
	        if(A == null || A.length ==0){
	            return 0;
	        }
	        int n = A.length;
	        long[] dp = new long[2];
	        dp[0] =0;
	        dp[1] =A[0];
	        for(int i=2; i<=n;i++){
	            dp[i%2] = Math.max(dp[(i-1)%2], dp[(i-2)%2] + A[i-1]);
	        }
	        
	        return dp[n%2];
	    }
	}
//////////////////////////////////////////
	
	//O(n) time,  O(1) space   (自己写的解法  recommended solution )
	//跟solution2 一样， 思路: 用2个变量 exclusive(不含当前数，所得到的最大值) inclusive (包含当前数，所得到的最大值), 最后返回两数中较大的一个
	class Solution3 {
	    public int rob(int[] nums) {
	        if(nums == null || nums.length ==0) 
	            return 0;
	        int exclusive =0, inclusive =nums[0], temp =0;
	        for(int i=1;i<nums.length;i++){
	            temp = exclusive;
	            /* current max excluding i */
	            exclusive = inclusive > exclusive ? inclusive: exclusive;
	            inclusive = temp + nums[i];
	        }
	        return inclusive > exclusive ? inclusive: exclusive;
	    }
	}
	
	public static void main(String[] args) {
		int[][] dp = new int[3][3];
		System.out.println(dp[1][1]);

	}

}
