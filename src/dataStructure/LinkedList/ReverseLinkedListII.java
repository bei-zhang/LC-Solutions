package dataStructure.LinkedList;


/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * https://leetcode.com/problems/reverse-linked-list-ii
 * http://www.lintcode.com/en/problem/reverse-linked-list-ii/
 * 
 * 
 *
 * Similar problem: ReverseLinkedListIII
 * 
 */
public class ReverseLinkedListII {
	
	//Do it in-place and in one-pass. (Optimized solution. Recommended) 自己独立实现的
	class Solution{
		//Simply just reverse the list along the way using 4 pointers: dummy, prev, start, curr, temp
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if(m >= n || head == null){
				return head;
			}
			ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
			dummy.next = head;
			
			ListNode prev = dummy; // make a pointer prev as a marker for the node before reversing
			for(int i=0; i<m-1;i++){
				prev = prev.next;
			}
			
			ListNode start = prev.next; //Save the start (m th) node of a sub-list that will be reversed
			ListNode curr = start; // a pointer to keep track of the current node which will be handled
			ListNode temp =null;
			for(int i=0;i<=n-m;i++){
				temp = curr.next;
				curr.next = prev.next;
				prev.next = curr;
				curr = temp;
			}
			start.next = curr; // connecting to the remaining part
			
			return dummy.next;
		}
		
	}

///////////////////////////////////////////////////////////////////////////////////////////
	//Not optimized solution - 解题思路： 找到需要reverse的起始点，同时也要保存前一个节点和 后面一个的节点
	    public ListNode reverseBetween(ListNode head, int m, int n) {
	        ListNode left =null;
	        ListNode start = null;
	        ListNode end = null;
	        ListNode right = null;
	        start = head; // if m =1
	        if(m > 1){
	            left = head;
	            int i = m;
	            while(i>2){
	                left = left.next;
	                i--;
	            }
	            start = left.next;
	        }
	        
	        int j = n-m;
	        end = start;
	        while(j>0){
	            end = end.next;
	            j--;
	        }
	        right = end.next;
	        
	        ListNode reversedNode = reverse(start, right);
	        if(left!=null){
	            left.next = reversedNode;
	            return head;
	        }else{
	            return reversedNode;
	        }
	               
	    }
	        
	    //reverse 从start开始的node， 直到tail 点结束. 
	    private ListNode reverse(ListNode start, ListNode tail){
	        ListNode newHead = tail; // reverse 后的那一段与tail连接着
	        ListNode curr = start;
	        ListNode next;
	        while(curr!= tail){
	            next = curr.next;
	            curr.next = newHead;
	            newHead = curr;
	            curr = next;
	        }
	        return newHead;
	    }
	    
	
}
