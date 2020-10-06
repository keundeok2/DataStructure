package heap.minheap.impl;

public class Main {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		
		minHeap.insert(10);
		minHeap.insert(5);
		minHeap.insert(9);
		minHeap.insert(3);
		minHeap.insert(6);
		minHeap.insert(1);
		minHeap.insert(4);
		System.out.println(minHeap);
		minHeap.delete();
		System.out.println(minHeap);
		minHeap.delete();
		System.out.println(minHeap);
	}
}
