package dataStructure.LinkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

 * http://www.lintcode.com/en/problem/partition-list/
 * https://leetcode.com/problems/partition-list/#/description
 * http://www.jiuzhang.com/solutions/partition-list/
 * 
 *
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        
        ListNode left = dummyLeft, right = dummyRight;
        while(head !=null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = dummyRight.next;
        
        return dummyLeft.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		head.next = node1;
		node1.next = node2;

	}

}

