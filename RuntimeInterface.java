/*
 * Name: Joel Quainoo
 * CMP 338 
 * HomeWork One
 */
/**
 * 
 * This interface will be used to organize and manage runtimes that are measured for specific operations.
 * 
 * The user will utilze <code>System.nanoTime()</code> to measure the runtime of an operation.
 * 
 * <p>Before the operation is started, you can obtain the start time:
 * <br>
 * <code>startTime = System.nanoTime()</code>.</p>
 * 
 * <p>After the operation is completed, you can obtain the end time:
 * <br>
 * <code>endTime = System.nanoTime()</code>.</p>
 * 
 * <p>Run Time is then:
 * <br>
 * <code>runTime = endTime - startTime</code>. </p>
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface RuntimeInterface {
	
	/**
	 * 
	 * This method is used to retrieve the last runtime. If no runtime
	 * has been added, the method will return a zero.
	 * 
	 * @return The last runtime, in nanoseconds, or zero.
	 *  
	 */
	public long getLastRunTime();
	
	/**
	 * 
	 * This method returns an array of <b>long</b> values representing the last 10 runtimes. 
	 * If less than 10 runtimes are available, the remaining
	 * runtimes should be zero. If more than 10 runtimes have been added, the array
	 * should contain the last 10 runtimes. 
	 * 
	 * @return An array of <b>long</b> values representing the last 10 runtimes.
	 * 
	 */
	public long[] getRunTimes();
	

	/**
	 * 
	 * This method is used to reset all 10 linear search times to zero.
	 * 
	 */
	public void resetRunTimes();

	/**
	 * 
	 * This method is used to add a runtime.
	 * 
	 * @param runTime a <b>long</b> value representing the runtime in nanoseconds.
	 * 
	 */
	public void addRuntime(long runTime);
	
	/**
	 * 
	 * This method is used to obtain the average runtime. The method should average all
	 * the non-zero runtimes that are available. If no runtimes are available, the method
	 * returns a zero.
	 * 
	 * @return A <b>double</b> value representing the average of all the non-zero runtimes, or zero.
	 * 
	 */
	public double getAverageRunTime();
	
}