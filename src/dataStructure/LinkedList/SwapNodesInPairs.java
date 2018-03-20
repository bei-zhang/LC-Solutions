package dataStructure.LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * 
 */
public class SwapNodesInPairs {
	// non-recursive
	class Solution {
		public ListNode swapPairs(ListNode head) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode current = dummy;
			while (current.next != null && current.next.next != null) {
				ListNode first = current.next;
				ListNode second = current.next.next;
				first.next = second.next;
				second.next = first;
				current.next = second;
				current = current.next.next;
			}
			return dummy.next;
		}
	}

	////////////////////////////////////////////////////////////////
	// recursive solution
	public class Solution2 {
		public ListNode swapPairs(ListNode head) {
			if ((head == null) || (head.next == null))
				return head;
			ListNode n = head.next;
			head.next = swapPairs(head.next.next);
			n.next = head;
			return n;
		}
	}

}
