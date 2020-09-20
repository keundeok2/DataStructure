package list.linkedlist.implementation;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size;

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode; 
			size++;
		}
	}
	
	Node node(int index) {
		Node x = head;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
			
		return x;
	}
	
	public void add(int k, Object input) {
		if (k == 0 ) {
			addFirst(input);
		} else {
			Node newNode = new Node(input);
			Node x = node(k-1);
			newNode.next = x.next;
			x.next = newNode;
			size++;
			if (newNode.next == null) {
				tail = newNode;
			}
		}
		
	}
	
	public Object removeFirst() {
		Node temp = head;
		head = temp.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	public Object remove(int idx) {
		Node temp = node(idx-1);
		Node toBeDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = toBeDeleted.data;
		if (toBeDeleted == tail) {
			tail = temp;
		}
		size--;
		return toBeDeleted.data;
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int idx) {
		return node(idx).data;
	}
	
	public int indexOf(Object data) {
		Node temp = head;
		int idx = 0;
		
		while (temp.data != data) {
			temp = temp.next;
			idx++;
			if (temp == null) {
				return -1;
			}
		}
		return idx;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	public class ListIterator{
		private Node next;
		private Node lastNode;
		private int nextIndex;
		
		public ListIterator() {
			this.next = head;
		}
		
		public Object next() {
			lastNode = next;
			next = next.next;
			nextIndex++;
			return lastNode.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public void add(Object data) {
			Node newNode = new Node(data);
			if (lastNode == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastNode.next = newNode;
				newNode.next = next;
			}
			lastNode = newNode;
			nextIndex++;
			size++;
		}
		
		public void remove() {
			if (nextIndex == 0) {
				throw new IllegalStateException();
			} else {
				LinkedList.this.remove(nextIndex-1);
				nextIndex--;
			}
		}
	}
	
	
	
	public String toString() {
		String str = "[";
		Node temp = head;
		while(temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		str += temp.data;
		return str + "]";
	}
	

	private class Node {
		private Object data;
		private Node next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}
}
