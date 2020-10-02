package lekstugan.swing;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class counterTest {
	
	counter time;
	
	boolean run;

	@BeforeEach
	void setUp() throws Exception {
		
		time = new counter();
		run	 = true;
	}

	@AfterEach
	void tearDown() throws Exception {
		
		time = null;
		run	 = false;
	}

	@Test
	void test() throws InterruptedException {	
		while(run) {
			time.time();
			System.out.println(time.toString());
		}
			
	}

}
