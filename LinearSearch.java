
public class LinearSearch extends RunTime implements SearchInterface{
	RunTime runTime = new RunTime();
	
	@Override
	public int search(int[] listOfNumbers, int target){
		startTime = System.nanoTime();
		for(int index = 0; index < listOfNumbers.length; index++){
			if(listOfNumbers[index] == target){
				endTime = System.nanoTime();
				runTime.addRuntime(endTime - startTime);
				return index;
			}
		}
		endTime = System.nanoTime();
		runTime.addRuntime(endTime - startTime);
		return -1;
	}
	
}
