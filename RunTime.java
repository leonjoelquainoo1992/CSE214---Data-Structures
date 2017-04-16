public class RunTime  implements RuntimeInterface{
	long startTime, endTime;
	static long[] runTimes = new long[10]; //stores the run times

	@Override
	public long getLastRunTime() {
		int count = 0;
		for(int i = 0; i < runTimes.length; i++){
			if(runTimes[i] != 0L){
				count++;
			}
		}
		return (count >= 1) ? runTimes[count-1] : 0L;
	}

	@Override
	public long[] getRunTimes() {
		return runTimes;
	}

	@Override
	public void addRuntime(long runTime) {
		for(int i = 0; i < runTimes.length; i++){
			if(runTimes[i] == 0L){
				runTimes[i] = runTime;
				break;
			}
		}
	}

	@Override
	public void resetRunTimes() {
		for(int i = 0; i < getRunTimes().length; i++){
			runTimes[i] = 0L;
		}
	}

	@Override
	public double getAverageRunTime() {
		double average = 0; long sum = 0;
		int count = 0;
		for(int i = 0; i < runTimes.length; i++){
			if(runTimes[i] != 0L){
				count++; sum += runTimes[i];
			}
		}
		try{
			average = (double) sum / count;
		}catch (ArithmeticException e){
			System.out.println("Division by zero");
		}
		return average;
	}

}
