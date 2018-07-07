package dataStructure.Tree.BinaryTree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
 * https://www.jiuzhang.com/solution/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 */
public class ConstructBinaryTreeFromInorderAndPreorder {

	// O(n) time and O(n) space
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length != preorder.length) {
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}

	private TreeNode myBuildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
		if (inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		
	    int position = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	        	position = i;
	        }
	    }

		root.left = myBuildTree(inorder, inStart, position - 1, preorder, preStart + 1, preStart + position - inStart);
		root.right = myBuildTree(inorder, position + 1, inEnd, preorder, position - inEnd + preEnd + 1, preEnd);
		return root;
	}
	
	public static void main(String[] args) {

	}

}
