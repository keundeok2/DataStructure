package stack.arraystack.impl;

public class Main {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(10);
		System.out.println(arrayStack.isEmpty());
		System.out.println(arrayStack.isFull());
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		System.out.println(arrayStack.size());
		System.out.println(arrayStack.toString());
		
	}
}
