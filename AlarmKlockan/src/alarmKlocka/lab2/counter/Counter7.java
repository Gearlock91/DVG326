package alarmKlocka.lab2.counter;

public class Counter7 extends SettableCounter {
	
	public Counter7() {
		this(7, Direction.INCREASING, null);
	}
	
	public Counter7(Direction direction) {
		this(7,direction,null);		
	}
	
	public Counter7(SettableCounterType next) {
		this(7,Direction.INCREASING, next);
	}
	
	public Counter7(int maxNrOfConunts, Direction direction, SettableCounterType nextCounter) {
		super(maxNrOfConunts, direction, nextCounter);
	}

}
