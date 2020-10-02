package alarmKlocka.lab2.counter;

public class Counter60 extends SettableCounter {
	
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
