package heap.minheap.impl;

import java.util.ArrayList;
//	https://wonit.tistory.com/203
public class MinHeap {
	private ArrayList<Integer> heap;

	/* 왼쪽 노드 :position * 2 , 오른쪽 노드 : position * 2 + 1, 부모노드 : position / 2 */
	public MinHeap() {
		heap = new ArrayList<>();
		heap.add(0); // index 1부터 시작하기 위해서
	}

	public void insert(int data) {
		heap.add(data);
		int position = heap.size() - 1;

		// 루트 노드까지 이동했거나 부모 heap이 자식 heap보다 클 때 까지
		while (position > 1 && heap.get(position / 2) > heap.get(position)) {
			int temp = heap.get(position / 2);
			heap.set(position / 2, heap.get(position));
			heap.set(position, temp);

			position /= 2;
		}
	}

	// 루트노드 삭제 후 최하위 노드를 루트노드로 설정해서 sort 
	public int delete() {
		
		if (heap.size() - 1 < 1) {
			return -1;
		}
		int deleteData = heap.get(1); // 루트 노드 삭제
		
		heap.set(1, heap.get(heap.size()-1)); // 루트 노드의 자리에 최하위 노드를 지정
		heap.remove(heap.size()-1); // 최하위 노드 삭제
		
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
