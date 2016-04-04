/* Name: Joel Quainoo
 * CSE_214 Homework 2;
 */
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
 * @param <E>
 */
public class Stacks<E> {
	private Node<E> top;
	private int stackSize = 0; //size of the stack
	
	public Stacks(){
		top = null;
	}
	
	public boolean isEmpty(){
		return (top == null);
	}
	
	public E peek(){
		if(isEmpty())
			throw new java.util.EmptyStackException();
		return top.getData();
	}
	
	public E pop(){
		E popElement;
		if(isEmpty())
			throw new java.util.EmptyStackException();
		popElement = top.getData();
		top  = top.next;
		stackSize--;
		return popElement;
	}
	
	public void push(E element){
		top = new Node<E>(element, top);
		stackSize++;
	}
	
	public int size(){
		return stackSize;
	}

	@SuppressWarnings("unused")
	private static class Node<E>{
		private Node<E> head;
		private Node<E> next;
		private E data;
		
		public Node(E data, Node<E> next){
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
