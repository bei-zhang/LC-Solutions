package dataStructure.LinkedList;


/**
 * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 * http://www.jiuzhang.com/solutions/merge-two-sorted-lists/
 * 
 *
 */
public class MergeTwoSortedLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode lastNode = dummyNode;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
            	lastNode.next = l1;
            	l1 = l1.next;
            }else{
            	lastNode.next = l2;
            	l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if(l1!=null){
            lastNode.next = l1;
        }else{
            lastNode.next = l2;
        }
        
        return dummyNode.next;
        
    }
}