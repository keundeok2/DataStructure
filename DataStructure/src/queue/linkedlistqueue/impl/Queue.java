package queue.linkedlistqueue.impl;

import java.util.NoSuchElementException;

/*
 * 데이터는 한 방향으로만 삽입되고 한 방향으로만 나온다.
 */
public class Queue<T> {
	
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item) {
		Node<T> node = new Node<>(item);
		if (last != null) {
			last.next = node;
		} 
		last = node;
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if (first == null) {
			last = null;
		}
		
		return data;
	}
	
	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	public String toString() {
		String str = "[";
		Node<T> temp = first;
		while(temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
}
	
	
	static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
}
