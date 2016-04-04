/** @author leonjoel
 *Stack<E> abstract data type class.
 *data variables: private Node<E> top, private int stackSize = 0;
 *No-arg constructor
 *Methods:
 *
	 * isEmpty 
	 * Post Condition: returns true or false based on if the stack is empty
	 * @return boolean
	 
	 * E peek()
	 * Pre-Condition: Stack is not empty
	 * Post Condition: returns an element on top of the stack
	 * @return E <ADT> Abstract Data Type
	 
	 * E pop()
	 * Pre-Condition: Stack is not empty else throws EmptyStackException.
	 * Post Condition: removes an element from top of the stack
	 * @return E <ADT> Abstract Data Type
	 
	 * void push(E element)
	 * Pre-Condition: Stack is not full if arrays are being used. if list or LinkedList are being used then stack can never be full.
	 * 				 Takes in a single argument <the item of element being pushed to the stack>
	 * Post Condition: pushes an element to the top of the stack
	 * @return (void)

	 * int size()
	 * Pre-Condition: Stack is not empty else return 0
	 * Post Condition: returns an int - the size of the stack
	 * @returns an int
	 
	 * Nested static Node<E> private class
	 * Data variable -private Node<E> head, private Node<E> next, private E data;
	 * with a public constructor - public Node(E data, Node<E> next)
	 * Methods: 
	 * getters and setters methods for the data fields.
	 * @param <E>
 *
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class GenericStack<E> {
	private Object[] data;
	private int top;
	private final int INITIAL_CAPACITY;

	
	public GenericStack(){
		INITIAL_CAPACITY = 200;
		data = ((E[]) new Object[INITIAL_CAPACITY]);
		top = 0;
	}

	public Object[] getData() {
		return data;
	}

	public int getTop() {
		return top;
	}
	
	public void setData(E[] data) {
		this.data = data;
	}

	public void setTop(int top) {
		this.top = top;
	}
		
	public boolean isEmpty(){
		return (top == 0);
	}
	
	public boolean isFull(){
		return top == data.length;
	}
	
	public void push(E element){
			data[++top] = element;
	}
	 
	public E pop(){
		E popElement;
		if(isEmpty())
			throw new java.util.EmptyStackException();
		popElement = (E) data[top];
		top--;
		return popElement;
	}
	 
	public E peek(){
		E peekElement;
		if(isEmpty())
			throw new java.util.EmptyStackException();
		else
			peekElement = (E) data[top];
		return peekElement;
	}
	
	public int size(){
		return top;	
	}
	
	@SuppressWarnings("unused")
	private static class Node<E>{
		private Node<E> head;
		private Node<E> next;
		private E data;
		
		
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}

		public Node<E> getHead() {
			return head;
		}

		public Node<E> getNext() {
			return next;
		}

		public E getData() {
			return data;
		}

		public void setHead(Node<E> head) {
			this.head = head;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public void setData(E data) {
			this.data = data;
		}
	}
}
