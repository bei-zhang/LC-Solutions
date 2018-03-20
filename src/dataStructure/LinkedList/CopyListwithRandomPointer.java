package dataStructure.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
 * http://www.jiuzhang.com/solutions/copy-list-with-random-pointer/
 * 
 * 
 *总结： 
 * 此题类似于CloneGraph，由于是Linked List,遍历所有nodes 比较简单，一个while 循环就可以， 
 * 		而 CloneGraph 需要 用BFS 去遍历所有nodes
 * 
 *
 */
public class CopyListwithRandomPointer {

	/**
	 * @param head:
	 *            The head of linked list with a random pointer.
	 * @return: A new head of a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// 1. get the mapping for old nodes -> new nodes -- copy nodes, store the old->new mapping information in a HashMap
		Map<RandomListNode, RandomListNode> mapping = getMapping(head);

		// 2. old next and random -> new next and random -- copy edges
		RandomListNode curr = head;//为了不改变head,所以用另外一个变量
		while (curr != null) {
			RandomListNode newNode = mapping.get(curr);
			if (curr.next != null) {
				newNode.next = mapping.get(curr.next);
			}
			if (curr.random != null) {
				newNode.random = mapping.get(curr.random);
			}
			curr = curr.next;
		}

		return mapping.get(head);
	}

	// get old -> new Node mapping.
	private Map<RandomListNode, RandomListNode> getMapping(RandomListNode head) {
		Map<RandomListNode, RandomListNode> mapping = new HashMap<>();
		RandomListNode curr = head; //为了不改变head,所以用另外一个变量
		while (curr != null) {
			RandomListNode newNode = new RandomListNode(curr.label);
			mapping.put(curr, newNode);
			curr = curr.next;
		}
		return mapping;
	}

	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

}
