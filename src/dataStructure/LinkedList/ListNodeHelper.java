package dataStructure.LinkedList;

public class ListNodeHelper {

	public static ListNode initializeListNode() {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		head.next = node1;
		node1.next = node2;
		
		return head;
	}
	
	public static ListNode getPalindromeLinkedList() {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4= new ListNode(1);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next=node4;
		
		return head;
	}
	
	public static void main(String[] args) {

	}

}



class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	
	//以下只是为了自己本地测试方便
	@Override
    public String toString() {
		return printForward();
		
    }
	public String printForward() {
		if (next != null) {
			return val + "->" + next.printForward();
		} else {
			return ((Integer) val).toString();
		}
	}
	
}
