package dataStructure.LinkedList;

/**
 * Given a node from a cyclic linked list which has been sorted, write a
 * function to insert a value into the list such that it remains a cyclic sorted
 * list. The given node can be any single node in the list. Return the inserted
 * new node.
 * 
 * Notice
 * 
 * 3->5->1 is a cyclic list, so 3 is next node of 1. 
 * 3->5->1 is same with 5->1->3
 * 
 * http://www.lintcode.com/en/problem/insert-into-a-cyclic-sorted-list/
 * 
 * 解题思路:  
 * if we just see the values, it's like rotated sorted values. 
 *  The inserted new value can be two areas,所以我们需要考虑一下两种情况
 * 1) 上升区间 ascending area 
 * 2) 拐点 turning point  i.e. between max_node -> min_node
 * 
 */
public class InsertIntoCyclicSortedList {

    /**
     * @param node a list node in the cyclic sorted list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        ListNode newNode = new ListNode(x);
        if(node == null){
            newNode.next = newNode;
            return newNode;
        }
        
        ListNode prev = null;
        ListNode p = node;
        do{
            prev = p;
            p = p.next;
            //1) 上升区间 ascending area 
            if(prev.val <= x && p.val >= x ){
                break;
                
            //2) 拐点 turning point  i.e. between max_node -> min_node
            }else if(prev.val > p.val && (prev.val <= x || p.val >=x) ){
                break;
            }
            
        }while (p != node);
        
        prev.next = newNode;
        newNode.next = p;
        
        return newNode;
    }
    
}
