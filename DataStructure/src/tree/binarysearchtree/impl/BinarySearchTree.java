package tree.binarysearchtree.impl;

// https://velog.io/@hanrimjo/%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-%ED%8A%B8%EB%A6%AC-Binary-Search-Tree-8gk6ablvfx
public class BinarySearchTree {

	private Node root;
	private int count;
	
	public Node getRoot() {
		return root;
	}
	
	// 노드 검색
	public Node searchNode(int input) {
		if (root == null) {
			return null;
		}
		
		Node moveNode = root;
		while (moveNode.data != input) {
			if (input < moveNode.data) {
				moveNode = moveNode.left;
			} else {
				moveNode = moveNode.right;
			}
			
			if (moveNode == null) {
				return null;
			}
		}
		return moveNode;
	}
	
	public void addChild(int input) {
		
		if (searchNode(input) != null) {
			System.out.println(input +  " : already exist");
			return;
		}
		
		Node node = new Node(input);
		if (root == null) {
			root = node;
		} else {
			Node moveNode = root;
			Node pointer = null;
			while (true) {
				pointer = moveNode;
				
				if (input < pointer.data) {
					moveNode = pointer.left;
					if (moveNode == null) {
						pointer.left = node;
						return;
					}
				} else {
					moveNode = pointer.right;
					
					if (moveNode == null) {
						pointer.right = node;
						return;
					}
				}
			}
		}
	}
	
	
	public void deleteNode(int input) {
		Node moveNode = root;
		Node pointer = root;
		Node replaceNode = null;
		
		boolean leftFlag = true;
		
		// 삭제될 노드로 이동
		while (moveNode.data != input) {
			
		}
		
		
		
		
	}
	
	static class Node {
		public int data;
		private Node left;
		private Node right;
		
		public Node() {
		}
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
	}
}
