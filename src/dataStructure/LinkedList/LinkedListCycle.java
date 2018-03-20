package dataStructure.LinkedList;

/**
 * http://www.lintcode.com/en/problem/linked-list-cycle/
 * 
 *
 *解题思路: 2个指针: 快慢指针 - 快指针每次走两步，慢指针每次走一步， 如果有环，那么他们一定会在环上某一点重合
 *
 
 Follow up: If there is a cycle, return the node where the cycle begins. 
 See "LinkedListCycleII"

 */
public class LinkedListCycle {

	
	/**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        if(head == null || head.next ==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //slow 和 fast 重合 则确定有cycle
        while(slow != fast){
            if(fast == null || fast.next ==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    
}
