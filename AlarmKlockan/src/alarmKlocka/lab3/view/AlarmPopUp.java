package alarmKlocka.lab3.view;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("deprecation")
public class AlarmPopUp  implements Observer, Runnable {

	
	private JPanel parent;
	
	public AlarmPopUp( JPanel parent) {
		this.parent = parent;
	}

	@Override
	public void update(Observable o, Object arg) {
		Thread thread = new Thread(this);
		
		thread.start();
	}

	@Override
	public void run() {
		JOptionPane.showMessageDialog(parent, "Alarm!", "Alarm", 1);	
	}

}
