package dataStructure.Tree.BinaryTree;


/**
 * http://www.lintcode.com/en/problem/lowest-common-ancestor/
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 * http://www.jiuzhang.com/solutions/lowest-common-ancestor/
 * 
 *
 *See follow up question: LowestCommonAncestorIII, LowestCommonAncestorII
 *
 */
public class LowestCommonAncestor {
	//解题思路： 
	// 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root ==null || root == A || root == B){
            return root;
        }
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        //Conquer
        if(left!=null && right!=null){
            return root;
        }
        if(left !=null){
            return left;
        }
        if(right !=null){
            return right;
        }
        
        return null;
        
    }
    
}
