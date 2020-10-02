package alarmKlocka.lab3.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import alarmKlocka.lab2.alarm.AlarmType;
import alarmKlocka.lab2.clock.AlarmClockType;

public class AlarmPopUp  implements Runnable {

	private AlarmClockType clock;
	private JFrame parent;
	
	public AlarmPopUp(AlarmClockType clock, JFrame parent) {
		this.clock = clock;
		this.parent = parent;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!this.clock.getAlarms().isEmpty()) {	
				for(AlarmType a : this.clock.getAlarms()) {
					if(a.toString().equals(this.clock.getTime().toString()) && a.isActive() == true)
						JOptionPane.showMessageDialog(parent, "Alarm!", "Alarm", 1);;
				}	
			}
		}	
	}

}
