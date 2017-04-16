
public class InsertionSort extends RunTime implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
		startTime = System.nanoTime();
		for (int index = 1; index < arrayToSort.length; index++) {
			int number = arrayToSort[index]; int j;
			for (j = index; j > 0 && arrayToSort[j - 1] > number; j--) {
				arrayToSort[j] = arrayToSort[j - 1];
			}
			arrayToSort[j] = number;
		}
		endTime = System.nanoTime();
		addRuntime(endTime - startTime);
	}
}
