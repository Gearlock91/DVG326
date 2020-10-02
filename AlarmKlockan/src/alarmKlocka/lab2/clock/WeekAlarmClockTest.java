package alarmKlocka.lab2.clock;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import alarmKlocka.lab2.alarm.*;
import alarmKlocka.lab2.time.Time;

class WeekAlarmClockTest {
	
	AlarmClockType klockan;
	AlarmType	   alarmEtt;
	AlarmType	   alarmTvå;
	
	@BeforeEach
	void setUp() throws Exception {
		klockan 	= new WeekAlarmClock(new Time(0,0,0,0));
		alarmEtt 	= new Alarm(new Time(1,12,0,0));
		alarmTvå 	= new Alarm(new Time(1,16,0,0));
	}

	@AfterEach
	void tearDown() throws Exception {
		klockan 	= null;
		alarmEtt 	= null;
		alarmTvå	= null;
	}

	@Test
	void test() {
		
		//Kontrollerar att klockan kan lägga till alarm.
		
			
		assertEquals(true, klockan.getAlarms().isEmpty());
		
		klockan.addAlarm(alarmEtt);
		klockan.addAlarm(alarmTvå);
		
			
		assertEquals(2, klockan.getAlarms().size());
		
		// Kontroll om alarmen fungerar
		
		
		assertEquals("Mon 00:00:00", klockan.getTime().toString());
		
		for(int i = 0; i < 172800; i++)
			klockan.tickTack();
		
		assertEquals(false, alarmEtt.isActive());
		assertEquals(false, alarmTvå.isActive());
		
		assertEquals("Wed 00:00:00", klockan.getTime().toString());
		
		// Ta ta bort alarmen och ställer om klockan till Tisdag 00:00:00
		
		try {
			klockan.setTime(new Time(2,0,0,0));
		} catch (BadTimeFormat e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		klockan.removeAlarm(alarmEtt);
		klockan.removeAlarm(alarmTvå);
		
		assertEquals(0, klockan.getAlarms().size());
		
		assertEquals("Wed 00:00:00", klockan.getTime().toString());	
		
		for(int i = 0; i < 86400; i++)
			klockan.tickTack();
		
		assertEquals("Thu 00:00:00", klockan.getTime().toString());
		
		// Kontrollerar felhanteringen om BadTimeFormat
		
		try {
			klockan.setTime(new Time(-1,0,0,0));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(7,0,0,0));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(0,-1,0,0));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(0,25,0,0));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(0,0,-1,0));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(0,0,60,0));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(0,0,0,-1));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		try {
			klockan.setTime(new Time(0,0,0,60));
		} catch (BadTimeFormat e) {
			System.out.println(e);
		}
		
		klockan.setTime(new Time("Mon 00:00:00"));
		
		assertEquals("Mon 00:00:00", klockan.getTime().toString());
		
	}
	
}
