public class SelectionSort extends RunTime implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
		startTime = System.nanoTime();
		for (int index = arrayToSort.length - 1; index > 0; index--) {
			int first = 0;
			for (int i = 1; i <= index; i++) {
				if (arrayToSort[i] > arrayToSort[first]) {
					first = i;
				}
			}
			swap(arrayToSort, first, index);
		}
		endTime = System.nanoTime();
		addRuntime(endTime - startTime);
	}

	public static void swap(Integer[] array, int x, int y) {
		Integer temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
