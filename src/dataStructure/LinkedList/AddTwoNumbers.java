package dataStructure.LinkedList;


/**
 * 
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 * http://www.lintcode.com/en/problem/add-two-numbers/
 * http://www.jiuzhang.com/solutions/add-two-numbers/
 * https://leetcode.com/problems/add-two-numbers/#/description
 * 
 * 超大整数(超过系统范围)以 LinkedList 形式存储， 求两数相加
 * 
 * 
 * Follow up: See problem: AddTwoNumbersII 
 *  
 *  
 * Similar question: AddBinary, AddTwoNumbersII
 * 
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode pointer = dummyNode;
        int carry =0;
        while(l1!=null && l2 !=null){
            int sum = l1.val + l2.val + carry;
            pointer.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            pointer = pointer.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            pointer.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            pointer = pointer.next;
        }
        
        while(l2 !=null){
            int sum = l2.val + carry;
            pointer.next = new ListNode(sum%10);
            carry = sum/10;
            l2 = l2.next;
            pointer = pointer.next;
        }
        
        if(carry >0){
            pointer.next = new ListNode(carry);
        }
        
        return dummyNode.next;
        
    }
    
    
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(2);
		

		ListNode result = addTwoNumbers(l1,l2);
		System.out.println(result.toString());
	}

}
