package dataStructure.LinkedList;


/**
 * 
 * http://www.lintcode.com/en/problem/reverse-linked-list/
 * http://www.jiuzhang.com/solutions/reverse-linked-list/
 * 
 *  Follow up (real interview question asked by Fortinet on 7/25/2017 ) 
 *  What if the linked list has a cycle in it? how to reverse it.
 *  解题思路: 先判断是否有环，如果有环找到环开始的地方，同样用下面那段代码，
 *  	         但是while loop退出的条件改成 第二次碰到the node where the cycle begins
 *  
 *  
 */
public class ReverseLinkedList {

	//Just reverse the list along the way using 3 pointers: curr, newHead, temp
    public ListNode reverse(ListNode head) {
    	ListNode curr = head;
    	ListNode newHead = null, temp = null; // local variable must be initialized
        while(curr!=null){
        	//类似于 swap (a,b), 每次把等号 右边的 变量放到等号左边
            temp = curr.next; // Save next node to temp
            curr.next = newHead; //Point the current node to newHead node. 
            newHead = curr; //move newHead node
            curr = temp; // move curr node
        }
        
        return newHead;
    }
    
	
}


