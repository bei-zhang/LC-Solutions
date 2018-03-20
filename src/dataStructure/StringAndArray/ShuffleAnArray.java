package dataStructure.StringAndArray;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * https://leetcode.com/problems/shuffle-an-array/#/description
 * https://www.hrwhisper.me/leetcode-shuffle-array/
 * 
 * 
 * 思路：用swap，每次从[0, i]中随机一个数，和第i个数交换即可。
 *
 */
public class ShuffleAnArray {

	public class Solution {
		private int[] origin;
		private int[] output;
		private Random random;

		public Solution(int[] nums) {
			this.origin = nums;
			this.output = Arrays.copyOf(nums, nums.length);
			this.random = new Random();
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return origin;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int len = output.length;
			//思路：用swap，每次从[0, i]中随机一个数，和第i个数交换即可。
			for (int i = len - 1; i >= 0; i--) {
				int randomIndex = random.nextInt(i + 1);
				int temp = output[i];
				output[i] = output[randomIndex];
				output[randomIndex] = temp;

			}
			return output;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution
	 * obj = new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
	 * obj.shuffle();
	 */

	public static void main(String[] args) {
		ShuffleAnArray s = new ShuffleAnArray();
		int[] nums = { 1, 8, 6, 5 };
		Solution obj = s.new Solution(nums);

		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(10 - i));
		}

	}

}
