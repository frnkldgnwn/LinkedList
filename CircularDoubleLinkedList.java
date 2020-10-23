public class CircularDoubleLinkedList<E> {
	DLLNode<E> head;
	DLLNode<E> tail;
	int size = 0;

	public CircularDoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addFirst(E data) {
		DLLNode<E> newNode = new DLLNode<E>(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			newNode.prev = tail;
			tail.next = newNode;
			head = newNode;
		}
		size++;
	}

	public void addLast(E data) {
		DLLNode<E> newNode = new DLLNode<E>(data);
		if (isEmpty()) {
			addFirst(data);
		} else {
			newNode.next = head;
			tail.next = newNode;
			newNode.prev = tail;
			head.prev = newNode;
			tail = newNode;
		}
		size++;
	}

	public void add(E data) {
		addLast(data);
	}

	public void add(int index, E data) {
		DLLNode<E> newNode = new DLLNode<E>(data);
		DLLNode<E> temp = head;
		if (index == 0) {
			addFirst(data);
		} else if (index == size - 1) {
			addLast(data);
		} else {
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
		}
	}

	public DLLNode<E> removeFirst() {
		if (!isEmpty()) {
			DLLNode<E> removed = head;
			head = head.next;
			head.prev = tail;
			tail.next = head;
			removed.next = null;
			removed.prev = null;
			size--;
			return removed;
		}
		return null;
	}

	public DLLNode<E> removeLast() {
		if (!isEmpty()) {
			DLLNode<E> temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			DLLNode<E> removed = temp.next;
			tail = temp;
			tail.next = head;
			head.prev = tail;
			removed.prev = null;
			removed.next = null;
			size--;
			return removed;
		}
		return null;
	}

	public DLLNode<E> remove() {
		return removeFirst();
	}

	public DLLNode<E> remove(int index) {
		if (!isEmpty()) {
			DLLNode<E> removed = null;
			if (index == 0) {
				removed = removeFirst();
			} else if (index == size - 1) {
				removed = removeLast();
			} else {
				DLLNode<E> temp = head;
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				removed = temp.next;
				temp.next = temp.next.next;
				temp.next.next.prev = temp;
				removed.next = null;
				removed.prev = null;
			}
			size--;
			return removed;
		}
		return null;
	}

	public String toString() {
		String returnStr = "{";
		DLLNode<E> temp = head;
		while (temp != null) {
			returnStr += temp.data + " ";
			temp = temp.next;
		}
		returnStr += "}";
		return returnStr;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
