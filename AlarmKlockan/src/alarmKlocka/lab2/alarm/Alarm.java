package alarmKlocka.lab2.alarm;

import alarmKlocka.lab2.time.TimeType;

public class Alarm implements AlarmType
  {
  private boolean active;
  private TimeType time;
  
  public Alarm(TimeType time)
    {
    setTime(time);
    active = true;
    }
  
  @Override
  public void setActive(boolean active)
    {
	  if(!this.active)
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
    	System.err.println("Alarm! " + time.toString());
    }
  
  public String toString()
    {
	  return time.toString();
    }
  }
