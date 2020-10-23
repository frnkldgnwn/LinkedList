public class SingleLinkedList<E> {
	SLLNode<E> head;
	SLLNode<E> tail;
	int size = 0;

	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addFirst(E data) {
		SLLNode<E> newNode = new SLLNode<E>(data);
		if (isEmpty()) {
			head = newNode;
			tail = null;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	public void addLast(E data) {
		SLLNode<E> newNode = new SLLNode<E>(data);
		SLLNode<E> temp = head;

		if (isEmpty()) {
			addFirst(data);
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void add(E data) {
		addLast(data);
	}

	public void add(int index, E data) {
		SLLNode<E> newNode = new SLLNode<E>(data);
		SLLNode<E> temp = head;
		if (index == 0) {
			addFirst(data);
		} else if (index == size - 1) {
			addLast(data);
		} else {
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	public SLLNode<E> removeFirst() {
		if (!isEmpty()) {
			SLLNode<E> removed = head;
			head = head.next;
			size--;
			return removed;
		}
		return null;
	}

	public SLLNode<E> removeLast() {
		if (!isEmpty()) {
			SLLNode<E> temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			SLLNode<E> removed = temp.next;
			tail = temp;
			tail.next = null;
			size--;
			return removed;
		}
		return null;
	}

	public SLLNode<E> remove() {
		return removeFirst();
	}

	public SLLNode<E> remove(int index) {
		if (!isEmpty()) {
			SLLNode<E> removed = null;
			if (index == 0) {
				removed = removeFirst();
			} else if (index == size - 1) {
				removed = removeLast();
			} else {
				SLLNode<E> temp = head;
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				removed = temp.next;
				temp.next = temp.next.next;
			}
			size--;
			return removed;
		}
		return null;
	}

	public String toString() {
		String returnStr = "{";
		SLLNode<E> temp = head;
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
