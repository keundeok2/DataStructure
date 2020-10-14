package heap.maxheap.impl;

import java.util.ArrayList;

public class MaxHeap {

	private ArrayList<Integer> heap;

	public MaxHeap() {
		heap = new ArrayList<>();
		heap.add(0);
	}

	public void insert(int data) {
		heap.add(data);

		int position = heap.size() - 1;
		while (position > 1 && heap.get(position / 2) < heap.get(position)) {
			int temp = heap.get(position);
			heap.set(position, heap.get(position / 2));
			heap.set(position / 2, temp);

			position /= 2;
		}
	}

	public int delete() {

		// heap에 data가 없는 경우
		if (heap.size() - 1 < 1) {
			return -1;
		}

		int deleteData = heap.get(1);

		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int position = 1;
		while ((position * 2) < heap.size()) {
			int maxPos = position * 2;
			int max = heap.get(maxPos);

			System.out.println("position : " + position);
			System.out.println("max : " + max);
			System.out.println("maxPos : " + maxPos);

			if ((position * 2 + 1) < heap.size() && max < heap.get(position * 2 + 1)) {
				System.out.println("change");
				maxPos = position * 2 + 1;
				max = heap.get(maxPos);
			}

			if (max < heap.get(position)) break;

			System.out.println("change");
			int temp = heap.get(position);
			heap.set(position, max);
			heap.set(maxPos, temp);
			position = maxPos;

		}
		return deleteData;
	}

	public String toString() {
		return heap.toString();
	}

}
