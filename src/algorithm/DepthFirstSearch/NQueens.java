package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * http://www.lintcode.com/en/problem/n-queens/
 * http://www.jiuzhang.com/solutions/n-queens/
 * 
 *
 */
public class NQueens {

	/**
	 * Get all distinct N-Queen solutions
	 * 
	 * @param n:
	 *            The number of queens
	 * @return: All distinct solutions For example, A string '...Q' shows a
	 *          queen on forth position
	 */
	ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> solutions = new ArrayList<>();
		if (n < 1) {
			return solutions;
		}

		dfsHelper(solutions, new ArrayList<Integer>(), n);
		return solutions;

	}

	private void dfsHelper(ArrayList<ArrayList<String>> solutions, ArrayList<Integer> columns, int n) {
		if (columns.size() == n) {
			solutions.add(drawChessboard(columns));
		}
		for (int col = 0; col < n; col++) {
			if (canBeAttacked(columns, col)) {
				continue;
			}
			columns.add(col);
			dfsHelper(solutions, columns, n);
			columns.remove(columns.size() - 1);
		}
	}

	private ArrayList<String> drawChessboard(List<Integer> columns) {
		ArrayList<String> solution = new ArrayList<>();
		for (int i = 0; i < columns.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < columns.size(); j++) {
				sb.append(columns.get(i) == j ? 'Q' : '.');
			}
			solution.add(sb.toString());

		}
		return solution;
	}

	// "no two queens attack each other" means
	// no two queens share the same row, column, or diagonal.
	private boolean canBeAttacked(ArrayList<Integer> columns, int col) {
		int row = columns.size();
		for (int j = 0; j < columns.size(); j++) {
			//Cannot share same column
			if (columns.get(j) == col) {
				return true;
			}
			
			//判断两点是否在斜线 (对角线) 上
			//和 相等   (在左下- 右上 的 斜线上)
			if (j + columns.get(j) == row + col) {
				return true;
			}
			//差相等   (在右下- 左上 的 斜线上)
			if (j - columns.get(j) == row - col) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		NQueens instance = new NQueens();
		System.out.println(instance.solveNQueens(4));
		

	}

}
