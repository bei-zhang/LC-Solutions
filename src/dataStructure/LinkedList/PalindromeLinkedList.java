package dataStructure.LinkedList;

/**
 * 
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * 此题很全面，需要实现  findMiddle of LinkedList, 并且要 reverse LinkedList
 * 
 * There are many solutions if space can be O(n).
 * e.g. Save the value of each node to Stack while finding the middle node of LinkedList.
 *     And then pop the value from Stack and compare them starting from the head.
 * 
 * 
 * 
 */
public class PalindromeLinkedList {
	// With O(1) space, we have to reverse the right half LinkedList and compare. 
	//O(n) time,  O(1) space
	class Solution {
	    public boolean isPalindrome(ListNode head) {
	        if(head == null || head.next ==null) return true;
	        ListNode middleNode = findMiddle(head);
	        ListNode reversedHead = reverse(middleNode.next);
	        middleNode.next = null;
	        //compare two LinkedList
	        ListNode left = head, right = reversedHead;
	        while(left !=null && right !=null){
	            if(left.val != right.val)
	                return false;
	            left = left.next;
	            right = right.next;
	        }
	        return true;
	    }
	    
	    private ListNode findMiddle(ListNode head){
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while(fast !=null && fast.next !=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	    
	    private ListNode reverse(ListNode head){
	        ListNode curr = head;
	        ListNode newHead = null, temp = null;
	        while(curr!=null){
	            temp = curr.next;
	            curr.next = newHead;
	            newHead = curr;
	            curr = temp;
	        }
	        return newHead;
	    }
	    
	}
	
	public static void main(String[] args) {
		ListNode head = ListNodeHelper.getPalindromeLinkedList();
		Solution solution = new PalindromeLinkedList().new Solution();
		System.out.println(solution.isPalindrome(head));

	}

}
