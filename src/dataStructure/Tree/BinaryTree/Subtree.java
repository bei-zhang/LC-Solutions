package dataStructure.Tree.BinaryTree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * http://www.lintcode.com/en/problem/subtree/
 * http://www.cnblogs.com/grandyang/p/6828687.html
 * 
 * 
 * 这道题转换一下思路，就是求从s的某个结点开始，跟t的所有结构都一样，那么问题就转换成了判断两棵树是否相同，也就是 SameTree 的问题了，
 * 这点想通了其实代码就很好写了，用递归来写十分的简洁，我们先从s的根结点开始，跟t比较，如果两棵树完全相同，那么返回true，
 * 		否则就分别对s的左子结点和右子结点调用递归再次来判断是否相同，只要有一个返回true了，就表示可以找得到。
 * 
 * Similar question: SameTree
 */
public class Subtree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (sameTree(s, t))
			return true;
		if (s == null)
			return false;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean sameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if ((s == null && t != null) || (s != null && t == null) || (s.val != t.val)) {
			return false;
		}
		return sameTree(s.left, t.left) && sameTree(s.right, t.right);

	}

	/**
	 * 这道题还可以用之前那道Serialize and Deserialize Binary Tree的解法，
	 * 思路是对s和t两棵树分别进行序列化，各生成一个字符串，如果t的字符串是s的子串的话，就说明t是s的子树，但是需要注意的是，为了避免出现[12], [2],
	 * 这种情况，虽然2也是12的子串，但是[2]却不是[12]的子树，所以我们再序列化的时候要特殊处理一下，
	 * 就是在每个结点值前面都加上一个字符，比如','，来分隔开，那么[12]序列化后就是",12,#"，而[2]序列化之后就是",2,#"，这样就可以完美的解决之前的问题了，参见代码如下：
	 * 
	 */
}
