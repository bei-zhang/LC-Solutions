package dataStructure.Tree.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 * http://www.jiuzhang.com/solutions/merge-k-sorted-lists/
 * 
 * 
 * If they are K sorted Array, 实现类似 题目 SmallestRange, 利用一个额外数组listArr保存k个list的当前下标，初始为0
 * 
 * External sorting uses the idea of merge sort.
 * 
 * 此题就是 K-Way Merge Algorithms 这题必须会,大公司必考题 而且应用广泛， 有 三种实现方式， 全部都要掌握:
 * 						Time complexity 		Space complexity 
 * 1) Heap 				O(nlogk) 				O(k) 因为heap里面一直存放 k 个数
 * 2) Divide&Conquer 	O(nlogk) 				O(1) 
 * 3) Merge two by two 	O(nlogk) 				O(1)
 *
 *
 * 类似题目： SmallestRange,  MergeKSortedArray
 * 
 */
public class MergeKSortedLists {
	// Solution#1: Heap/PriorityQueue
	class Solution1 {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0) {
				return null;
			}
			Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
			//Add the head node from each list into heap
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					minHeap.offer(lists[i]);
				}
			}
			ListNode dummyNode = new ListNode(0);
			ListNode pointer = dummyNode;
			while (!minHeap.isEmpty()) {
				ListNode minNode = minHeap.poll();
				pointer.next = minNode;
				pointer = pointer.next;
				if (minHeap.isEmpty())// For the last list, it can end earlier.
					break;
				
				// move to the next node on that List whose head was removed.
				if (minNode.next != null) 
					minHeap.offer(minNode.next);
			}
			return dummyNode.next;
		}
	}

	// Solution 2: Divide & Conquer
	class Solution2 {
		public ListNode mergeKLists(List<ListNode> lists) {
			if (lists.size() == 0) {
				return null;
			}
			return mergeHelper(lists, 0, lists.size() - 1);
		}

		private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
			if (start == end) {
				return lists.get(start);
			}

			int mid = start + (end - start) / 2;
			ListNode left = mergeHelper(lists, start, mid);
			ListNode right = mergeHelper(lists, mid + 1, end);
			return mergeTwoLists(left, right);
		}

		private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			ListNode dummy = new ListNode(0);
			ListNode tail = dummy;
			while (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					tail.next = list1;
					tail = list1;
					list1 = list1.next;
				} else {
					tail.next = list2;
					tail = list2;
					list2 = list2.next;
				}
			}
			if (list1 != null) {
				tail.next = list1;
			} else {
				tail.next = list2;
			}

			return dummy.next;
		}
	}

	// Solution 3: merge two by two
	public class Solution3 {
		public ListNode mergeKLists(List<ListNode> lists) {
			if (lists == null || lists.size() == 0) {
				return null;
			}

			while (lists.size() > 1) {
				List<ListNode> new_lists = new ArrayList<ListNode>();
				for (int i = 0; i + 1 < lists.size(); i += 2) {
					ListNode merged_list = merge(lists.get(i), lists.get(i + 1));
					new_lists.add(merged_list);
				}
				if (lists.size() % 2 == 1) {
					new_lists.add(lists.get(lists.size() - 1));
				}
				lists = new_lists;
			}

			return lists.get(0);
		}

		private ListNode merge(ListNode a, ListNode b) {
			ListNode dummy = new ListNode(0);
			ListNode tail = dummy;
			while (a != null && b != null) {
				if (a.val < b.val) {
					tail.next = a;
					a = a.next;
				} else {
					tail.next = b;
					b = b.next;
				}
				tail = tail.next;
			}

			if (a != null) {
				tail.next = a;
			} else {
				tail.next = b;
			}

			return dummy.next;
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

