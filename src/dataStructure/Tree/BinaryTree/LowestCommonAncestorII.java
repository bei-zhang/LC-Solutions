package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;

/**
 * 
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * http://www.lintcode.com/en/problem/lowest-common-ancestor-ii/
 * 
 * 
 * 此题与 LowestCommonAncestor 区别是
 * The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 *
 *
 */
public class LowestCommonAncestorII {
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
		ArrayList<ParentTreeNode> pathA = getPath2Root(A);
		ArrayList<ParentTreeNode> pathB = getPath2Root(B);

		int indexA = pathA.size() - 1;
		int indexB = pathB.size() - 1;

		ParentTreeNode lowestAncestor = null;
		while (indexA >= 0 && indexB >= 0) {
			if (pathA.get(indexA) != pathB.get(indexB)) {
				break;
			}
			lowestAncestor = pathA.get(indexA);
			indexA--;
			indexB--;
		}

		return lowestAncestor;
	}

	private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
		ArrayList<ParentTreeNode> path = new ArrayList<>();
		while (node != null) {
			path.add(node);
			node = node.parent;
		}
		return path;
	}
}

class ParentTreeNode {
	public ParentTreeNode parent, left, right;
}
