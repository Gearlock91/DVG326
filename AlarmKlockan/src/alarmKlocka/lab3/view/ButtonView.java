package alarmKlocka.lab3.view;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import alarmKlocka.lab2.alarm.Alarm;
import alarmKlocka.lab2.alarm.AlarmType;
import alarmKlocka.lab2.clock.AlarmClockType;
import alarmKlocka.lab2.clock.BadTimeFormat;
import alarmKlocka.lab2.time.Time;

public class ButtonView  extends JPanel  {

	private static final long serialVersionUID = 1L;
	private AlarmClockType			 clock;
	private DefaultListModel<String> listModel;
	private JList<String> 			 list;
	private AlarmPopUp 			     popUp;
	
	public ButtonView(AlarmClockType clock, AlarmPopUp popUp, DefaultListModel<String> listModel, JList<String> list) {
		add(addButtonHandler(clock,popUp,listModel,list));
	}

	public JPanel addButtonHandler(AlarmClockType clock, AlarmPopUp popUp, DefaultListModel<String> listModel, JList<String> list){
		
		this.popUp = popUp;
		this.clock = clock;
		this.list  = list;
		this.listModel = listModel;
		
		JPanel bField = new JPanel();
		bField.setLayout(new GridLayout(6,2));
		JButton setTime 	  	= new JButton("Set Time");
		JButton addAlarm 	  	= new JButton("Add Alarm");
		JButton activateAlarm 	= new JButton("Activate Alarm");
		JButton deactivateAlrm	= new JButton("Deactivate Alarm");
		JButton debugAlarm 	  	= new JButton("[Debug]Check Alarm");
		JButton removeAlarm   	= new JButton("Remove Alarm");
		JButton syncClock 	 	= new JButton("Sync Clock");

		setTime.addActionListener       (e -> {setTimeOnClock();});
		addAlarm.addActionListener      (e -> {addAlarmToList(JOptionPane.showInputDialog("Set Alarm \nFormat: Mon 12:30:00"));});
		removeAlarm.addActionListener   (e -> {removeAlarmFromList();});
		deactivateAlrm.addActionListener(e -> {setActiveAlarm(false);});	
		debugAlarm.addActionListener	(e -> {System.out.println(clock.getAlarms());});
		syncClock.addActionListener		(e -> {syncronizeClock();});
		activateAlarm.addActionListener (e -> {setActiveAlarm(true);});
		
		bField.add(debugAlarm);
		bField.add(activateAlarm);
		bField.add(setTime);
		bField.add(deactivateAlrm);
		bField.add(syncClock);
		bField.add(addAlarm);
		bField.add(removeAlarm);
		
		return bField;
	}
	private void setTimeOnClock() {
		try {
			String time = JOptionPane.showInputDialog("Set the current Time. \nFormat: Mon 12:30:00");
			if(time != null) {
				clock.setTime(new Time(time));
			}
		} catch (BadTimeFormat e) {
			JOptionPane.showMessageDialog(this, "Wrong input! Format: Mon 12:30:00", "Invalid time format", 0);
			setTimeOnClock();
		}
	}
	
	private void addAlarmToList(String alarm) {
		AlarmType holder;
		try {
			if(alarm != null) {
				holder = new Alarm(new Time(alarm));
				holder.addObserver(popUp);
				if(!listModel.contains(holder.toString())) {
					clock.addAlarm(holder);
					listModel.addElement(holder.toString());
				}
			}
		} catch (BadTimeFormat e) {
			JOptionPane.showMessageDialog(this, "Wrong input! Format: Mon 12:30:00", "Invalid time format", 0);
			addAlarmToList(JOptionPane.showInputDialog("Set Alarm \nFormat: Mon 12:30:00"));
		}
	}
	
	@SuppressWarnings("deprecation")
	private void removeAlarmFromList() {
		for(Object a : list.getSelectedValues()) {
			String selectedVal = (String) a;
			listModel.removeElementAt(list.getSelectedIndex());
			clock.removeAlarm(selectedVal);
		}
	}
	private void setActiveAlarm(Boolean setActive) {
		for(AlarmType a : clock.getAlarms()) {
			if(a.toString().equals(list.getSelectedValue())) {
				a.setActive(setActive);
				System.out.println(a.isActive());
			}
		}	
	}
	
	private void syncronizeClock() {
		SimpleDateFormat format = new SimpleDateFormat("E H:m:s", Locale.ENGLISH);
		try {
			clock.setTime(new Time(format.format((new Date(System.currentTimeMillis())))));
		} catch (BadTimeFormat e) {
			
		}
	}
}
