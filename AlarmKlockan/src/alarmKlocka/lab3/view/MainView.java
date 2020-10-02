package alarmKlocka.lab3.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

import alarmKlocka.lab2.clock.AlarmClockType;
import alarmKlocka.lab2.clock.BadTimeFormat;
import alarmKlocka.lab2.clock.WeekAlarmClock;
import alarmKlocka.lab2.time.Time;

public class MainView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private int 					 width = 400; 
	private int						 height = 800;
	private SimpleDateFormat 		 format 			= new SimpleDateFormat("E H:m:s", Locale.ENGLISH); // Hämtat utifrån https://stackabuse.com/how-to-get-current-date-and-time-in-java/
	private AlarmClockType 	 		 clock 				= new WeekAlarmClock(new Time(format.format(new Date(System.currentTimeMillis())))); 
	private ClockTabLayouts  		 digClock			= new DrawDigitalClock(clock);
	private ClockTabLayouts  		 algClock			= new DrawAnalogClock(clock);
	private JTabbedPane		 		 tabbedPane 		= new JTabbedPane();
	private DefaultListModel<String> listModel 			= new DefaultListModel<String>();
	
	public MainView() throws BadTimeFormat {
		super("Alarmclock");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		Timer timer = new Timer(1000, e -> {
			clock.tickTack();
			digClock.reSuperPaint();
			algClock.reSuperPaint();
		});
		
		timer.start();

		this.add(tabbedPane);
		tabbedPane.addTab("Digital clock", new PanelLayout(listModel,digClock,clock));
		tabbedPane.addTab("Analog clock",  new PanelLayout(listModel,algClock,clock));
		
	}
	
}
