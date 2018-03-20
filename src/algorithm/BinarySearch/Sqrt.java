package algorithm.BinarySearch;

/**
 * http://www.lintcode.com/en/problem/sqrtx/
 * http://www.jiuzhang.com/solution/sqrtx
 * 
 *
 */
public class Sqrt {

	public int sqrt(int x) {
		long start = 1, end = x; // 注意一定要定义为long
		while (start + 1 < end) {
			long mid = start + (end - start)/2;  // 注意一定要定义为long
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				end = mid;
			} else {
				start = mid;
			}

		}
		if (end * end <= x) { //最后要判断
			return (int) end;
		}
		return (int) start;

	}

	public static void main(String[] args) {

	}

}
