package dataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 * http://articles.leetcode.com/printing-binary-tree-in-zig-zag-level_18/
 *http://bangbingsyb.blogspot.com/2014/11/leetcode-binary-tree-zigzag-level-order.html
 *http://www.jiuzhang.com/solution/binary-tree-zigzag-level-order-traversal
 *
 *
 *思路：

Binary Tree Level Order Traversal那题的变种。一样的层序访问，区别仅仅在于访问是左向右，右向左交替进行。

Hint: 
Different from BinaryTreeLevelOrderTraversal, Queue is not helpful here. You might want to consider using Stack instead.

Solution:
This problem can be solved easily using two stacks (one called currentLevel and the other one called nextLevel). 
You would also need a variable to keep track of the current level’s order (whether it is left->right or right->left).

1. 用两个stack来存储curLevel和nextLevel的节点可以实现这样的左右顺序反转。因为stack是先进后出的，节点push进stack的顺序和pop出stack的顺序正好是相反的：

假设stack curLevel pop出的第一个节点是该层的最左节点x，压入x->left和x->right进stack nextLevel。这样依次类推，等整个curLevel的节点都pop出来后，x->left和x->right在nextLevel的最底部。当之后开始pop nextLevel时，最后才pop到x->left和x->right。换句话说，curLevel第一个被访问到的节点的子节点，将在nextLevel中最后被访问到。

2. 这里还需注意的是push left/right child进nextLevel的顺序。当curLevel从左向右访问时，应当先push(x->left)再push(x->right)，反之则应该先push(x->right)再push(x->left)。实现时可以用一个bool变量left2right来表示顺序，每访问完一层后反转left2right的值。


 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public class Solution {
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    	List<List<Integer>> result = new ArrayList<>();

	        if (root == null) {
	            return result;
	        }

	        Stack<TreeNode> currLevel = new Stack<TreeNode>();
	        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
	        Stack<TreeNode> tmp;
	        
	        currLevel.push(root);
	        boolean normalOrder = true;

	        while (!currLevel.isEmpty()) {
	            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
	            while (!currLevel.isEmpty()) {
	                TreeNode node = currLevel.pop();
	                currLevelResult.add(node.val);

	                if (normalOrder) {
	                    if (node.left != null) {
	                        nextLevel.push(node.left);
	                    }
	                    if (node.right != null) {
	                        nextLevel.push(node.right);
	                    }
	                } else {
	                    if (node.right != null) {
	                        nextLevel.push(node.right);
	                    }
	                    if (node.left != null) {
	                        nextLevel.push(node.left);
	                    }
	                }
	            }

	            result.add(currLevelResult);
	            //swap currLevel and nextLevel
	            tmp = currLevel;
	            currLevel = nextLevel;
	            nextLevel = tmp;
	            //flip order flag
	            normalOrder = !normalOrder;
	        }

	        return result;

	    }
	}
}
