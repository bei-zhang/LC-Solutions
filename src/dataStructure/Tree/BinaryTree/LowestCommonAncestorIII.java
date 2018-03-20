package dataStructure.Tree.BinaryTree;


/**
 * Given the root and two nodes in a Binary Tree. 
 * Find the lowest common ancestor(LCA) of the two nodes.
 * 
 * http://www.lintcode.com/en/problem/lowest-common-ancestor-iii/
 * 
 * LowestCommonAncestor 题的升级版
 * 区别在于此题中 Node A or B may not exist in the tree. Return null if LCA does not exist.
 * Facebook phone interview question that I got on 8/18/2017
 * 	解题思路： 因为需要标记A, B是否存在 tree 中，所以我们需要一个 ResultType 来保存 额外的变量 aExist, bExist
  		在root为根的二叉树中找A,B的LCA:
     	如果碰到A, 就将A保存在ResultType的ancestor, 同时标记A 存在，   aExist = true
     	如果碰到B, 就将B保存在ResultType的ancestor, 同时标记B 存在，   bExist = true
     	只有当A 和 B 为 true时，ResultType的ancestor 才是 所要找的 LCA.  否则就返回null
           
 */
public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    	ResultType resultType = helper(root, A, B);
        if(resultType.aExist && resultType.bExist){
        	return resultType.ancestor;
        }
        return null;
    }
    private ResultType helper(TreeNode currentNode, TreeNode A, TreeNode B) {
    	if( currentNode== null){
    		return new ResultType(currentNode, false, false);
    	}
    	ResultType leftResult = helper(currentNode.left, A, B);
    	ResultType rightResult = helper(currentNode.right, A, B);
    	
    	boolean aExist = leftResult.aExist || rightResult.aExist || currentNode == A; //keep searching if node A exists in tree
    	boolean bExist = leftResult.bExist || rightResult.bExist || currentNode == B; //keep searching if node B exists in tree
    	
    	//如果碰到A, 就将A保存在ResultType的ancestor, 同时标记A 存在，   aExist = true
     	//如果碰到B, 就将B保存在ResultType的ancestor, 同时标记B 存在，   bExist = true
    	if(currentNode == A || currentNode == B){
    		return new ResultType(currentNode, aExist, bExist);
    	}
    		
    	if(leftResult.ancestor !=null && rightResult.ancestor != null){//如果左右子树各自找到了一个node,那么说明currentNode 就是所要找的LCA
    		return new ResultType(currentNode, aExist, bExist);
    	}
    	if(leftResult.ancestor !=null){//
    		return new ResultType(leftResult.ancestor, aExist, bExist);
    	}
    	if(rightResult.ancestor !=null){
    		return new ResultType(rightResult.ancestor, aExist, bExist);
    	}
    	return new ResultType(null, aExist, bExist);
        
    }
    
   
}


class ResultType{
	TreeNode ancestor;
	boolean aExist;
	boolean bExist;
	public ResultType(TreeNode ancestor, boolean foundA, boolean foundB){
		this.ancestor = ancestor;
		this.aExist = foundA;
		this.bExist = foundB;
	}
}
