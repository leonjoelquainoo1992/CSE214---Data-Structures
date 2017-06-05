
public class HeapSort <T extends Comparable<? super T>> extends RunTime implements SortInterface<T> {

	@Override
	public void sort(T[] arrayToSort) {
		long startTime = System.nanoTime();
		for (int i = (arrayToSort.length / 2) - 1; i >= 0; i--){
			heapify(arrayToSort, arrayToSort.length, i);
		}
		for(int i =  arrayToSort.length - 1; i >= 0; i--){
			T tempVal = arrayToSort[0];
			arrayToSort[0] = arrayToSort[i];
			arrayToSort[i] = tempVal;
			heapify(arrayToSort, i, 0); //Heapifying reduced heap
		}
		long endTime = System.nanoTime();
		addRuntime(endTime - startTime);
	}
	
	private static <T extends Comparable<? super T>> void heapify(T[] array, int length, int index){
		int root = index, left = 2*index + 1, right = 2*index + 2;
		if(left < length && array[root].compareTo(array[left]) < 0){//left > root
			root = left;
		}
		if(right < length && array[root].compareTo(array[right]) < 0){//right > root
			root = right;
		}
		if(root != index){
			swap(array, index, root);
			heapify(array, length, root); //recursively heapify affected subtree
		}
	}
	
	private static<T extends Comparable<? super T>>void swap(T[] array, int index1, int index2){
		T tempVal = array[index1];
		array[index1] = array[index2];
		array[index2] = tempVal;
	}

}
