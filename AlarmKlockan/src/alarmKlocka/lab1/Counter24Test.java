package alarmKlocka.lab1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Counter24Test {
	
	private CounterType timmar;
	
	@BeforeEach
	void setUp() throws Exception {
		
		timmar = new Counter24();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		timmar = null;
	}

	@Test
	void test() {
		
		for(int i = 0; i < 24; i++) {
			timmar.count();
			System.out.println(timmar.toString());
		}
		assertEquals(0, timmar.getCount());
		
	}

}
