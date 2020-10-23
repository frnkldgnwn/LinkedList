public class DLLNode<E> {
	E data;
	DLLNode<E> next;
	DLLNode<E> prev;
	
	public DLLNode(E data) {
		this.data = data;
		this.next = null;
	}
}
