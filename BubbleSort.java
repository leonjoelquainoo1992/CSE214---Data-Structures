public class BubbleSort extends RunTime implements SortInterface {
	
	@Override
	public void sort(Integer[] arrayToSort) {
		boolean flag = true;
		startTime = System.nanoTime();
			for (int index = arrayToSort.length - 1; index >= 0 && flag; index--) {
				flag = false;
				for(int i = 0; i < index; i++) {
					if(arrayToSort[i] > arrayToSort[i+1]){
						Integer temp = arrayToSort[i];
						arrayToSort[i] = arrayToSort[i+1];
						arrayToSort[i+1] = temp;
						flag = true;
					}
				}
		}
		endTime = System.nanoTime();
		addRuntime(endTime - startTime);
	}
}
