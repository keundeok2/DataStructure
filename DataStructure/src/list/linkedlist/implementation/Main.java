package list.linkedlist.implementation;

public class Main {
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		System.out.println(numbers.toString());
		System.out.println(numbers.remove(0));
		System.out.println(numbers.toString());
		System.out.println(numbers.removeLast());
		System.out.println(numbers.toString());
		System.out.println(numbers.get(0));
		System.out.println(numbers.indexOf(30));
	}
}
