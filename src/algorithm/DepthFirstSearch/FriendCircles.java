package algorithm.DepthFirstSearch;

/**
 * https://leetcode.com/problems/friend-circles/solution/
 *
 * See Union Find solution: {@link dataStructure.Graph.UnionFind.FriendCircles}
 * 
 */
public class FriendCircles {

	/**
	 * DFS Solution
	 * to find the number of connected components, we start from every node which isn't visited right now 
	 * and apply DFS starting with it. We increment the count of connected components for every new starting node.
	 
	 Time complexity : O(n^2). The complete matrix of size n^2 is traversed.
     Space complexity : O(n). visited array of size n is used.
	 */
	class Solution1 {
		public int findCircleNum(int[][] M) {
			int[] visited = new int[M.length];
			int count = 0;
			for (int i = 0; i < M.length; i++) {
				if (visited[i] == 0) {
					dfsHelper(M, visited, i);
					count++;
				}
			}
			return count;
		}
		
		private void dfsHelper(int[][] M, int[] visited, int i) {
			for (int j = 0; j < M.length; j++) {
				if (M[i][j] == 1 && visited[j] == 0) {
					visited[j] = 1;
					dfsHelper(M, visited, j);
				}
			}
		}

	}

}
