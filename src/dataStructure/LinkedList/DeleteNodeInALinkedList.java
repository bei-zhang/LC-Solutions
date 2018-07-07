package dataStructure.LinkedList;

/**
 * LC#237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 
 *
 */
public class DeleteNodeInALinkedList {

	//Approach: Swap with Next Node
	public void deleteNode(ListNode node) {
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	
}
