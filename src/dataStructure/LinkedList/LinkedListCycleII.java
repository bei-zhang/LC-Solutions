package dataStructure.LinkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * http://www.lintcode.com/en/problem/linked-list-cycle-ii/
 * http://www.jiuzhang.com/solutions/linked-list-cycle-ii/
 * 
 * 
 *
 */
public class LinkedListCycleII {
	 /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public static ListNode detectCycle(ListNode head) {  
        if(head == null || head.next == null){
            return null;
        }
        //1. Check if this list contains a cycle
        //解题思路: 2个指针: 快慢指针 - 快指针每次走两步，慢指针每次走一步， 如果有环，那么他们一定会在环上某一点重合
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
            if(fast ==null || fast.next== null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //----如果程序到此还未退出，那么证明 slow 和 fast 重合， 即确定此list有cycle----
        
        //2. Find the node where the cycle begins
        //思路：  从head开启一个新的指针, 和慢指针一样每次走一步, 他一定会与 slow.next重合
        //至于为什么一定会重合，这个数学问题可以额外被证明,记住这个答案就好. 
        //如果不知道这个规律，那么只能用HashSet来判断重复节点  (additional O(n) space)
        ListNode p = head;
        while(p != slow.next){
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
    
    
}
