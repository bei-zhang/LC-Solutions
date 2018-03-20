package common;


public class LinkedListNode {
	//For single LinkedList
	public int data;    
	public LinkedListNode next;
	
	//for Doubly LinkedList
	public LinkedListNode prev;
	
	public LinkedListNode(int data){
		this.data=data;
		this.next=null;
	}
	public void addLastNode(LinkedListNode node){
		LinkedListNode tail=this.next;
		if(tail==null){
			this.next=node;
			return;
		}
		while(tail.next!=null){
			tail=tail.next;
		}
		tail.next=node;
	
	}
	
	
	@Override
    public String toString() {
		return printForward();
		
    }
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
	
	

	public LinkedListNode(int d, LinkedListNode next, LinkedListNode p) {
		data = d;
		addLastNode(next);
		setPrevious(p);
	}
	
	public LinkedListNode() { }

	/*public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}*/
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		/*if (p != null && p.next != this) {
			p.setNext(this);
		}*/
	}	
	

	public LinkedListNode clone() {
		LinkedListNode next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		return head2;
	}
	
}