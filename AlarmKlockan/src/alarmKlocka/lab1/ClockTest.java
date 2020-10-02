package alarmKlocka.lab1;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClockTest {
	
	CounterType sekunder;
	CounterType minuter;
	CounterType timmar;
	
	boolean run;

	@BeforeEach
	void setUp() throws Exception {
		timmar  	= new Counter24();
		minuter 	= new Counter60(timmar);
		sekunder	= new Counter60(minuter); 
		run 		= true;
	}

	@AfterEach
	void tearDown() throws Exception {
		timmar 		= null;
		minuter 	= null;
		sekunder	= null;
		run			= false;
	}

	@Test
	void test() throws InterruptedException {
		
		while(run) {
			sekunder.count();
			Thread.sleep(100);
			System.out.println(timmar+":"+minuter + ":"+ sekunder);
		}
			
		
	}

}
