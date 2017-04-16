import java.util.Arrays;

public class Driver implements DriverInterface {
	static RunTime RunTimes = new RunTime();
	static Driver Driver = new Driver();
	static RunTime linearSearchRunTime = new RunTime();
	static RunTime binarySearchRunTime = new RunTime();

	@Override
	public int[] getListOfNumbers() {
		int[] listOfNumbers = new int[10000000];
		for (int i = 0; i < listOfNumbers.length; i++) {
			listOfNumbers[i] = (i + 1);
		}
		return listOfNumbers;
	}

	@Override
	public int[] getTargets() {
		int[] targetArray = { 500, 10000, 100000, 1000000, 5000000, 7500000, 10000000 };
		return targetArray;
	}

	@Override
	public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		LinearSearch linSearch = new LinearSearch();
		for(int x = 0; x < numberOfTimes; x++){
			for (int i = 0; i < getTargets().length; i++) {
				linSearch.search(listOfNumbers, getTargets()[i]);
			}
		}
		return linearSearchRunTime;
	}

	@Override
	public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		BinarySearch binSearch = new BinarySearch();
		for(int x = 0; x < getTargets().length; x++){
			for (int i = 0; i < numberOfTimes; i++) {
				binSearch.search(listOfNumbers, getTargets()[x]);
			}
		}
		return binarySearchRunTime;
	}

	public static void main(String[] args) {

		// Testing LinearSearch Class
		System.out.println("RUNNING: LinearSearch Class...");
		int numberOfTimes = 1;
		for (int i = 0; i < Driver.getTargets().length; i++) {
			Driver.runLinearSearch(Driver.getListOfNumbers(), Driver.getTargets()[i], numberOfTimes);
		}

		System.out.print("RunTimes after Running Linear Search: ");

		System.out.println(Arrays.toString(RunTimes.getRunTimes()));

		System.out.println("Last Run Time: " + RunTimes.getLastRunTime());

		System.out.println("Computing Average Run Times:...");

		if (Double.isNaN(RunTimes.getAverageRunTime())) {
			throw new ArithmeticException("Division by 0");
		} else {
			System.out.format("Average = %.2f%n", RunTimes.getAverageRunTime());
		}

		RunTimes.resetRunTimes();
		System.out.print("RunTime for Linear Search After Reset: \nAfterReset: ");
		System.out.print(Arrays.toString(RunTimes.getRunTimes()));

		System.out.println("\n");

		// Testing BinarySearch Class
		System.out.println("RUNNING: BinarySearch Class...");
		
		for (int i = 0; i < Driver.getTargets().length; i++) {
			Driver.runBinarySearch(Driver.getListOfNumbers(), Driver.getTargets()[i], numberOfTimes);
		}

		System.out.print("RunTimes for Binary Search: ... ");

		System.out.println(Arrays.toString(RunTimes.getRunTimes()));

		System.out.println("Last Run Time: " + RunTimes.getLastRunTime());

		System.out.println("Computing Average Run Times:...");

		if (Double.isNaN(RunTimes.getAverageRunTime())) {
			throw new ArithmeticException("Division by 0");
		} else {
			System.out.format("Average = %.2f%n", RunTimes.getAverageRunTime());
		}

		RunTimes.resetRunTimes();
		System.out.println("Resetting all run times... ");
		
		System.out.print("RunTime for Binary Search After Reset: ...");
		System.out.println(Arrays.toString(RunTimes.getRunTimes()));
	}
}
