package dataStructure.Tree.BinaryTree;


/**
 * 
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

 Notice
LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum average.

 * http://www.lintcode.com/en/problem/subtree-with-maximum-average/
 * 
 *Amazon
 *
 *
 *
 */
public class SubtreewithMaximumAverage {

	private TreeNode maxAverageSubtree;
	private ResultType subtreeResult;

	/**
	 * @param root
	 *            the root of binary tree
	 * @return the root of the maximum average of subtree
	 */
	public TreeNode findSubtree2(TreeNode root) {
		helper(root);
		return maxAverageSubtree;

	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		ResultType result = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);

		if (maxAverageSubtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size) {
			maxAverageSubtree = root;
			subtreeResult = result;
		}

		return result;

	}

	class ResultType {
		public int sum;
		public int size;

		public ResultType(int sum, int size) {
			this.sum = sum;
			this.size = size;
		}

	}

	
	public static void main(String[] args) {

	}

}
