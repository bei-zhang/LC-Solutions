package dataStructure.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
 * https://segmentfault.com/a/1190000003797291
 * 中序遍历法
复杂度
时间 O(N) 空间 Max(O(K),O(H))

思路
二叉搜索树的中序遍历就是顺序输出二叉搜索树，所以我们只要中序遍历二叉搜索树，同时维护一个大小为K的队列，前K个数直接加入队列，
之后每来一个新的数（较大的数），如果该数和目标的差，相比于队头的数离目标的差来说，更小，
则将队头拿出来，将新数加入队列。如果该数的差更大，则直接退出并返回这个队列，因为后面的数更大，差值也只会更大。
 */
public class ClosestBinarySearchTreeValueII {

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Queue<Integer> klist = new LinkedList<Integer>();
		Stack<TreeNode> stk = new Stack<TreeNode>();
		// 迭代中序遍历二叉搜索树的代码
		while (root != null) {
			stk.push(root);
			root = root.left;
		}
		while (!stk.isEmpty()) {
			TreeNode curr = stk.pop();
			// 维护一个大小为k的队列
			// 队列不到k时直接加入
			if (klist.size() < k) {
				klist.offer(curr.val);
			} else {
				// 队列到k时，判断下新的数是否更近，更近就加入队列并去掉队头
				int first = klist.peek();
				if (Math.abs(first - target) > Math.abs(curr.val - target)) {
					klist.poll();
					klist.offer(curr.val);
				} else {
					// 如果不是更近则直接退出，后面的数只会更大
					break;
				}
			}
			// 中序遍历的代码
			if (curr.right != null) {
				curr = curr.right;
				while (curr != null) {
					stk.push(curr);
					curr = curr.left;
				}
			}
		}
		// 强制转换成List，是用LinkedList实现的所以可以转换
		return (List<Integer>) klist;
	}

}
