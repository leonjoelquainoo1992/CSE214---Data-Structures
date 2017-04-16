/**
 * 
 * This interface will be used by various classes to sort an array <code>Integer</code> objects.
 * You will write three classes that implement this interface:
 * 
 * <ol>
 * <li>BubbleSort</li>
 * <li>InsertionSort</li>
 * <li>SelectionSort</li>
 * </ol>
 * 
 * @author Sameh A. Fakhouri
 *
 */

public interface SortInterface {

	/**
	 * 
	 * This method is called to sort the given array of <code>Integer</code> objects. At the
	 * completion of this method, the array will be sorted.
	 * 
	 * @param arrayToSort This is the array that contains all the <code>Integer</code> objects
	 * that need to be sorted.
	 */
	public void sort(Integer[] arrayToSort);
	
}
