package dataStructure.LinkedList;


/**
 * 
 * WalmartLabs on site problem  (I got this question during my 1st round of WalmartLabs on-site on 8/28/2017).
 * 
 * 跟题目 ReverseLinkedListII 一样， Only difference is m and n are given nodes in this problem instead of indices. 
 * 
  注意特殊情况： if the head is the start node (could equal to given nodes)
 *
 *
 */
public class ReverseLinkedListIII {
	
	public ListNode reverseBetween(ListNode head, ListNode m, ListNode n) {
		if(head == null || m == null || n == null || m ==n){
			return head;
		}
		ListNode start = null, end =null;
		ListNode prev = null, remaining = null;
		ListNode p = head;
		
		//check if head is the start node
		if(head ==m || head == n){
			start = head;
		}
		boolean nodesExist = false;
		while(!nodesExist && p!=null){
			if(start == null){
				if(p.next == m){
					start = m;
					prev = p;
				}else if(p.next == n){
					start = n;
					prev = p;
				}
			}else if(end == null){
				if(p.next == m){
					end = m;
					remaining = end.next;
					nodesExist = true;
				}else if(p.next == n){
					end = n;
					remaining = end.next;
					nodesExist = true;
				}
			}
		}
		if(!nodesExist){
			return head;
		}
		
		ListNode reversedNode =  reverse(start, remaining);
		//
		if(start == head){
			return reversedNode;
		}else{
			prev.next = reversedNode;
			return head;
		}
		
	}
	
	
	private ListNode reverse(ListNode start, ListNode remaining){
		ListNode curr = start;
		ListNode prev = null;
		ListNode temp = null;
		while(curr!= remaining){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		start.next = remaining;
		
		return prev;
	}
	

}
