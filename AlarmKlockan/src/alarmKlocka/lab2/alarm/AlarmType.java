package alarmKlocka.lab2.alarm;
import java.util.Observer;

import alarmKlocka.lab2.time.TimeType;

@SuppressWarnings("deprecation")
public interface AlarmType
  {
  public void setActive(boolean active);
  public boolean isActive();
  public void setTime(TimeType time);
  public TimeType getTime();
  public void doAlarm();
  public void addObserver(Observer o);
  }
