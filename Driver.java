import java.util.Arrays;
public class Driver implements DriverInterface {
	RunTime RunTimes = new RunTime();
	Driver Driver = new Driver();

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
		int[] targetArray = {500, 10000, 100000, 1000000, 5000000, 7500000, 10000000};
		return targetArray;
	}

	@Override
	public RunTime runLinearSearch(int[] listOfNumbers, int target, int numberOfTimes) {
		RunTime linearSearchRunTime = new RunTime();
		LinearSearch linSearch = new LinearSearch();
		linearSearchRunTime.resetRunTimes();
		for (int i = 1; i <= numberOfTimes; i++) {
			linSearch.search(listOfNumbers, target);
		}
		return linearSearchRunTime;
	}

	@Override
	public RunTime runBinarySearch(int[] listOfNumbers, int target, int numberOfTimes) {
		BinarySearch binSearch = new BinarySearch();
		RunTime binarySearchRunTime = new RunTime();
		binarySearchRunTime.resetRunTimes();
		for (int i = 0; i < numberOfTimes; i++) {
			binSearch.search(listOfNumbers, target);
		}
		return binarySearchRunTime;
	}

	public static void main(String[] args) {
		// Testing LinearSearch Class
		System.out.print("RunTimes for Linear Search: ... ");
		int numberOfTimes = 10;
		for(int x = 0; x < Driver.getTargets().length; x++){
			for (int i = 0; i < numberOfTimes; i++) {
				Driver.runLinearSearch(Driver.getListOfNumbers(), Driver.getTargets()[x], i);
			}
			System.out.printf(Arrays.toString(RunTimes.getRunTimes())+ "Average = " + RunTimes.getAverageRunTime());
			System.out.println("Last Run Time: " + RunTimes.getLastRunTime());
		}

		System.out.println("\n");

		// Testing BinarySearch Class
		System.out.print("RunTimes for Binary Search: ... ");
		for(int x = 0; x < Driver.getTargets().length; x++){
			for (int i = 0; i < numberOfTimes; i++) {
				Driver.runBinarySearch(Driver.getListOfNumbers(), Driver.getTargets()[x], i);
			}
			System.out.printf(Arrays.toString(RunTimes.getRunTimes())+ "Average = " + RunTimes.getAverageRunTime());
			System.out.println("Last Run Time: " + RunTimes.getLastRunTime());
		}
	}
}
