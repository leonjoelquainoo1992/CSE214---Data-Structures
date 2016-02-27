/*
 * Name: Joel Quainoo
 * ID: 110688594
 * CSE 214 Assignment One
 */
import java.util.NoSuchElementException;

public class UnilinkedList<E> {
	private Node<E> head;
	private Node<E> cursor = head;
	
	
	//Node Class
	private static class Node<E>{
		private E data; 
		private Node<E> next;
		
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
		
		@SuppressWarnings("unused")
		public E getData(){
			return data;
		}
		
		@SuppressWarnings("unused")
		public void setData(E the_data){
			data = the_data;
		}
		
		@SuppressWarnings("unused")
		public Node<E> getNext(){
			return next;
		}
		
		@SuppressWarnings("unused")
		public void setNext(Node<E> node){
			next = node;
		}
		
		@Override
		public int hashCode() {
			int result = data != null ? data.hashCode() : 0 ;
			return 31 * result + (next != null ? next.hashCode() : 0);
		}

		public boolean hasNext() {
			return this.next != null;
		}
		
	}
	
	//Cursor class - private class with a private constructor
	public static class Cursor<E>{
		private Node<E> position;

		private Cursor(UnilinkedList<E> list){
			//position = list.head;
			
		}
		
		public Node<E> getPosition() {
			return position;
		}

		public void setPosition(Node<E> position) {
			this.position = position;
		}

		public boolean hasNext(){
			return position != null;
		}

		public E next(){
			if(!hasNext())
				throw new NoSuchElementException();
			E pos = position.data;
			position = position.next;
			return pos;	
		}
	}
	
	//resets the cursor to it previous position
	public void resetCursor(){
		cursor = head;
	}
	
	//Method is okay
	public String toString(){
		resetCursor();
		String str = "";
		if (head == null) {
			   return str;
		   }
		   else {
			     str = "" + cursor.data;
			    cursor = cursor.next;
			    while (cursor != null) {
			      str += " - > " + cursor.data.toString();
			      cursor = cursor.next;
			    }
			    return str;  
		   }   
	}
	
	//get data from the unilinked class for Point2D class
	public E getUnilinkedListData(){
		E getData = null; Node<E> list_data = null; 
		if(list_data == null){
			list_data = head;
		}
		if(list_data != null){ 
			getData = list_data.data;
			list_data = list_data.next;
			}
		return getData;
	}

	//Auxiliary Method 
	public boolean hasNext(){
		return (cursor.next != null);
	}
	
	//equals method that check whether two list and its contents are equals 
	/**
	 * 
	 * @param list - boolean(UnilinkedList<E> list)
	 * @return a boolean
	 */
	public boolean equals(UnilinkedList<E> list){
		if (this.size() != list.size())
			 return false;
		resetCursor();
		 for (int i = 0; i < size(); i++) {
			 if (list.indexOf(cursor.data) != this.indexOf(cursor.data))
				 return false;
			 cursor = cursor.next;
		 }
		 return true;
	}
	
	//Checks whether a the list is empty
	/**
	 * isEmpty() checks whether a linked list is empty
	 * @return
	 */
	public boolean isEmpty(){
		return head == null;
	}
	
	//Removes all element in a list by setting head to null
	/**
	 * void clear() 
	 * removes all element in a linked list 
	 */
	public void clear(){
		head = null;
	}
	
	//Return the size of a list 
	/**
	 * public int size() - returns the size of a list
	 * @return int
	 */
	public int size(){
		resetCursor();
		int sizeOfList = 0;
		while(cursor != null){
			cursor = cursor.next;
			sizeOfList++;
		}	
		return sizeOfList;
	}

	//Returns the index of a particular element
	public int indexOf(E element){
		resetCursor();
		int counter = 0;
		int indexOfElement = -1;
		while(cursor.hasNext()){
			if(cursor.data.equals(element))
				indexOfElement = counter;
			else
				counter++;
			cursor = cursor.next;
		}
		return indexOfElement;
	}
	
	// Checks whether a set element is in the list
	public boolean contains(E element){
		if(indexOf(element) == 1)
			return true;
		else
			return false;
	}
	
	//Adds and element to the list 
	public void add(E element){
		resetCursor();
		if(head == null)
			head = new Node<E>(element, null);
		else{
			while(cursor.next != null){
				cursor = cursor.next;
			}
			cursor.next = new Node<E>(element, null);
		}
	}
	
	//Add after a particular element
	public void addAfter(E mark, E elementToAdd){
		resetCursor();
		while(cursor != null && !cursor.data.equals(mark)){
			cursor = cursor.next;
			}
		if(cursor != null){
			cursor.next = new Node<E>(elementToAdd,cursor.next);
		}
		else
			throw new NoSuchElementException("No such element");
	}
	
	public void addFirst(E element){
		head = new Node<E>(element, head);
	}
	
	//Returns the head of the list
	public E head(){
		if(head == null)
			throw new NoSuchElementException("List is empty");
		else
			return head.data;
	}
	
	//Return a boolean and removes all instances of an element from a linked list.
	public boolean remove(E element){
		resetCursor();
		Node<E> previousCursor = null;
	      if(head == null)
	         throw new RuntimeException();

	      if( head.data.equals(element))
	      {
	         head = head.next;
	      }
	      while(cursor != null && !cursor.data.equals(element)){
	    	  previousCursor = cursor.next;
	    	  cursor = cursor.next;
	      }if(cursor == null)
	    	  throw new NullPointerException("Cannot remove");
	      previousCursor.next = cursor.next;
	      return true;
	   }
	
	
	public boolean remove3(E element){
    	int  i = 1;
    	Node<E> cursor = head;
    	if(indexOf(element) ==- 1)
    		return false;
    	if(head.data == element)
    		head = head.next;
    	else{
    		while(i <= indexOf(element)){
             cursor = cursor.next;
    		 i++;
        }
    	  cursor.next = cursor.next.next;
    	}
    	return true;
	}
	
	//Return a boolean and removes all instances of all element from a linked list.
	public boolean removeAll(E element){
		int size = size();
       	if(indexOf(element) ==- 1)
       		return false;
		for(int i = 0; i < size; i++){
			remove3(element);
		}
		System.out.println(size);
       	return true;
    }
	
	//Removes duplicate from the list.
	public void deduplicate(){
		resetCursor();
    		for(int i = 0; i < size(); i++){
    	    	Node<E> Cursor = head;
    	        Node<E> slider = head;
    	    	while(slider != null){
    	    		Cursor = slider;
    	            while(Cursor != null && Cursor.next != null){
    	            	if(slider.data.equals(Cursor.next.data))
    	            	 Cursor.next = Cursor.next.next;
    	            	Cursor = Cursor.next;
    	            }
    	            slider = slider.next;
    	    	} 
    		}
	}

}
