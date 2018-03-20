package dataStructure.LinkedList;

/**
 * 
 * http://www.lintcode.com/en/problem/sort-list/
 * http://www.jiuzhang.com/solutions/sort-list/
 * 
 * 
 *
 */
public class SortList {
	   /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if(head == null || head.next ==null ){
            return head;
        }
        ListNode middle = findMiddleOfList(head);
        //List右半边
        ListNode rigthSorted = sortList(middle.next);
        //从中间砍断，一分二，这样左边list 才知道什么时候到终点
        middle.next = null;
        ListNode leftSorted = sortList(head);
        
        ListNode newHead = mergeTwoSortedList(leftSorted, rigthSorted);
        
        return newHead;
    }
    
    private ListNode findMiddleOfList(ListNode head){
       ListNode fast = head.next;
       ListNode slow = head;
       while(fast !=null && fast.next !=null){
           fast = fast.next.next;
           slow = slow.next;
       }
        return slow;
        
    }
    
    //此方法就是另外一个题目  http://www.lintcode.com/en/problem/merge-two-sorted-lists/
    private ListNode mergeTwoSortedList(ListNode head1, ListNode head2){
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        while(head1 !=null && head2 !=null){
            if(head1.val <= head2.val){
                p.next = head1;
                head1 = head1.next;
            }else{
                p.next = head2;
                head2 = head2.next;
            }
             p = p.next;
        }
        
        if(head1 !=null){
            p.next = head1;
        }else{
            p.next = head2;
        }
        
        return dummyNode.next;
    }
    
}
