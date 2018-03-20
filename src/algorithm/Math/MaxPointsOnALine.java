package algorithm.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * https://leetcode.com/problems/max-points-on-a-line/
 * http://www.jiuzhang.com/solutions/max-points-on-a-line/
 * http://www.cnblogs.com/grandyang/p/4579693.html
 *
 *
解题思路：This problem can be solve by counting points that have the same slope for each point. 
When counting, we need to be careful about the duplicate points and points on the vertical lines. 
	
 */
public class MaxPointsOnALine {

	//Time Complexity: O(n^2)
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Map<String, Integer> slope = new HashMap<>();
			int maxPoints = 0, duplicate = 0, vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
					continue;
				}
				int dx = points[i].x - points[j].x;
				int dy = points[i].y - points[j].y;
				int gcd = calculateGCD(dx, dy); // Greatest Common Divisor 最大公约数
				dx /= gcd;
				dy /= gcd;
				String key = dy + "/" + dx;
				if (slope.containsKey(key)) {
					slope.put(key, slope.get(key) + 1);
				} else {
					slope.put(key, 1);
				}

				maxPoints = Math.max(maxPoints, slope.get(key));

			}
			maxPoints = Math.max(maxPoints, vertical);
			result = Math.max(result, maxPoints + duplicate + 1); // DO NOT forget to add 1, the point itself
		}

		return result;
	}

	//Greatest Common Divisor 最大公约数
	private int calculateGCD(int a, int b) {
		return b == 0 ? a : calculateGCD(b, a % b);
	}

}


/**
 * Definition for a point.  */
 class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }





