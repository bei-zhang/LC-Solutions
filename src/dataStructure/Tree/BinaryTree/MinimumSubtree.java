package dataStructure.Tree.BinaryTree;


/**
 * 
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * 
 * http://www.lintcode.com/en/problem/minimum-subtree/
 * 
 * 
 *
 */
public class MinimumSubtree {

    private TreeNode treeNode;
    private int minSubSum = Integer.MAX_VALUE;
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return treeNode;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int subSsum = helper(root.left) + helper(root.right) + root.val;
        if(subSsum < minSubSum){
            minSubSum = subSsum;
            treeNode = root;
        }
        return subSsum;
    }
    
    
    
}
