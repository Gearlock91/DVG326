package alarmKlocka.lab1;

public class Counter60 extends AbstractCounter {
	
	public Counter60() {
		super(60, Direction.INCREASING, null);
	}
	
	public Counter60(CounterType next) {
		super(60, Direction.INCREASING, next);
	}
	
	public Counter60(Direction dir) {
		super(60, dir, null);
	}
	public Counter60(Direction dir,CounterType next) {
		super(60, dir, next);
	}
}
