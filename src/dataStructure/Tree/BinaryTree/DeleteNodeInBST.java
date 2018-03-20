package dataStructure.Tree.BinaryTree;


/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 
 *
 *解题思路 Steps:
1. Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
2. Once the node is found, have to handle the below 4 cases： 
	node doesn't have left or right - return null
	node only has left subtree- return the left subtree
	node only has right subtree- return the right subtree
	node has both left and right - find the minimum value in the right subtree, 
			set that value to the currently found node, then recursively delete the minimum value in the right subtree
 */
public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {
	    if(root == null){
	        return null;
	    }
	    if(key < root.val){
	        root.left = deleteNode(root.left, key);
	    }else if(key > root.val){
	        root.right = deleteNode(root.right, key);
	    }else{ // Once the node is found
	        if(root.left == null){
	            return root.right;
	        }else if(root.right == null){
	            return root.left;
	        }
	        //Node has both left and right - find the minimum value in the right subtree
	        TreeNode minNode = findMin(root.right);
	        root.val = minNode.val;
	        root.right = deleteNode(root.right, root.val);
	    }
	    return root;
	}
	//Minimum node must be left node in Binary Search Tree
	private TreeNode findMin(TreeNode node){
	    while(node.left != null){
	        node = node.left;
	    }
	    return node;
	}
	
	
}
