package alarmKlocka.lab2.counter;

public class Counter24 extends SettableCounter {

	public Counter24() {
	   super(24, Direction.INCREASING, null);
	}

	public Counter24(CounterType next) {
		super(24, Direction.INCREASING, next);
	}
	
	public Counter24(Direction dir) {
		super(24, dir, null);
	}
	public Counter24(Direction dir,CounterType next) {
		super(24, dir, next);
	}
}
