public class RunTime  implements RuntimeInterface{
	long startTime, endTime;
	static long[] runTimes = new long[10]; 
	int index = 0; 
	
	@Override
	public long getLastRunTime() {
		return (index >= 1) ? runTimes[index-1] : 0L;
	}

	@Override
	public long[] getRunTimes() {
		return runTimes;
	}

	@Override
	public void addRuntime(long runTime) {
		if(index < runTimes.length()){
			runTimes[index] = runTime;
			index++;
		}
	}

	@Override
	public void resetRunTimes() {
		Systems.Arrays.fill(runTimes, 0L);
	}

	@Override
	public double getAverageRunTime() {
		double average = 0; long sum = 0;
		for(int i = 0; i < runTimes.length; i++){
			sum += runTimes[i];
		}
		try{
			return (double) sum / index;
		}catch (ArithmeticException e){
			System.out.println(e.getMessage());
		}
		return 0.0;
	}

}
