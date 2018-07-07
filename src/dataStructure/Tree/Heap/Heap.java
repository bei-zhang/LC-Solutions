package dataStructure.Tree.Heap;

/****************************************************************************
 *       This demonstrates binary heap operations along with the heapSort.
 *   Copied from https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/code/Heap.java
 *   
 *****************************************************************************/
import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>> {
	private static final int CAPACITY = 2;

	private int size; // Number of elements in heap
	private AnyType[] heap; // The heap array

	public Heap() {
		size = 0;
		heap = (AnyType[]) new Comparable[CAPACITY];
	}

	/**
	 * Construct the binary heap given an array of items.
	 */
	public Heap(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[array.length + 1];

		System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0 index

		heapify();
	}

	/**
	 * runs at O(size) Build a Heap
	 */
	private void heapify() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		AnyType tmp = heap[k];
		int child;

		for (; 2 * k <= size; k = child) {
			child = 2 * k;

			if (child != size && heap[child].compareTo(heap[child + 1]) > 0)
				child++;

			if (tmp.compareTo(heap[child]) > 0)
				heap[k] = heap[child];
			else
				break;
		}
		heap[k] = tmp;
	}

	/**
	 * Sorts a given array of items.
	 */
	public void heapSort(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[size + 1];
		System.arraycopy(array, 0, heap, 1, size);
		heapify();

		for (int i = size; i > 0; i--) {
			AnyType tmp = heap[i]; // move top item to the end of the heap array
			heap[i] = heap[1];
			heap[1] = tmp;
			size--;
			percolatingDown(1);
		}
		for (int k = 0; k < heap.length - 1; k++)
			array[k] = heap[heap.length - 1 - k];
	}

	/**
	 * Deletes the top item
	 */
	public AnyType deleteMin() throws RuntimeException {
		if (size == 0)
			throw new RuntimeException();
		AnyType min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min;
	}

	/**
	 * Inserts a new item
	 */
	public void insert(AnyType x) {
		if (size == heap.length - 1)
			doubleSize();

		// Insert a new item to the end of the array
		int pos = ++size;

		// Percolate up
		for (; pos > 1 && x.compareTo(heap[pos / 2]) < 0; pos = pos / 2)
			heap[pos] = heap[pos / 2];

		heap[pos] = x;
	}

	private void doubleSize() {
		AnyType[] old = heap;
		heap = (AnyType[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public String toString() {
		StringBuilder out = new StringBuilder();
		for (int k = 1; k <= size; k++)
			out.append(heap[k] + " ");
		return out.toString();
	}

	public static void main(String[] args) {
		Heap<String> h = new Heap<String>();

		h.insert("D");
		h.insert("C");
		h.insert("A");
		h.insert("X");
		System.out.println(h);
		h.deleteMin();
		System.out.println(h);

		Heap<Integer> tmp = new Heap<Integer>();
		Integer[] a = { 6, 8, 7, 7, 10, 0, 2, 3, 5, 1 };
		tmp.heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}