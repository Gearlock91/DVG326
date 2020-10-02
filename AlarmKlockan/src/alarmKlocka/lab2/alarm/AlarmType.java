package alarmKlocka.lab2.alarm;
import alarmKlocka.lab2.time.TimeType;

public interface AlarmType
  {
  public void setActive(boolean active);
  public boolean isActive();
  public void setTime(TimeType time);
  public TimeType getTime();
  public void doAlarm();
  }
