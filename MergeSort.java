@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<? super T>>extends RunTime implements SortInterface<T>{

	@Override
	public void sort(T[] arrayToSort) {
		long startTime = System.nanoTime();
		mergeSort(arrayToSort);
		long endTime = System.nanoTime();
		addRuntime(endTime - startTime);
	}

	private static<T extends Comparable<? super T>> void mergeSort(T[] array){
		if(array.length > 1){
			int midPos = array.length / 2;
			T[] firstHalfArray = ((T[]) new Comparable<?>[midPos]);
			T[] lastHalfArray = (T[]) new Comparable<?>[array.length - midPos];
			firstHalfArray = java.util.Arrays.copyOfRange(array, 0, midPos);
			lastHalfArray = java.util.Arrays.copyOfRange(array, midPos, array.length);
			mergeSort(firstHalfArray);
			mergeSort(lastHalfArray);
			merge(array, firstHalfArray, lastHalfArray);
		}
	}

	private static<T extends Comparable<? super T>> void merge(T[] array, T[] firstHalfArray, T[] lastHalfArray) {
		int firstHalfArrayIndex = 0, lastHalfArrayIndex = 0, indexOfArray = 0;
		while(firstHalfArrayIndex < firstHalfArray.length && (lastHalfArrayIndex < lastHalfArray.length)){
			if(firstHalfArray[firstHalfArrayIndex].compareTo(lastHalfArray[lastHalfArrayIndex]) < 0){
				array[indexOfArray] = firstHalfArray[firstHalfArrayIndex];
				firstHalfArrayIndex++;
			}
			else{
				array[indexOfArray] = lastHalfArray[lastHalfArrayIndex];
				lastHalfArrayIndex++;
			}
			indexOfArray++;
		}
		while(firstHalfArrayIndex < firstHalfArray.length){
			array[indexOfArray] = firstHalfArray[firstHalfArrayIndex];
			firstHalfArrayIndex++; indexOfArray++;
		}
		while(lastHalfArrayIndex < lastHalfArray.length){
			array[indexOfArray] = lastHalfArray[lastHalfArrayIndex];
			lastHalfArrayIndex++; indexOfArray++;
		}
	}

}
