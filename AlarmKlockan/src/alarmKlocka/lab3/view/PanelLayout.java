package alarmKlocka.lab3.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import alarmKlocka.lab2.alarm.Alarm;
import alarmKlocka.lab2.alarm.AlarmType;
import alarmKlocka.lab2.clock.AlarmClockType;
import alarmKlocka.lab2.time.Time;

public class PanelLayout extends JPanel {

	private static final long serialVersionUID = 1L;
	private AlarmClockType			 clock;
	private ClockTabLayouts 		 clockDrawn;
	private DefaultListModel<String> listModel;
	private JList<String> 			 list;
	private AlarmPopUp popUp;
	
	
	
	public PanelLayout(DefaultListModel<String> listModel,ClockTabLayouts clockDrawn, AlarmClockType clock) {
		this.clock 		= clock;
		this.clockDrawn = clockDrawn;
		this.listModel 	= listModel;
		this.list 		= new JList<String>(listModel);
		popUp = new AlarmPopUp(this);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(northField());
	}
	
	private JPanel northField() {
		JPanel field = new JPanel();
		field.setLayout(new GridLayout(2,1));
		field.add((Component) clockDrawn);
		field.add(southField());
		field.setBackground(Color.gray);
		return field;
		
	}
	
	private JPanel southField() {
		JPanel  sField 		  = new JPanel();
		JTabbedPane listOfAlarms = new JTabbedPane();
	
		listOfAlarms.add("Active Alarms",alarmList());
		
		sField.setLayout(new GridLayout(2,1));
		sField.add(buttonField());
		sField.add(listOfAlarms);
		return sField;
	}
	
	private JPanel buttonField() {
		JPanel bField = new JPanel();
		bField.setLayout(new GridLayout(6,2));
		JButton setTime 	  = new JButton("Set Time");
		JButton addAlarm 	  = new JButton("Add Alarm");
		JButton activateAlarm = new JButton("Activate Alarm");
		JButton deactivateAlrm= new JButton("Deactivate Alarm");
		JButton rmAllAlrm 	  = new JButton("Remove all Alarms");
		JButton debugAlarm 	  = new JButton("[Debug]Check Alarm");
		JButton removeAlarm   = new JButton("Remove Alarm");
		
		setTime.addActionListener(	  	 e -> {clock.setTime(new Time(JOptionPane.showInputDialog("Set the current Time")));});
		addAlarm.addActionListener(	  	 e -> {addAlarmToList(JOptionPane.showInputDialog("SetAlarm"));});
		removeAlarm.addActionListener(	 e -> {removeAlarmFromList();});
		deactivateAlrm.addActionListener(e -> {deactivateAlarm();});	
		debugAlarm.addActionListener(	 e -> {System.out.println(clock.getAlarms());});
		rmAllAlrm.addActionListener(     e -> {listModel.removeAllElements();clock.getAlarms().clear();} ); 
		
		bField.add(debugAlarm);
		bField.add(activateAlarm);
		bField.add(setTime);
		bField.add(deactivateAlrm);
		bField.add(rmAllAlrm);
		bField.add(addAlarm);
		bField.add(removeAlarm);
		
		return bField;
	}
	
	private  JPanel alarmList() {
		
		JPanel alarmList = new JPanel();
		
		alarmList.setLayout(new GridLayout(1,1));
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(5);
		list.setToolTipText("Alarms activated");
		
		alarmList.add(list);
		
		return alarmList;
	}
	
	private void addAlarmToList(String alarm) {
		AlarmType holder = new Alarm(new Time(alarm), popUp);
		
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
	private void deactivateAlarm() {
		
		for(AlarmType a : clock.getAlarms()) {
			if(a.toString().equals(list.getSelectedValue())) {
				a.setActive(false);;
				System.out.println(a.isActive());
			}
			
		}
		
	}
}
