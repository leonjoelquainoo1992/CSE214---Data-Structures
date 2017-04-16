public class BinarySearch extends RunTime implements SearchInterface {
	 RunTime runTime = new RunTime();

	@Override
	public int search(int[] listOfNumbers, int target) {
		return search(listOfNumbers, target, 0, listOfNumbers.length - 1);
	}


	public int search(int[] array, int target, int start, int end){
		startTime = System.nanoTime();
		if(start <= end){
			int midPoint = (start + end) / 2 ;
			if(array[midPoint] == target){
				endTime = System.nanoTime();
				runTime.addRuntime(endTime - startTime);
				return midPoint;
			}
			else{
				if(target > array[midPoint]){
					return search(array, target, midPoint + 1, end);
				}
				else{
					return search(array, target, start, midPoint - 1);
				}
			}
		}
		else{
			endTime = System.nanoTime();
			runTime.addRuntime(endTime - startTime);
			return -1;
		}
	}
}
