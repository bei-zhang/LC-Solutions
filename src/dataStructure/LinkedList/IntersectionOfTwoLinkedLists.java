package dataStructure.LinkedList;


/**
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 * http://www.lintcode.com/en/problem/intersection-of-two-linked-lists/
 * http://www.jiuzhang.com/solutions/intersection-of-two-linked-lists/
 * https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 * 
 * 此题把其中一个List首尾连接起来变成一个cyclic list, 然后 变成跟  题目 LinkedListCycleII 一样
 *
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null || headA.next == null || headB.next ==null ){
            return null;
        }
        
        //1. make listB as a cyclic list
        ListNode tail = null;
        ListNode p = headB;
        while(p !=null){
            if(p.next == null){
                tail = p;
                tail.next = headB;
                break;
            }
            p = p.next;
        }

        //----below is same as "LinkedListCycleII"------
        ListNode cycleStart = LinkedListCycleII.detectCycle(headA);
        
        //Remove the cycle in listB
        tail.next = null;
        
        return cycleStart;
    }  
  
	
}
