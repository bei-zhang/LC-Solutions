package dataStructure.Tree.BinaryTree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 
 *此题是Easy 难度， 要比 {@LowestCommonAncestor} 简单
 *
 * 由于是 BST， 要充分利用其特点: 左子树比父亲节点小，右子树比父亲节点大 
 *
 */
public class LowestCommonAncestorOnBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        
        if(root.val < p.val && root.val < q.val){ 
            return lowestCommonAncestor(root.right, p, q); // search right subtree if both are greater than root value. 
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q); // search left subtree if both are less than root value. 
        }else{
            return root; //otherwise, return root 两节点分布在左右子树，那么当前父节点就是 LowestCommonAncestor
        }
    }
    
}
