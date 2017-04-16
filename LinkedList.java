
public class LinkedList<E> implements ListInterface<E>, Comparable<E>{
	private LinkedListNode<E> head;
	private LinkedListNode<E> cursor;
	int size;

	public LinkedList(){
		setSize(0);
		cursor = head;
	}

	public  int getSize() {
		return size;
	}

	public  void setSize(int size) {
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void add(E obj) {
		if(isEmpty()){
			head = new LinkedListNode<E>(obj, null);
			size++;
		}
		else{
			cursor = head;
			while(cursor.next != null){
				cursor = cursor.next;
			}
			cursor.next = (new LinkedListNode<E>(obj, cursor.next));
			size++;
		}
	}

	@Override
	public boolean add(E obj, int index) {
		if(index >=  0 && index < size + 1){
			if(index == 0){
				head = new LinkedListNode<E>(obj, head);
				size++;
				return true;
			}
			else{
				LinkedListNode<E> prev = findIndex(index - 1);
				prev.next = new LinkedListNode<E>(obj, prev.next);
				size++;
				return true;
			}
		}
		else{
			System.out.println("Cannot "+ obj + " at index " + index);
			return false;
		}
	}

	@Override
	public boolean addSorted(E obj) {
		LinkedListNode<E> element = new LinkedListNode<E>(obj, null);
		if(isEmpty()){
			head = element;
			size++;
			return true;
		}
		else{
			for(cursor = head; cursor != null; cursor = cursor.next){
				if((Integer) cursor.data < (Integer)element.data){
					cursor.next = element;
				}
				else{
					cursor = cursor.next;
				}
			}

		}
		return false;
	}

	@Override
	public E get(int index) {
		E element = null;
		if (index >= size())
			throw new IndexOutOfBoundsException();
		else{
			LinkedListNode<E> currentNode = head;
			for(int i = 0; i < index; i++){
				currentNode = currentNode.next;
			}
			element = currentNode.data;
		}
		return element;
	}


	@Override
	public E replace(E obj, int index) {
		E element = null;
		if (index >= size() || index < 0)
			throw new IndexOutOfBoundsException();
		else{
			if(index == 0){
				element = head.data;
				head.setData(new LinkedListNode<E>(obj, head).data);
			}
			else{
				LinkedListNode<E> currentNode = head;
				for(int i = 0; i < index; i++){
					currentNode = currentNode.next;
					element = currentNode.data;
				}
				currentNode.setData(new LinkedListNode<E>(obj, currentNode).data);
			}
		}
		return element;
	}

	@Override
	public boolean remove(int index) {
		if(index > size || index < 0){
			return false;
		}
		else{
			if(index == 0){
				head = head.next;
				return true;
			}
			else{
				LinkedListNode<E> currentNode = head;
				for(int i = 0; i < index - 1; i++){
					currentNode = currentNode.next;
				}
				if(currentNode.next == null){
					return false;
				}
				else{
					currentNode.next = currentNode.next.next;
					return true;
				}
			}
		}
	}

	@Override
	public void removeAll() {
		head = null;
		size = 0;
	}

	@Override
	public int compareTo(E obj) {
		return -1;
	}


	void displayList(){
		if(size == 0){
			System.out.println("List is empty");
		}
		else{
			System.out.print(head.data);
			cursor = head.next;
			for( ; cursor != null; cursor = cursor.next){
				System.out.print("--->" + cursor.data);
			}
			System.out.println();
		}
	}

	private final LinkedListNode<E> findIndex(int index){
		cursor = head;
		for(int i = 0; i < index; i++){
			cursor = cursor.next;
		}
		return cursor;
	}
}
