package heap.maxheap.impl;

public class Main {
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.insert(2);
		maxHeap.insert(4);
		maxHeap.insert(6);
		maxHeap.insert(9);
		maxHeap.insert(8);
		System.out.println(maxHeap);
		System.out.println(maxHeap.delete());
		System.out.println(maxHeap);
		System.out.println(maxHeap.delete());
		System.out.println(maxHeap);
	}
}
