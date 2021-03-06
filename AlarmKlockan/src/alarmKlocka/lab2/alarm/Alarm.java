package alarmKlocka.lab2.alarm;


import java.util.Observable;

import alarmKlocka.lab2.time.TimeType;

@SuppressWarnings("deprecation")
public class Alarm  extends Observable implements AlarmType
  {
  private boolean active;
  private TimeType time;
  
  public Alarm(TimeType time)
    {
    setTime(time);
    setActive(true);
    }
  
  @Override
  public void setActive(boolean active)
    {
		  this.active = active; 
    }

  @Override
  public boolean isActive()
    {
	  return this.active;
    }

  @Override
  public void setTime(TimeType time)
    {
	  this.time = time;
    }

  @Override
  public TimeType getTime()
    {
	  return time;
    }

  @Override
  public void doAlarm()
    {
	  if(this.active)
		setChanged();
    	notifyObservers();
    }
  
  public String toString()
    {
	  return time.toString();
    }

  }
