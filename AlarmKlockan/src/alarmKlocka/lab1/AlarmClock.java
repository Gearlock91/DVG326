package alarmKlocka.lab1;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlarmClock {

	private CounterType sekunder;
	private CounterType minuter;
	private CounterType timmar; 
	
	@BeforeEach
	void setUp() throws Exception {
		timmar = new Counter24();
		minuter = new Counter60(timmar);
		sekunder = new Counter60(minuter);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		minuter = null;
		timmar = null;
		sekunder = null;
	}

	@Test
	void test() {
		
		for(int i = 0; i < 86400; i++) { //86400 (Ett helt dygn)
			sekunder.count();
			System.out.println(timmar.toString() + ":" + minuter.toString() + ":" + sekunder.toString());
			
		}
		assertEquals(00, timmar.getCount());
		assertEquals(00, minuter.getCount());
		assertEquals(00, sekunder.getCount());
	}
}
