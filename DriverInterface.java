/*
 * Name: Joel Quainoo
 * CMP 338 
 * HomeWork One
 */
/**
 * 
 * These are the methods that you will use to exercise your <code>LinearSearch.java</code>
 * and <code>BinarySearch</code> classes.
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface DriverInterface {
		
	/**
	 * 
	 * This method will generate and return a sorted array of <code>int</code> values
	 * starting at <b>1</b> and ending at <b>10,000,000</b>. 
	 * 
	 * @return An <code>int</code> array containing the numbers from <b>1</b> to <b>10,000,000</b>.
	 * 
	 */
	public int[] getListOfNumbers();
	
	/**
	 * 
	 * This method will return an <code>int</code> array containing the following values:
	 * 
	 * <ol>
	 * <li>500</li>
	 * <li>10,000</li>
	 * <li>100,000</li>
	 * <li>1,000,000</li>
	 * <li>5,000,000</li>
	 * <li>7,500,000</li>
	 * <li>10,000,000</li>
	 * </ol>
	 * 
	 * @return An <code>int</code> array containing the values specified above.
	 */
	public int[] getTargets();
	
	/**
	 * 
	 * This method should create an instance of the <code>LinearSearch.java</code> class and
	 * run the search for the specified <code>target</code> in the <code>listOfNumbers</code>
	 * a total of <code>numberOfTimes</code>.
	 * 
	 * @param listOfNumbers	An <code>int</code> array containing the numbers to search through.
	 * @param target The number we will search for.
	 * @param numberOfTimes The number of times to conduct the search.
	 * 
	 * @return The method must return the <code>RunTime</code> class that was used to save the 
	 * measured runtimes for the linear searches performed.
	 *  
	 */
	public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes);
	
	/**
	 * 
	 * This method should create an instance of the <code>BinarySearch.java</code> class and
	 * run the search for the specified <code>target</code> in the <code>listOfNumbers</code>
	 * a total of <code>numberOfTimes</code>.
	 * 
	 * @param listOfNumbers	An <code>int</code> array containing the numbers to search through.
	 * @param target The number we will search for.
	 * @param numberOfTimes The number of times to conduct the search.
	 * 
	 * @return The method must return the <code>RunTime</code> class that was used to save the 
	 * measured runtimes for the binary searches performed.
	 *  
	 */
	public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes);
}
