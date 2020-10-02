package alarmKlocka.lab2.counter;

public class SettableCounter extends AbstractCounter implements SettableCounterType{

	public SettableCounter(int maxNrOfCounts, Direction direction, CounterType nextCounter) {
		super(maxNrOfCounts, direction, nextCounter);
		
	}

	@Override
	public void setCount(int value) {
			currentCount = value;
	}

}
