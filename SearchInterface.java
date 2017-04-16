/**
 * 
 * This is a generalized search interface. You will write two classes that implement
 * this interface:
 * 
 * <ol>
 * <li>LinearSearch</li>
 * <li>BinarySearch</li>
 * </ol>
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface SearchInterface {
		
	/**
	 * 
	 * This method is used for searching for a <b>target</b> value in an array 
	 * representing a <b>listOfNumbers</b>.
	 * 
	 * @param listOfNumbers	An array of <b>int</b> values.
	 * 
	 * @param target An <b>int</b> value representing the target we are searching for.
	 * 
	 * @return If the <b>target</b> value is found, the method will return the index of the 
	 * <b>target</b> value in the <b>listOfNumbers</b>. Otherwise, the method will return
	 * <b>-1</b>.
	 * 
	 */
	public int search(int[] listOfNumbers, int target);
 
}
