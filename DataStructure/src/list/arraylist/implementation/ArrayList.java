package list.arraylist.implementation;

public class ArrayList {
	private int size = 0; // ArrayList 내부에 몇개의 데이터가 채워져 있는가
	private Object[] elementData = new Object[100];

	public ArrayList() {
	}

	public boolean addFirst(Object element) {
		return add(0, element);
	}

	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}

	// 내가 구현한 add
	public boolean add(int index, Object element) {

		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}

		elementData[index] = element;
		size++;
		return true;
	}

	public Object remove(int index) {
		Object removedValue = elementData[index];
		for (int i = index + 1; i < size; i++) {
			elementData[i - 1] = elementData[i];
		}
		elementData[size - 1] = null;
		size--;
		return removedValue;
	}

	public Object removeFirst() {
		return remove(0);
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public Object get(int index) {

		return elementData[index];
	}

	public int size() {
		return size;
	}

	public int indexOf(Object element) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public ListIterator listIterator() {
		return new ListIterator();
	}

	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str += elementData[i];
			if (i < size - 1) {
				str += ",";
			}
		}
		return str + "]";
	}

	/*
	 * public String toString() { StringBuffer sb = new StringBuffer(); for (int i =
	 * 0; i < size; i++) { sb.append(elementData[i] + " "); } return sb.toString();
	 * }
	 */

	class ListIterator {

		private int nextIndex;
		
		public ListIterator() {
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public Object next() {
			return elementData[nextIndex++];
		}
		
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);
		}
		
		public void remove() {
			ArrayList.this.remove(--nextIndex);
		}
	}

}
