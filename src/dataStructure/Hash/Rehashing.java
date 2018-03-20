package dataStructure.Hash;


/**
 * 
 * http://www.lintcode.com/en/problem/rehashing/
 * http://www.jiuzhang.com/solutions/rehashing/
 * 
 *
 */
public class Rehashing {

	   /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if(hashTable == null || hashTable.length ==0){
            return null;
        }
        int capacity = hashTable.length;
        ListNode[] newHashTable = new ListNode[2 * capacity];
        
        for(int i=0; i<capacity;i++){
            if(hashTable[i] !=null){
                ListNode node = hashTable[i];
                while(node!=null){
                    add(newHashTable, new ListNode(node.val));
                    node = node.next;
                }
                
            }
        }
        
        return newHashTable;
    }
    
    //add a node to the new HashTable
    private void add(ListNode[] hashTable , ListNode node){
        int capacity = hashTable.length;
        int index = ( node.val % capacity + capacity) % capacity;
        if(hashTable[index] ==null){
            hashTable[index] = node;
        }else{
            ListNode lastNode = hashTable[index];
            while(lastNode!=null && lastNode.next!=null){
                lastNode = lastNode.next;
            }
            lastNode.next = node;
            
        }
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

