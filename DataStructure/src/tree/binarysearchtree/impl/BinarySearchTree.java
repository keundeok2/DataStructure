package tree.binarysearchtree.impl;

// https://wonit.tistory.com/199?category=758730
public class BinarySearchTree {

	public Node root;

	public BinarySearchTree() {
		root = null;
	}

	class Node {
		public Node root;
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public boolean find(int key) {
			Node currentNode = root;

			while (currentNode != null) {
				if (currentNode.data == key) {
					return true;
				} else if (currentNode.data > key) {
					currentNode = currentNode.left;
				} else {
					currentNode = currentNode.right;
				}
			}

			return false;
		}

		public void insert(int data) {
			Node newNode = new Node(data);

			if (root == null) {
				root = newNode;
				return;
			}

			Node currentNode = root;
			Node parentNode = null;

			while (true) {
				parentNode = currentNode;

				if (currentNode.data > data) {
					currentNode = parentNode.left;
					if (currentNode == null) {
						parentNode.left = newNode;
						return;
					}
				} else {
					currentNode = parentNode.right;
					if (currentNode == null) {
						parentNode.right = newNode;
						return;
					}
				}
			}
		}

		public void delete(int data) {
			
			Node parentNode = root;
			Node currentNode = root;
			boolean isLeftChild = false;
			
			//	삭제할 노드 찾아가기
			while (currentNode.data != data) {
				parentNode = currentNode;
				if (currentNode.data > data) {
					isLeftChild = true;
					currentNode = currentNode.left;
				} else {
					isLeftChild = false;
					currentNode = currentNode.right;
				}
				
				if ( currentNode == null) { 
					return;
				}
			}
			
			//	case1) 삭제될 노드의 자식노드가 없는 경우
			if (currentNode.left == null && currentNode.right == null) {
				
				if (currentNode == root) {
					root = null;
				}
				if (isLeftChild) {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
			
			//	case2-1)삭제될 노드의 자식 노드가 하나 존재 (왼쪽)
			} else if (currentNode.right == null) {
				parentNode.left = currentNode.left;
			//	case2-1)삭제될 노드의 자식 노드가 하나 존재 (오른쪽)				
			} else if (currentNode.left == null) {
				parentNode.right = currentNode.right;
			//	case3)삭제될 노드의 자식 노드가 둘일 경우
			} else {
				Node minimum = getMinimum(currentNode);
                if(currentNode == root) {
                    root = minimum;
                }else if (isLeftChild){
                    parentNode.left = minimum;
                }else {
                    parentNode.left = currentNode.left;
                }
                minimum.left = currentNode.left;
			}

		}
		
		private Node getMinimum(Node deleteNode) {
			Node minimum = null;
			Node minimumParent = null;
			Node currentNode = deleteNode.right;
			
			while (currentNode != null) {
				minimumParent = minimum;
				minimum = minimumParent;
				currentNode = currentNode.left;
			}
			
			if(minimum != deleteNode.right){
	            minimumParent.left = minimum.right;
	            minimum.right = deleteNode.right;
	        }
	        return minimum;
		}

	}
}
