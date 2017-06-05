
public class QuickSort <T extends Comparable<? super T>>extends RunTime implements SortInterface<T>{

	@Override
	public void sort(T[] arrayToSort) {
		long startTime = System.nanoTime();
		quickSort(arrayToSort, 0, arrayToSort.length-1);
		long endTime = System.nanoTime();
		addRuntime(endTime - startTime);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T extends Comparable<? super T>> void quickSort(T[] array, int first, int last){
		int i,j,left = 0,right = array.length - 1,stack_pointer = -1;
		int[] stack = new int[128];
		Comparable swap,temp;
		while(true){
			if(right - left <= 7){
				for(j=left+1;j<=right;j++){
					swap = array[j];
					i = j-1;
					while(i>=left && array[i].compareTo((T) swap) > 0)
						array[i+1] = array[i--];
					array[i+1] = (T) swap;
				}
				if(stack_pointer == -1)
					break;
				right = stack[stack_pointer--];
				left = stack[stack_pointer--];
			}else{
				int median = (left + right) >> 1;
				i = left + 1;
				j = right;
				swap = array[median]; array[median] = array[i]; array[i] = (T) swap;
				if(array[left].compareTo(array[right]) > 0){
					swap = array[left]; array[left] = array[right]; array[right] = (T) swap;
				}if(array[i].compareTo(array[right]) > 0){
					swap = array[i]; array[i] = array[right]; array[right] = (T) swap;
				}if(array[left].compareTo(array[i]) > 0){
					swap = array[left]; array[left] = array[i]; array[i] = (T) swap;
				}
				temp = array[i];
				while(true){
					do i++; while(array[i].compareTo((T) temp) < 0);
					do j--; while(array[j].compareTo((T) temp) > 0);
					if(j < i)
						break;
					swap = array[i]; array[i] = array[j]; array[j] = (T) swap;
				}
				array[left + 1] = array[j];
				array[j] = (T) temp;
				if(right-i+1 >= j-left){
					stack[++stack_pointer] = i;
					stack[++stack_pointer] = right;
					right = j-1;
				}else{
					stack[++stack_pointer] = left;
					stack[++stack_pointer] = j-1;
					left = i;
				}
			}
		}
	}


	@SuppressWarnings("unused")
	private static<T extends Comparable<? super T>>void swap(T[] array, int index1, int index2){
		T tempVal = array[index1];
		array[index1] = array[index2];
		array[index2] = tempVal;
	}

	public static void main(String[] args) {
		QuickSort<Integer> quickSort = new QuickSort<>();
		Integer[] arrayToSort = new Integer[10];
		java.util.Random random = new java.util.Random();
		for(int i = 0; i < arrayToSort.length; i++){
			arrayToSort[i] = random.nextInt(1000);
		}
		System.out.println(java.util.Arrays.toString(arrayToSort));
		quickSort.sort(arrayToSort);
		System.out.println(java.util.Arrays.toString(arrayToSort));
	}

}
