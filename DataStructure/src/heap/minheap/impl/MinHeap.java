package heap.minheap.impl;

import java.util.ArrayList;
//	https://wonit.tistory.com/203
public class MinHeap {
	private ArrayList<Integer> heap;

	/* ���� ��� :position * 2 , ������ ��� : position * 2 + 1, �θ��� : position / 2 */
	public MinHeap() {
		heap = new ArrayList<>();
		heap.add(0); // index 1���� �����ϱ� ���ؼ�
	}

	public void insert(int data) {
		heap.add(data);
		int position = heap.size() - 1;

		// ��Ʈ ������ �̵��߰ų� �θ� heap�� �ڽ� heap���� Ŭ �� ����
		while (position > 1 && heap.get(position / 2) > heap.get(position)) {
			int temp = heap.get(position / 2);
			heap.set(position / 2, heap.get(position));
			heap.set(position, temp);

			position /= 2;
		}
	}

	// ��Ʈ��� ���� �� ������ ��带 ��Ʈ���� �����ؼ� sort 
	public int delete() {
		
		if (heap.size() - 1 < 1) {
			return -1;
		}
		int deleteData = heap.get(1); // ��Ʈ ��� ����
		
		heap.set(1, heap.get(heap.size()-1)); // ��Ʈ ����� �ڸ��� ������ ��带 ����
		heap.remove(heap.size()-1); // ������ ��� ����
		
		int position = 1;
		while ((position * 2) < heap.size()) {
			int min = heap.get(position*2);
			int minPos = position * 2;
			
			if (((position * 2 + 1 ) < heap.size()) && min > heap.get(position * 2 + 1)) {
				min = heap.get(position * 2 + 1);
				minPos = position * 2 + 1;
			}
			
			if (heap.get(position) < min) break; 
			
			int temp = heap.get(position);
			heap.set(position, heap.get(minPos));
			heap.set(minPos, temp);
			position = minPos;
		}
		return deleteData;
	}
	
	public String toString() {
		return heap.toString();
	}

}
