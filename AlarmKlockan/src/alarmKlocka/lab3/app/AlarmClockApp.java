package alarmKlocka.lab3.app;

import javax.swing.SwingUtilities;

import alarmKlocka.lab2.clock.BadTimeFormat;
import alarmKlocka.lab3.view.MainView;

public class AlarmClockApp {
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			try {
				new MainView();
			} catch (BadTimeFormat e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
}
