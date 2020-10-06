package alarmKlocka.lab3.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;


import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

import alarmKlocka.lab2.clock.AlarmClockType;


public class PanelView extends JPanel {

	private static final long serialVersionUID = 1L;
	private ClockTabLayouts 		 clockDrawn;
	private JList<String> 			 list;
	private AlarmPopUp popUp;
	private ButtonView bHandler;

	public PanelView(DefaultListModel<String> listModel,ClockTabLayouts clockDrawn, AlarmClockType clock) {

		this.clockDrawn = clockDrawn;
		this.list 		= new JList<String>(listModel);
		this.popUp 		= new AlarmPopUp(this);
		
		bHandler = new ButtonView(clock, popUp, listModel, list);
		
		this.setLayout(new GridLayout(2,1));
		this.add(northField());
		this.add(southField());
	}
	
	private JPanel northField() {
		JPanel field = new JPanel();
		field.setLayout(new GridLayout(1,1));
		field.add((Component) clockDrawn);
		field.setBackground(Color.gray);
		return field;
		
	}
	
	private JPanel southField() {
		JPanel  sField 		     = new JPanel();
		JTabbedPane listOfAlarms = new JTabbedPane();
		listOfAlarms.add("Active Alarms",alarmList());
		sField.setLayout(new GridLayout(2,1));
		sField.add(bHandler);
		sField.add(listOfAlarms);
		return sField;
	}

	private  JPanel alarmList() {
		JPanel alarmList = new JPanel();
		alarmList.setLayout(new GridLayout(1,1));
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(5);
		list.setToolTipText("Alarms activated");
		alarmList.add(list);
		return alarmList;
	}
}
