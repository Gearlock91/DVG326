package alarmKlocka.lab1;

public abstract class AbstractCounter implements CounterType {

	protected enum Direction {INCREASING, DECREASING}; 
	private int currentCount;
	private boolean isPaused; 
	// private final boolean IS_CIRCULAR; 
	private final int MAX_NR_OF_COUNTS;
	private Direction direction;
	private CounterType nextCounter;
	
	
	public AbstractCounter(int maxNrOfCounts, Direction direction, CounterType nextCounter){ 
//		if (maxNrOfCounts >= 2){
//			this.MAX_NR_OF_COUNTS = maxNrOfCounts;
//			this.IS_CIRCULAR = true;  
//		}
//		else{
//		
//			this.MAX_NR_OF_COUNTS = 0;
//			this.IS_CIRCULAR = false;
//		}
		
		this.MAX_NR_OF_COUNTS = maxNrOfCounts;
		this.direction = direction;
		this.nextCounter = nextCounter;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public void count() {
		if (!isPaused){
		
			if (direction == Direction.INCREASING){
				currentCount ++;		
				
				if ( /*IS_CIRCULAR &&*/ (currentCount >= MAX_NR_OF_COUNTS)){
					reset();
					if(nextCounter != null)
						nextCounter.count();
					
				}
			}
			else if (direction == Direction.DECREASING){
					
				if(/*IS_CIRCULAR &&*/ (currentCount == 0)) {
					currentCount = MAX_NR_OF_COUNTS;
					if(nextCounter != null)
							nextCounter.count();
				}
				currentCount--;	
			}
		}
	}

	@Override
	public int getCount() {
		return  this.currentCount;
	}

	@Override
	public void reset() {
		this.currentCount = 0;
	}

	@Override
	public void pause() {
		this.isPaused = true;
		
	}

	@Override
	public void resume() {
		this.isPaused = false;
		
	}
	
	public String toString()
	{
		return String.format("%02d", currentCount); 

	}

}
