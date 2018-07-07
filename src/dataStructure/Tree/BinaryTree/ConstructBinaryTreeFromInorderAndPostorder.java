package dataStructure.Tree.BinaryTree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * 
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorder {

	// O(n) time and O(n) space
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
 
    private TreeNode myBuildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poststart, int postend) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
	    int position = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	        	position = i;
	        }
	    }

        root.left = myBuildTree(inorder, inStart, position - 1, postorder, poststart, poststart + position - inStart - 1);
        root.right = myBuildTree(inorder, position + 1, inEnd, postorder, poststart + position - inStart, postend - 1);
        return root;
    }    




}
