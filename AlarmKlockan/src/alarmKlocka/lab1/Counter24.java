package alarmKlocka.lab1;

public class Counter24 extends AbstractCounter {

	public Counter24() {
		this(null);     //super(24, Direction.INCREASING, null);
	}

	public Counter24(CounterType next) {
		super(24, Direction.INCREASING, next);
	}
	
//	public Counter24(Direction dir) {
//		super(24, dir, null);
//	}
//	public Counter24(Direction dir,CounterType next) {
//		super(24, dir, next);
//	}
}
