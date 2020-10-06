package stack.arraystack.impl;

public class ArrayStack {

	private int top;
	private int initSize;
	private Object[] stackArr;
	
	public ArrayStack(int initSize) {
		this.top = -1;
		this.initSize = initSize;
		this.stackArr = new Object[initSize];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == this.initSize - 1);
	}

	public void push(Object item) {
		if (isFull()) {
			System.out.println("ArrayStack is full");
		} else {
			stackArr[++top] = item;
		}
	}

	public Object pop() {
		if (top == -1) {
			return -1;
		} else {
			Object returnData = stackArr[top--];
			
			return returnData;
		}
	}

	public Object peek() {
		if (top == -1) {
			return -1;
		} else {
			return stackArr[top];
		}
	}

	public void clear() {
		if (isEmpty()) {
			System.out.println("ArrayStack is empty");
		} else {
			stackArr = new Object[this.initSize];
		}
	}
	
	public int size() {
		return (this.top + 1);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < size(); i++) {
			if (i == size() - 1) {
				sb.append(stackArr[i] + "]");
			} else {
				sb.append(stackArr[i] + ",");
			}
		}
		
		return sb.toString();
	}

}
