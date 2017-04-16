

public interface ListInterface<I> {
	
	

	/**
	 * This method is called to obtain the count of elements in the list.
	 * 
	 * @return 	Returns the numbers of <b>Object</b>s that are currently in the list.
	 */
	
	public int size();

	
	
	/**
	 * This method is called to determine if the list is empty.
	 * 
	 * @return 	Returns <b>true</b> if the list is empty, otherwise it returns <b>false</b>. 
	 */
	
	public boolean isEmpty();

	
	
	/**
	 * This method is called to add the specified object to the end of the list.
	 * 
	 * @param 	obj		A reference to the object to be added to the end of the list.
	 * 					All objects being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @see		java.lang.Comparable
	 */
	public void add(I obj);
	
	
	
	/**
	 * This method is called to add the specified object to the list at the given index.
	 * 
	 * @param 	obj		A reference to the object to be added to the list. 
	 * 					All objects being added to the list must implement the 
	 * 					<b>Comparable</b> interface.
	 * 
	 * @param 	index 	Indicates the position at which to add the specified object.
	 * 					Using and index = 0, indicates that the object being added should
	 * 					become the <b>head</b> of the list and should succeed even if
	 * 					the list is currently empty.
	 * 
	 * @return 	Returns <b>true</b> if the object was successfully added at the given index.
	 * 			If the given index is invalid, this method returns <b>false</b>, indicating
	 * 			that the specified object was not added to the list.
	 * 
	 * @see		java.lang.Comparable
	 */
	public boolean add(I obj, int index);
	
	

	/**
	 * This method is called to add the specified object to the list in sorted order. More
	 * specifically, the objects preceding the specified object must be "less than" the
	 * specified object, and the objects following the specified object must be "greater
	 * that or equal to" the specified object.
	 * 
	 * @param 	obj 	A reference to the <b>obj</b> being added, in sorted order, 
	 * 					to the list. All objects being added to the list must implement the 
	 * 					<b>Comparable</b> interface.

	 * @return 	Returns <b>true</b> if the object was successfully added at the given index.
	 * 			If the given index is invalid, this method returns <b>false</b>, indicating
	 * 			that the specified object was not added to the list.
	 * 
	 * @see		java.lang.Comparable
	 */
	public boolean addSorted(I obj);
	
	
	
	/**
	 * This method is called to retrieve the object at the specified index.
	 * 
	 * @param 	index	Indicates the position from which to retrieve the object.
	 * 
	 * @return	Returns a reference to the <b>Object</b> at the given index, or <b>nullL</b>
	 * 			if the given index is invalid.
	 */
	public I get(int index);
		
	
	
	/**
	 * 
	 * This method is called to replace the element at the specified <b>index</b> with the specified
	 * <b>obj</b>. The method then returns the replaced element or <b>null</b> if no element exists
	 * at the specified <b>index</b>.
	 * 
	 * @param obj	A reference to the <b>obj</b> that will replace the current element in the list.
	 * 
	 * @param index Indicates the position in the list where the replacement should be made.
	 * 
	 * @return		If the replacement is successful, the method will return a reference to the replaced
	 * 				element. Otherwise, the method will return <b>null</b>.
	 */
	public I replace(I obj, int index);

	
	
	/**
	 * This method is called to remove the object at the specified index
	 * 
	 * @param 	index	Indicates the position from which to remove the object.
	 * 
	 * @return	Returns <b>true</b> if the object was successfully removed from the given index, 
	 * 			or <b>false</b> if the given index is invalid.
	 */
	public boolean remove(int index);

	
	
	/**
	 * This method removes all objects from the list, making the list empty.
	 */
	public void removeAll();
	
}
