package algorithm.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/can-i-win/
 * https://leetcode.com/problems/can-i-win/discuss/
 * https://www.jiuzhang.com/solution/can-i-win
 * 
 * 1) Brute force :  time complexity O(n!)
 * 2) Top-down DP :  Time complexity: O(2^n)
 *
 */
public class CanIWin {

	//Top-down DP solution:  Time complexity: O(2^n)
	class Solution {
		public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
			int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
			if (desiredTotal > sum)
				return false;
			if (desiredTotal <= 0)
				return true;

			Map<Integer, Boolean> map = new HashMap<>();
			return helper(desiredTotal,map, new boolean[maxChoosableInteger + 1]);
		}

		private boolean helper(int desiredTotal, Map<Integer, Boolean> map, boolean[] used) {
			if(desiredTotal <=0) return false;
			int key = format(used);
			if(!map.containsKey(key)){ // try every unchosen number as next step
				for(int i=1;i<used.length;i++){
					if(!used[i]){
						used[i] = true;
						// check whether this lead to a win, which means helper(desiredTotal - i, map, used) must return false (the other player lose)
						if(!helper(desiredTotal - i, map, used)){
							map.put(key, true);
							used[i] = false;  // 此处为什么要为false
							return true;
						}
						used[i] = false;  // 此处为什么要为false
					}
				}
				map.put(key, false);
			}
			
			return map.get(key);
		}

		// transfer boolean[] to an Integer with binary representation
		private int format(boolean[] used) {
			int num = 0;
			for (boolean b : used) {
				num <<= 1;
				if (b)
					num |= 1;
			}
			return num;
		}

	}

	public static void main(String[] args) {
		CanIWin can = new CanIWin();
		Solution solution = can.new Solution();
		boolean[] flag = new boolean[5];
		String curr = Arrays.toString(flag);
		flag[2] = true;
		System.out.println(solution.format(flag));

	}

}
