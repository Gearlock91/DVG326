package alarmKlocka.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import alarmKlocka.lab1.AbstractCounter.Direction;

class Counter60Test {
	
	private CounterType myCounter;
	private CounterType decreasingCounter;

	@BeforeEach
	void setUp() throws Exception {
		
		myCounter = new Counter60();
		decreasingCounter = new Counter60(Direction.DECREASING);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		myCounter = null;
		decreasingCounter = null;
	}

	@Test
	void test() throws InterruptedException {
		for(int i = 0; i < 60; i++) {		
			myCounter.count();
			System.out.println(myCounter.toString());
		}
		assertEquals(0, myCounter.getCount());
		
		for(int i = 60; i >= 0 ; i--) {
			decreasingCounter.count();
			System.out.println(decreasingCounter.toString());
		}
		assertEquals(59, decreasingCounter.getCount());
	}

}
