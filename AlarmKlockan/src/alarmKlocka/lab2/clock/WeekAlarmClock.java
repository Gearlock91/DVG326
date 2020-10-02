package alarmKlocka.lab2.clock;

import java.util.Collection;

import alarmKlocka.lab2.alarm.*;
import alarmKlocka.lab2.counter.*;
import alarmKlocka.lab2.time.*;

public class WeekAlarmClock implements AlarmClockType{
	
	
	private SettableCounterType days 		= new Counter7();
	private SettableCounterType hour 		= new Counter24(days);
	private SettableCounterType minutes 	= new Counter60(hour);
	private SettableCounterType seconds 	= new Counter60(minutes);
	private AlarmManager 		alarmMng 	= new AlarmManager();
	
	public WeekAlarmClock() throws BadTimeFormat {
		this(new Time(0,0,0,0));
	}
	
	public WeekAlarmClock(TimeType time) {
		setTime(time);
		
	}
		
	@Override
	public void tickTack() {
		seconds.count();
		alarmMng.checkForAlarm(getTime());
	}

	@Override
	public void setTime(TimeType time){
		seconds.setCount(time.getSecond());
		minutes.setCount(time.getMinute());
		hour.setCount(time.getHour());
		days.setCount(time.getDay());		
		
	}

	@Override
	public void addAlarm(AlarmType alarm) {
		alarmMng.addAlarm(alarm);
	}

	@Override
	public void removeAlarm(AlarmType alarm) {
		alarmMng.removeAlarm(alarm);
		
	}
	public void removeAlarm(String alarm) {
		alarmMng.removeAlarm(alarm);
	}

	@Override
	public Collection<AlarmType> getAlarms() {
		return alarmMng.getAlarms();
	}

	@Override
	public TimeType getTime() {
		Time currentTime;
		try {
			currentTime = new Time(days.getCount(),hour.getCount(),minutes.getCount(),seconds.getCount());
		} catch (BadTimeFormat e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			currentTime = null;
		}
		return currentTime;
	}
	
	public String toString() {
		return getTime().toString();
	}

}
