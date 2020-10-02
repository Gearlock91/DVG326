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
import alarmKlocka.lab2.time.Time;

public class ButtonView extends JPanel {

	private static final long serialVersionUID = 1L;
	private AlarmClockType			 clock;
	private DefaultListModel<String> listModel;
	private JList<String> 			 list;
	private AlarmPopUp 			     popUp;
	
	public ButtonView(AlarmClockType clock, AlarmPopUp popUp, DefaultListModel<String> listModel, JList<String> list) {
		add(addButtonHandler(clock,popUp,listModel,list));
	}

	public JPanel addButtonHandler(AlarmClockType clock, AlarmPopUp popUp, DefaultListModel<String> listModel, JList<String> list) {
		
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
		JButton rmAllAlrm 	  	= new JButton("Remove all Alarms");
		JButton debugAlarm 	  	= new JButton("[Debug]Check Alarm");
		JButton removeAlarm   	= new JButton("Remove Alarm");
		JButton syncClock 	 	= new JButton("Sync Clock");
		
		SimpleDateFormat format = new SimpleDateFormat("E H:m:s", Locale.ENGLISH);
		
		setTime.addActionListener(	  	 e -> {clock.setTime(new Time(JOptionPane.showInputDialog("Set the current Time")));});
		addAlarm.addActionListener(	  	 e -> {addAlarmToList(JOptionPane.showInputDialog("SetAlarm"));});
		removeAlarm.addActionListener(	 e -> {removeAlarmFromList();});
		deactivateAlrm.addActionListener(e -> {setActiveAlarm(false);});	
		debugAlarm.addActionListener(	 e -> {System.out.println(clock.getAlarms());});
		rmAllAlrm.addActionListener(     e -> {listModel.removeAllElements();clock.getAlarms().clear();} ); 
		syncClock.addActionListener(     e -> {clock.setTime(new Time(format.format((new Date(System.currentTimeMillis())))));});
		activateAlarm.addActionListener( e -> {setActiveAlarm(true);});
		
		bField.add(debugAlarm);
		bField.add(activateAlarm);
		bField.add(setTime);
		bField.add(deactivateAlrm);
		bField.add(syncClock);
		bField.add(addAlarm);
		bField.add(rmAllAlrm);
		bField.add(removeAlarm);
		
		return bField;
	}
	private void addAlarmToList(String alarm) {
		AlarmType holder = new Alarm(new Time(alarm));
		holder.addObserver(popUp);
		
		if(!listModel.contains(holder.toString())) {
			clock.addAlarm(holder);
			listModel.addElement(holder.toString());
		}
	}
	
	private void removeAlarmFromList() {
		String selectedVal = list.getSelectedValue();
		
		listModel.removeElementAt(list.getSelectedIndex());
		clock.removeAlarm(selectedVal);
	}
	private void setActiveAlarm(Boolean setActive) {
		for(AlarmType a : clock.getAlarms()) {
			if(a.toString().equals(list.getSelectedValue())) {
				a.setActive(setActive);
				System.out.println(a.isActive());
			}
		}	
	}
}
