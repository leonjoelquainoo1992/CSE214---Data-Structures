
public class LinkedListNode<E> {
	E data;
	LinkedListNode<E> next;
	LinkedListNode<E> prev;

	public LinkedListNode(E data){
		this.data = data;
	}

	public LinkedListNode(E data, LinkedListNode<E> next){
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public LinkedListNode<E> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<E> next) {
		this.next = next;
	}
}
