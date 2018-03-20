package dataStructure.Hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/lru-cache/
 * http://www.lintcode.com/en/problem/lru-cache/
 * http://www.jiuzhang.com/solutions/lru-cache/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * Difficulty: hard
 * 
 * 解题思路:
 * LRUCache = DoublyLinkedList+ HashMap
 * HashMap(key, Node) 注意这里key 在HashMap和Node object 里面都有存, 这样当reach capacity时，要从HashMap里面删除一个元素 必须要知道key, 这就是为什么必须 两边都要存key的原因
 * DoublyLinkedList 里需要有dummyHead and dummyTail,  
 * Head 存放的 Least Recently Used Node. When the cache reached its capacity, remove the head node before adding to tail
 * Tail 存放刚访问过(或刚加入)的Node   在操作LinkedList 时， 画图出来后就很好理解了
 */
class Node { // DoublyLinkedList
	Node prev, next;
	int key, value;
	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
public class LRUCache {
	private HashMap<Integer, Node> hashMap; //HashMap(key, Node)
	private int capacity = 0;
	private Node dummyHead;
	private Node dummyTail;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		hashMap = new HashMap<>(); 
		dummyHead = new Node(-1, -1);
		dummyTail = new Node(-1, -1);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}
	//get(key) operation is O(1) time complexity
	public int get(int key) {
		if (!hashMap.containsKey(key))  
			return -1; // return special value if not exist
		// remove current node from the list
		Node current = hashMap.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		moveToTail(current); //move current node to the tail of the list
		return current.value;
	}
	//put(key, value) operation is O(1) time complexity
	public void put(int key, int value) {
		//1.check if it exists in cache. The node will be moved to tail when get() method is called
		if (get(key) != -1) {//Update value if key exists in cache. 
			hashMap.get(key).value = value;
			return;
		}
		//2. Check if it reaches the capacity
		if (hashMap.size() == capacity) {
			hashMap.remove(dummyHead.next.key);//HashMap和Node object 两边都要存key, 这样才能从HashMap里面删除指定Node
			Node newHead = dummyHead.next.next;
			dummyHead.next = newHead;
			newHead.prev = dummyHead;
		}
		//3. Create new node, add to HashMap and then move it to the tail
		Node newNode = new Node(key, value);
		hashMap.put(key, newNode);
		moveToTail(newNode);
	}

	// Move the current node to the tail
	private void moveToTail(Node current) {
		dummyTail.prev.next = current;
		current.prev = dummyTail.prev;
        current.next = dummyTail;
		dummyTail.prev = current;	
	}

	
	
	public static void main(String[] args) {
		
	}

}

