package stack.likedliststack.impl;

import java.util.EmptyStackException;

public class LinkedListStack{
	private Node top;
	
	class Node{
		public Object data;
		public Node next;
		
		public Node(Object data) {
			this.data = data;
		}
	}
	
	public void push(Object data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	public Object pop() {
		if (top == null) {
			throw new EmptyStackException();
		} else {
			Object returnData = top.data;
			top = top.next;
			return returnData;
		}
	}
	
	public Object peek() {
		if (top == null) {
			throw new EmptyStackException();
		} else {
			return top.data;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
			String str = "[";
			Node temp = top;
			while(temp.next != null) {
				str += temp.data + ",";
				temp = temp.next;
			}
			str += temp.data;
			return str + "]";
	}
}
